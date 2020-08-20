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

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bo.Article;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class ServletVersPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choix = request.getParameter("choix");

		if ("achat".equals(choix)) {
			request.setAttribute("choixAchat", "achat");
		}

		if ("mesVentes".equals(choix)) {
			request.setAttribute("choixAchat", "ventes");
		}
		List<Article> articles = new ArrayList<>();
		try {
			articles = ArticlesMgr.getListArticles();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listeArticle", articles);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
