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
import fr.eni.projetenchere.bll.CategorieMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class ServletVersPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Categorie> listeCategories = new ArrayList<>();

	@Override
	public void init() throws ServletException {
		try {
			listeCategories = CategorieMgr.getListCategorie();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		super.init();
	}

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
			e.printStackTrace();
		}
		request.setAttribute("listeArticlesAAfficher", articles);

		request.setAttribute("listeCategories", listeCategories);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// R�cup�ration de la valeur du select
		String choixCategorie = request.getParameter("categorie");
		int noCategorie = Integer.parseInt(choixCategorie);

		// Cr�ation de la liste � renvoyer pour l'afficher
		List<Article> listeAAfficher = new ArrayList<>();

		if ("0".equals(choixCategorie)) {
			try {
				listeAAfficher = ArticlesMgr.getListArticles();
			} catch (BLLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				listeAAfficher = ArticlesMgr.getListArticlesByNoCategorie(noCategorie);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("listeCategories", listeCategories);
		request.setAttribute("listeArticlesAAfficher", listeAAfficher);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

}
