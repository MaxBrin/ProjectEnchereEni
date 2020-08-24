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
	/**
	 * Méthode pour mettre en attribut de request la liste d'article
	 * 
	 * @param request
	 * @return
	 */
	public static HttpServletRequest chargementListArticle(HttpServletRequest request) {
		List<Article> articles = new ArrayList<>();
		try {
			articles = ArticlesMgr.getListArticlesNonConnecte();
		} catch (BLLException e) {
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
	 */
	public static HttpServletRequest chargementListCategorie(HttpServletRequest request) {
		List<Categorie> listeCategories = new ArrayList<>();
		try {
			listeCategories = CategorieMgr.getListCategorie();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listeCategories", listeCategories);
		return request;
	}
}
