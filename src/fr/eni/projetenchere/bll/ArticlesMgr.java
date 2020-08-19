package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Articles;
import fr.eni.projetenchere.dal.ArticleDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;

public class ArticlesMgr {
	private static ArticleDAO articleDAO;

	static {
		articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * Méthode pour ajouter un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void ajoutArticle(Articles article) throws BLLException {
		try {
			articleDAO.insertArticle(article);

		} catch (DALException e) {
			throw new BLLException("Erreur ajoutArticle", e);
		}
	}

	/**
	 * Méthode pour modifier un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void modifierArticle(Articles article) throws BLLException {
		try {
			articleDAO.updateArticle(article);
		} catch (DALException e) {
			throw new BLLException("Erreur modifierArticle", e);
		}
	}

	/**
	 * Méthode pour effacer un article
	 * 
	 * @param noArticle
	 * @throws BLLException
	 */
	public void effacerArticle(int noArticle) throws BLLException {
		try {
			articleDAO.deleteArticle(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur effacerArticle", e);
		}
	}

	/**
	 * Méthode pour récupérer la liste de tout les articles
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Articles> getListArticles() throws BLLException {
		List<Articles> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectAllArticle();
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticles", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer la liste des articles d'un utilisateur grâce à son
	 * numéro
	 * 
	 * @param noUtilisateur
	 * @return
	 * @throws BLLException
	 */
	public List<Articles> getListArticlesByNoUtilisateur(int noUtilisateur) throws BLLException {
		List<Articles> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectByNoUtilisateur(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticlesByNoUtilisateur", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer un article grâce à son noArticle
	 * 
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */
	public Articles getArticle(int noArticle) throws BLLException {
		Articles article = null;
		try {
			article = articleDAO.selectById(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur getArticle", e);
		}
		return article;
	}
}
