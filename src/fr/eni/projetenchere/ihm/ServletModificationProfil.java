package fr.eni.projetenchere.ihm;

import java.io.IOException;

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
		Utilisateur uS = (Utilisateur) session.getAttribute("utilisateur");
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNoUtilisateur(uS.getNoUtilisateur());
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

		// on d�finit les nouveaux renseignements
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setCredit(uS.getCredit());
		utilisateur.setAdministrateur(uS.isAdministrateur());

		if (uS.getMotDePasse().equals(motDePasseActuel)) {
			utilisateur.setMotDePasse(uS.getMotDePasse());

			// Si nouveauMdp ET confirmationMdp ne sont pas nuls
			if (!("".equals(nouveauMotDePasse) && "".equals(confirmationNouveauMdp))) {

				if (nouveauMotDePasse.equals(confirmationNouveauMdp)) {
					utilisateur.setMotDePasse(nouveauMotDePasse);
				} else {

					// On lui envoie une erreur
					String messageErreur = "Le nouveau mot de Passe et la confirmation ne sont pas identiques";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);

				}
			}

			String erreur = UtilisateurMgr.verifUtilisateur(utilisateur);
			// Si le nouveau pseudo saisi existe deja dans la bdd
			if (erreur.contains("PseudoPresent")) {

				if (!(uS.getPseudo().equals(utilisateur.getPseudo()))) {
					String messageErreur = "Le pseudo est d�j� utlis� .";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);
				} else {
					erreur = erreur.replace("PseudoPresent", "");
				}
			}

			if (erreur.contains("EmailPresent")) {
				if (!(uS.getEmail().equals(utilisateur.getEmail()))) {
					String messageErreur = "L'email est d�j� utlis� .";
					request.setAttribute("message", messageErreur);
					request.setAttribute("utilisateur", utilisateur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
					rd.forward(request, response);
				} else {
					erreur = erreur.replace("EmailPresent", "");
				}
			}

			if (erreur.isEmpty()) {

				try {
					UtilisateurMgr.modificationUtilisateur(utilisateur);
				} catch (BLLException e) {
					e.printStackTrace();
				}
				session.setAttribute("utilisateur", utilisateur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
				rd.forward(request, response);
			}
		} else {
			// On lui envoie une erreur de mot de passe non valide
			String messageErreur = "Mot de passe incorrect";
			request.setAttribute("utilisateur", utilisateur);
			request.setAttribute("message", messageErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
			rd.forward(request, response);
		}

	}
}
