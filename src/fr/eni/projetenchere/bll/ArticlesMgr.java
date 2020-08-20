package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.dal.ArticleDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;

public class ArticlesMgr {
	private static ArticleDAO articleDAO;

	static {
		articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * M�thode pour ajouter un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void ajoutArticle(Article article) throws BLLException {
		try {
			articleDAO.insertArticle(article);

		} catch (DALException e) {
			throw new BLLException("Erreur ajoutArticle", e);
		}
	}

	/**
	 * M�thode pour modifier un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public void modifierArticle(Article article) throws BLLException {
		try {
			articleDAO.updateArticle(article);
		} catch (DALException e) {
			throw new BLLException("Erreur modifierArticle", e);
		}
	}

	/**
	 * M�thode pour effacer un article
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
	 * M�thode pour r�cup�rer la liste de tout les articles
	 * 
	 * @return
	 * @throws BLLException
	 */
	public List<Article> getListArticles() throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectAllArticle();
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticles", e);
		}
		return listArticles;
	}

	/**
	 * M�thode pour r�cup�rer la liste des articles d'un utilisateur gr�ce � son
	 * num�ro
	 * 
	 * @param noUtilisateur
	 * @return
	 * @throws BLLException
	 */
	public List<Article> getListArticlesByNoUtilisateur(int noUtilisateur) throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectByNoUtilisateur(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticlesByNoUtilisateur", e);
		}
		return listArticles;
	}

	/**
	 * M�thode pour r�cup�rer un article gr�ce � son noArticle
	 * 
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */
	public Article getArticle(int noArticle) throws BLLException {
		Article article = null;
		try {
			article = articleDAO.selectById(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur getArticle", e);
		}
		return article;
	}
}
