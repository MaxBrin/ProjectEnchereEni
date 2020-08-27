package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.HashMap;

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
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class ServletVersCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des paramètres saisies par l'utilisateur
		String pseudo = request.getParameter("pseudo").trim();
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String email = request.getParameter("email").trim();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim();
		String codePostal = request.getParameter("codePostal").trim();
		String ville = request.getParameter("ville").trim();
		ville = ville.toUpperCase();
		String motDePasse = request.getParameter("motDePasse").trim();
		String confirmationMdp = request.getParameter("confirmerMotDePasse").trim();
		// Initialisation d'un utilisateur avec ces paramètres
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, 100, false);
		// Si les mot de passe ne sont pas identiques on met le mot de passe de
		// l'utilisateur à null
		if (!(motDePasse.equals(confirmationMdp))) {
			utilisateur.setMotDePasse(null);
		}
		// HasMap pour gérer les erreurs avec la méthode verifierUtilisateur
		HashMap<String, String> erreurs = UtilisateurMgr.verifierUtilisateur(utilisateur);
		RequestDispatcher rd;
		// Si la HasMap est vide il n'y a pas d'erreur
		if (erreurs.isEmpty()) {
			// Ajout de l'utilisateur dans la base de donnée
			try {
				UtilisateurMgr.ajoutUtilisateur(utilisateur);
			} catch (BLLException e) {
				// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
				request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
				e.printStackTrace();
			}
			// Log de connexion
			Logger monLogger = (Logger) LoggerFactory.getLogger("fr.eni.ProjectEnchereEni");
			monLogger.info("Connexion : " + utilisateur.getPseudo());
			// Création de la session et le numéro de l'utilisateur est stocké dans la
			// session
			HttpSession session = request.getSession();
			session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
			// Chargement des listes à afficher
			request = Chargement.chargementListArticle(request, response);
			request = Chargement.chargementListCategorie(request, response);
			// Checkbox à cocher par default
			request.setAttribute("choixAchat", "achat");
			request.setAttribute("ckEncheresOuvertesCheck", true);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");

		} else {
			// Si il y'a des erreurs on renvoie les données saisies et le Hasmap pour
			// afficher les erreurs
			request.setAttribute("utilisateur", utilisateur);
			request.setAttribute("listErreur", erreurs);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		}
		rd.forward(request, response);
	}

}
