package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		try {
			request.setAttribute("utilisateur", UtilisateurMgr.getUtilisateur(noUtilisateur));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Je recup�re l'utilisateur de la session
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");

		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		Utilisateur utilisateurModifie = new Utilisateur();
		// Je r�cup�re les donn�es saisie par l'utilisateur
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("ancienMotDePasse");

		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationNouveauMdp = request.getParameter("confirmerNouveauMotDePasse");

		// on définit les nouveaux renseignements

		utilisateurModifie.setPseudo(pseudo);
		utilisateurModifie.setNom(nom);
		utilisateurModifie.setPrenom(prenom);
		utilisateurModifie.setEmail(email);
		utilisateurModifie.setTelephone(telephone);
		utilisateurModifie.setRue(rue);
		utilisateurModifie.setCodePostal(codePostal);
		utilisateurModifie.setVille(ville);
		utilisateurModifie.setCredit(utilisateur.getCredit());
		utilisateurModifie.setAdministrateur(utilisateur.isAdministrateur());

		if (utilisateur.getMotDePasse().equals(motDePasseActuel)) {
			utilisateurModifie.setMotDePasse(motDePasseActuel);
			// Si nouveauMdp ET confirmationMdp ne sont pas nuls
			if (!("".equals(nouveauMotDePasse) && "".equals(confirmationNouveauMdp))) {

				if (nouveauMotDePasse.equals(confirmationNouveauMdp)) {
					utilisateurModifie.setMotDePasse(nouveauMotDePasse);
				} else {

					// On lui envoie une erreur
					String messageErreur = "Le nouveau mot de Passe et la confirmation ne sont pas identiques";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateurModifie);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);

				}
			}

			String erreur = UtilisateurMgr.verifUtilisateur(utilisateur);
			// Si le nouveau pseudo saisi existe déjà dans la bd
			if (erreur.contains("PseudoPresent")) {

				if (!(utilisateur.getPseudo().equals(utilisateurModifie.getPseudo()))) {
					String messageErreur = "Le pseudo est déjà utlisé .";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateurModifie);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);
				} else {
					erreur = erreur.replace("PseudoPresent", "");
				}
			}
			// Si le nouveau email existe déjà dans la bd
			if (erreur.contains("EmailPresent")) {
				if (!(utilisateur.getEmail().equals(utilisateurModifie.getEmail()))) {
					String messageErreur = "L'email est déjà utlisé .";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateurModifie);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);
				} else {
					erreur = erreur.replace("EmailPresent", "");
				}
			}

			if (erreur.isEmpty()) {
				utilisateur = utilisateurModifie;
				try {
					UtilisateurMgr.modificationUtilisateur(utilisateur);
				} catch (BLLException e) {
					e.printStackTrace();
				}
				session.setAttribute("utilisateur", utilisateur);
				List<Article> articles = new ArrayList<>();
				try {
					articles = ArticlesMgr.getListArticles();
				} catch (BLLException e) {
					e.printStackTrace();
				}
				request.setAttribute("listeArticle", articles);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
				rd.forward(request, response);
			}
		} else {
			// On lui envoie une erreur de mot de passe non valide
			String messageErreur = "Mot de passe incorrect";
			request.setAttribute("utilisateur", utilisateurModifie);
			request.setAttribute("message", messageErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
			rd.forward(request, response);
		}

	}
}
