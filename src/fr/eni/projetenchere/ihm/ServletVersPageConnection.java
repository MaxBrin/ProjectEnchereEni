package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class ServletVersPageConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des paramatres saisies par l'utilisateur
		String identifiant = request.getParameter("identifiant");
		String mdp = request.getParameter("motDePasse");
		// Récupération de la liste des utilisateurs
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		try {
			listeUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		// HasMap utilisé pour afficher un message d'erreur
		HashMap<String, String> erreurs = new HashMap<>();
		// Initialisation d'un boolean pour la présence de l'identifiant
		boolean identifiantPresent = false;
		// Parcour de la liste des utilisateurs
		for (Utilisateur utilisateur : listeUtilisateur) {

			if (!identifiant.equals("")) {
				// Vérifiaction si l'identifiant est le pseudo ou l'email
				if ((utilisateur.getEmail().equals(identifiant) || utilisateur.getPseudo().equals(identifiant))) {
					// Identifiant trouvé
					identifiantPresent = true;
					// Vérification du mot de passe
					if (utilisateur.getMotDePasse().equals(mdp) && mdp.length() > 0) {
						// Log de Connection
						Logger monLogger = (Logger) LoggerFactory.getLogger("fr.eni.ProjectEnchereEni");
						monLogger.info("Connexion : " + utilisateur.getPseudo());
						// Création d'une session et stokage du numéro d'utilisateur dans la session
						HttpSession session = request.getSession();
						session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
						// Chargement des listes à afficher sur la pages d'accueil
						request = Chargement.chargementListArticle(request, response);
						request = Chargement.chargementListCategorie(request, response);
						// Envoie sur la page d'accueil après la connexion réussie
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
						rd.forward(request, response);
					} else {
						// Si le mot de passe est invalide stokage d'une clé et d'un message dans la
						// HasMap
						erreurs.put("motDePasseInvalide", "Le mot de passe est incorrect. ");
						// Envoie de la HasMap à la page de connexion
						request.setAttribute("listeErreurs", erreurs);
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
						rd.forward(request, response);
					}
				}
			}
		}
		if (!identifiantPresent) {
			// Si l'identifiant est inconnu stockage d'une clé et d'un message dans la
			// HasMap
			erreurs.put("IdentifiantInvalide", "L'identifiant est inconnu. ");
			// Envoie de la HasMap à la page de connexion
			request.setAttribute("listeErreurs", erreurs);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnexion.jsp");
			rd.forward(request, response);
		}

	}

}
