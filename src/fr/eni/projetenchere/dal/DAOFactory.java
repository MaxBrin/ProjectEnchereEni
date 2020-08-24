package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.dal.impl.ArticleDAOImpl;
import fr.eni.projetenchere.dal.impl.CategorieDAOImpl;
import fr.eni.projetenchere.dal.impl.RetraitDAOImpl;
import fr.eni.projetenchere.dal.impl.UtilisateurDAOImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}

	public static ArticleDAO getArticleDAO() {
		return new ArticleDAOImpl();
	}

	public static CategorieDAO getCategorieDAO() {
		return new CategorieDAOImpl();
	}

	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}
}
