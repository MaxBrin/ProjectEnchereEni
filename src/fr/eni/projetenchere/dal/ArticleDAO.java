package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Article;

public interface ArticleDAO {

	/**
	 * Methode pour insérer un article
	 * 
	 * @param article
	 * @throws DALException
	 */
	void insertArticle(Article article) throws DALException;

	/**
	 * Méthode pour avoir la liste de tout les articles
	 * 
	 * @return
	 * @throws DALException
	 */
	List<Article> selectAllArticle() throws DALException;

	/**
	 * Méthode pour avoir un article
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
	 * Methode pour effacer un article dans la BD
	 * 
	 * @param noArticle
	 * @throws DALException
	 */
	void deleteArticle(int noArticle) throws DALException;

	/**
	 * Méthode pour mettre à jour un article
	 * 
	 * @param article
	 * @throws DALException
	 */
	void updateArticle(Article article) throws DALException;

}
