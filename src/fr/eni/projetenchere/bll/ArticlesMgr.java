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
	 * Méthode pour ajouter un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public static void ajoutArticle(Article article) throws BLLException {
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
	public static void modifierArticle(Article article) throws BLLException {
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
	public static void effacerArticle(int noArticle) throws BLLException {
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
	public static List<Article> getListArticles() throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectAllArticle();
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticles", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer la liste des articles d'un utilisateur gràce à son
	 * numéro
	 * 
	 * @param noUtilisateur
	 * @return
	 * @throws BLLException
	 */
	public static List<Article> getListArticlesByNoUtilisateur(int noUtilisateur) throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectByNoUtilisateur(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticlesByNoUtilisateur", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer la liste des articles d'une catégorie gràce à son
	 * numéro
	 * 
	 * @param noCategorie
	 * @return
	 * @throws BLLException
	 */
	public static List<Article> getListArticlesByNoCategorie(int noCategorie) throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectByNoCategorie(noCategorie);
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticlesByNoCategorie", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer un article gràce à son noArticle
	 * 
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */
	public static Article getArticle(int noArticle) throws BLLException {
		Article article = null;
		try {
			article = articleDAO.selectById(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur getArticle", e);
		}
		return article;
	}

	// Méthode pour vérifier si une nouvelle vente est conforme

	public static StringBuilder verifierVente(Article article) {
		StringBuilder sb = new StringBuilder();
		if (article.getNomArticle().equals("")) {
			sb.append("Nom d'article obligatoire");
		}
		if (article.getPrixInitial() == 0) {
			sb.append("Le prix de départ ne peut pas être égal à zero");
		}
		if (article.getFinEnchere().isBefore(article.getDebutEnchere())) {
			sb.append("La date de fin d'enchère doit être située après celle de début d'enchère");
		}
		if ((article.getUtilisateur().getRue()).equals("")) {
			sb.append("Veuillez aisir un numero et une rue");
		}
		if ((article.getUtilisateur().getCodePostal()).equals("")) {
			sb.append("Veuillez saisir un code postal");
		}
		if ((article.getUtilisateur().getVille()).equals("")) {
			sb.append("Veuillez saisir une ville");
		}
		return sb;
	}

}
