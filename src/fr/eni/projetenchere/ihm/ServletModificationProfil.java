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

import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.ihm.modele.Chargement;

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
		//Recuperation du parametre noUtilisateur
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		
		//Récupération de l'utilisateur par son noUtilisateur
		try {
			request.setAttribute("utilisateur", UtilisateurMgr.getUtilisateur(noUtilisateur));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		//Envoi de l'utilisateur à la JSP modificationProfil
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
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
		HashMap<String, String> erreurs = new HashMap<String, String>();
		if (utilisateur.getMotDePasse().equals(motDePasseActuel)) {
			utilisateurModifie.setMotDePasse(motDePasseActuel);
			// Si nouveauMdp ET confirmationMdp ne sont pas nuls
			if (!("".equals(nouveauMotDePasse) && "".equals(confirmationNouveauMdp))) {

				if (nouveauMotDePasse.equals(confirmationNouveauMdp)) {
					utilisateurModifie.setMotDePasse(nouveauMotDePasse);
				} else {

					// On lui envoie une erreur

					erreurs.put("MotDePasseDifferent",
							"Le nouveau mot de Passe et la confirmation ne sont pas identiques");
					request.setAttribute("listeErreur", erreurs);
					request.setAttribute("utilisateur", utilisateurModifie);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);

				}
			}

			erreurs = UtilisateurMgr.verifierUtilisateur(utilisateurModifie);
			// Si le nouveau
			// pseudo
			// saisi existe déjà
			// dans la bd
			if (erreurs.containsKey("pseudoPresent")) {
				if (utilisateur.getPseudo().equals(utilisateurModifie.getPseudo())) {
					erreurs.remove("pseudoPresent");
				}
			}
			// Si le nouveau email existe déjà dans la bd
			if (erreurs.containsKey("emailPresent")) {
				if (utilisateur.getEmail().equals(utilisateurModifie.getEmail())) {
					erreurs.remove("emailPresent");
				}
			}

			if (erreurs.isEmpty()) {
				// Il n'y pas d'erreur donc on peut mettre le numéro d'utilsateur de la session
				utilisateurModifie.setNoUtilisateur(utilisateur.getNoUtilisateur());
				// On peut modifier l'utilisateur
				try {
					UtilisateurMgr.modificationUtilisateur(utilisateurModifie);
				} catch (BLLException e) {
					e.printStackTrace();
				}
				// On remet le numéro en attribut de session pour rester connecter
				session.setAttribute("noUtilisateur", utilisateurModifie.getNoUtilisateur());
				request = Chargement.chargementListArticle(request);
				request = Chargement.chargementListCategorie(request);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("utilisateur", utilisateurModifie);
				request.setAttribute("listeErreur", erreurs);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
				rd.forward(request, response);
			}
		} else {
			// On lui envoie une erreur de mot de passe non valide
			erreurs.put("MotDePasseNonValide", "Mot de passe incorrect");
			request.setAttribute("utilisateur", utilisateurModifie);
			request.setAttribute("listeErreur", erreurs);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
			rd.forward(request, response);
		}

	}
}
