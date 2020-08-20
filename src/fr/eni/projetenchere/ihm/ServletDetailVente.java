package fr.eni.projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/DetailVente")
public class ServletDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération de l'utilisateur dans la session
		Utilisateur utilisateur = null;
		HttpSession session = request.getSession();
		utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		// Recuperation du paramètre idArticle
		String noArticle = request.getParameter("idArticle");
		int noIdArticle = Integer.parseInt(noArticle);
		Article article = null;

		// Récuperation de l'article a partir de son id
		try {
			// TODO:at fr.eni.projetenchere.bll.ArticlesMgr.getArticle(ArticlesMgr.java:125)
			article = ArticlesMgr.getArticle(noIdArticle);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Envoie du paramètre article et de l'utilisateur
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

}
