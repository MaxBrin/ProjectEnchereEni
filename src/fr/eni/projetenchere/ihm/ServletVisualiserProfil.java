package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String pseudoVendeur = request.getParameter("utilisateurVendeur");
		List<Utilisateur> listeUtilisateur = null;
		Utilisateur utilisateurAAfficher = null;
		Utilisateur utilisateurTitulaire = null;
		try {
			listeUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		for (Utilisateur user : listeUtilisateur) {
			if (user.getPseudo().equals(pseudoVendeur)) {
				utilisateurAAfficher = user;
			}
		}

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
