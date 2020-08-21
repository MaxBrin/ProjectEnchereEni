package fr.eni.projetenchere.ihm.modele;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.CategorieMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;

public class Chargement {

	public static HttpServletRequest chargementList(HttpServletRequest request) {
		List<Article> articles = new ArrayList<>();
		List<Categorie> listeCategories = new ArrayList<>();
		try {
			articles = ArticlesMgr.getListArticles();
			listeCategories = CategorieMgr.getListCategorie();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listeArticlesAAfficher", articles);
		request.setAttribute("listeCategories", listeCategories);

		return request;

	}
}
