package fr.eni.projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.ihm.modele.Chargement;

/**
 * Servlet implementation class ServletSupprimerCompte
 */
@WebServlet("/SupprimerCompte")
public class ServletSupprimerCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération de la session
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		// Récupération de l'utilisateur de la session pour le log de deconnexion
		Utilisateur utilisateur = null;
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e1) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e1.printStackTrace();
		}
		// Création d'un utilisateur sans données
		Utilisateur utilisateurSuppresion = new Utilisateur("Utilisateur Supprimé", "", "", "", "", "", "", "", "", 0,
				false);
		// Affecter le numero d'utilisateur de la session à l'utilisateur sans données
		utilisateurSuppresion.setNoUtilisateur(noUtilisateur);
		try {
			// Modification de l'utisilateur avec l'utilisateur sans données
			UtilisateurMgr.modificationUtilisateur(utilisateurSuppresion);
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		// Log de déconnexion
		Logger monLogger = (Logger) LoggerFactory.getLogger("fr.eni.ProjectEnchereEni");
		monLogger.info("Deconnexion et Suppression : " + utilisateur.getPseudo());
		// Destruction de la session
		session.invalidate();
		// Chargement des listes à afficher par default et retour à la page d'accueil
		request = Chargement.chargementListArticle(request, response);
		request = Chargement.chargementListCategorie(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
