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
import fr.eni.projetenchere.ihm.modele.Chargement;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class ServletVersCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur("", "", "", "", "", "", "", "", "", 0, false);
		String erreur = "";
		request.setAttribute("listErreur", erreur);
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");

		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		System.out.println(ville);
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMdp = request.getParameter("confirmerMotDePasse");
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, 100, false);
		if (!(motDePasse.equals(confirmationMdp))) {
			utilisateur.setMotDePasse(null);
		}
		String erreur = UtilisateurMgr.verifUtilisateur(utilisateur);
		RequestDispatcher rd;
		if (erreur.isEmpty()) {
			try {
				UtilisateurMgr.ajoutUtilisateur(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			HttpSession session = request.getSession();
			session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
			request = Chargement.chargementListArticle(request);
			request = Chargement.chargementListCategorie(request);

			rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");

		} else {
			request.setAttribute("utilisateur", utilisateur);
			request.setAttribute("listErreur", erreur);
			System.out.println(utilisateur);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		}
		rd.forward(request, response);
	}

}
