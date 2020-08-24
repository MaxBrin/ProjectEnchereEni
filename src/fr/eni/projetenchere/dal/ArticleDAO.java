package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Article;

public interface ArticleDAO {

	/**
	 * Methode pour ins�rer un article
	 * 
	 * @param article
	 * @throws DALException
	 */
	void insertArticle(Article article) throws DALException;

	/**
	 * Méthode pour avoir la liste de tout les articles valides à afficher. La date
	 * de début doit être inférieur à maintenant et La date de fin doit être
	 * supérieur à maintenant
	 * 
	 * @return
	 * @throws DALException
	 */
	List<Article> selectAllArticleNonConnecte() throws DALException;

	/**
	 * M�thode pour avoir un article
	 * 
	 * @param noArticle
	 * @return
	 * @throws DALException
	 */
	Article selectById(int noArticle) throws DALException;

	/**
	 * Methode pour avoir la liste des articles d'un utilisateur
	 * 
	 * @param noUtilisateur
	 * @return
	 * @throws DALException
	 */
	List<Article> selectByNoUtilisateur(int noUtilisateur) throws DALException;

	/**
	 * Methode pour avoir la liste des articles d'une catégorie
	 * 
	 * @param noCategorie
	 * @return
	 * @throws DALException
	 */
	List<Article> selectByNoCategorie(int noCategorie) throws DALException;

	/**
	 * Methode pour effacer un article dans la BD
	 * 
	 * @param noArticle
	 * @throws DALException
	 */
	void deleteArticle(int noArticle) throws DALException;

	/**
	 * M�thode pour mettre � jour un article
	 * 
	 * @param article
	 * @throws DALException
	 */
	void updateArticle(Article article) throws DALException;

}
