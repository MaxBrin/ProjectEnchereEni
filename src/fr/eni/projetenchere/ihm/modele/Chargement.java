package fr.eni.projetenchere.ihm.modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.CategorieMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;

public class Chargement {
	/**
	 * Méthode pour mettre en attribut de request la liste d'article
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public static HttpServletRequest chargementListArticle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Article> articles = new ArrayList<>();
		Filtre filtre = new Filtre();
		filtre.setEnCours(true);
		String[] saisieVide = { "" };
		filtre.setSaisieUtilisateur(saisieVide);
		try {
			articles = ArticlesMgr.getListArticleFiltre(filtre);
		} catch (BLLException e) {
			request.setAttribute("ErreurBD",
					"Nous sommes désolés mais nous rencontrons actuellement des problèmes de serveurs.");
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.setAttribute("listeArticlesAAfficher", articles);
		return request;

	}

	/**
	 * Méthode pour mettre ne attribut de request la liste de catégorie
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	public static HttpServletRequest chargementListCategorie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> listeCategories = new ArrayList<>();
		try {
			listeCategories = CategorieMgr.getListCategorie();
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.setAttribute("listeCategories", listeCategories);
		return request;
	}
}
