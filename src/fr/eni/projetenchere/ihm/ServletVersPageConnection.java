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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnection.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String mdp = request.getParameter("motDePasse");
		List<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
		try {
			listeUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		String messageErreur = "";
		boolean identifiantPresent = false;
		for (Utilisateur utilisateur : listeUtilisateur) {
			if ((utilisateur.getEmail().equals(identifiant) || utilisateur.getPseudo().equals(identifiant))) {
				identifiantPresent = true;

				if (utilisateur.getMotDePasse().equals(mdp)) {

					HttpSession session = request.getSession();
					session.setAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
					request = Chargement.chargementListArticle(request);
					request = Chargement.chargementListCategorie(request);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
					rd.forward(request, response);
				} else {
					messageErreur = "Le mot de passe est incorrect. ";
					request.setAttribute("erreurAuthentification", messageErreur);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnection.jsp");
					rd.forward(request, response);
				}
			}
		}
		if (!identifiantPresent) {
			messageErreur = "L'identifiant est inconnue. ";
			request.setAttribute("erreurAuthentification", messageErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageConnection.jsp");
			rd.forward(request, response);
		}

	}

}
