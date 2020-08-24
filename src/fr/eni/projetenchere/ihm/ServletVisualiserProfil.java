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
		// Récupération du vendeur
		int noVendeur = Integer.parseInt(request.getParameter("utilisateurVendeur"));
		// Initialisation des variables
		List<Utilisateur> listeUtilisateur = null;
		Utilisateur utilisateurAAfficher = null;
		// Récupération de la liste des utilisateurs et de l'utilisateur titulaire du
		// compte
		try {
			listeUtilisateur = UtilisateurMgr.getListUtilisateur();
			utilisateurAAfficher = UtilisateurMgr.getUtilisateur(noVendeur);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.setAttribute("utilisateurAAfficher", utilisateurAAfficher);
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
