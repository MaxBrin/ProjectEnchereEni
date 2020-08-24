package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ServletVisualiserProfil
 */
@WebServlet("/VisualiserProfil")
public class ServletVisualiserProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// Récupération du vendeur ou de l'utilisateur tituliaire du compte
		String pseudoVendeur = request.getParameter("utilisateurVendeur");
		System.out.println(pseudoVendeur);
		// int idUtilisateurTitulaire =
		// Integer.parseInt(session.getAttribute("noUtilisateur"));
		// Initialisation des variables
		List<Utilisateur> listeUtilisateur = null;
		Utilisateur utilisateurAAfficher = null;
		Utilisateur utilisateurTitulaire = null;

		// Récupération de la liste des utilisateurs et de l'utilisateur titulaire du
		// compte
		try {
			listeUtilisateur = UtilisateurMgr.getListUtilisateur();
			// utilisateurTitulaire = UtilisateurMgr.getUtilisateur(idUtilisateurTitulaire);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		// Récupération de l'utlisateur vendeur dans la liste en bdd à partir de son
		// pseudo
		for (Utilisateur user : listeUtilisateur) {
			if (user.getPseudo().equals(pseudoVendeur)) {
				utilisateurAAfficher = user;
			}
		}
		System.out.println(utilisateurTitulaire);
		System.out.println(utilisateurAAfficher);
		request.setAttribute("utilisateurTitulaire", utilisateurTitulaire);
		request.setAttribute("utilisateurVendeur", utilisateurAAfficher);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/affichageProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
