package fr.eni.projetenchere.ihm;

import java.io.IOException;

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
 * Servlet implementation class ServletDeconnexion
 */
@WebServlet("/Deconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = null;
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		Logger monLogger = (Logger) LoggerFactory.getLogger("fr.eni.ProjectEnchereEni");
		monLogger.info("Deconnexion : " + utilisateur.getPseudo());
		session.invalidate();

		request = Chargement.chargementListArticle(request, response);
		request = Chargement.chargementListCategorie(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
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
