package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Articles;

public interface ArticleDAO {

	/**
	 * Methode pour ins�rer un article
	 * 
	 * @param article
	 * @throws DALException
	 */
	void insertArticle(Articles article) throws DALException;

	/**
	 * M�thode pour avoir la liste de tout les articles
	 * 
	 * @return
	 * @throws DALException
	 */
	List<Articles> selectAllArticle() throws DALException;

	/**
	 * M�thode pour avoir un article
	 * 
	 * @param noArticle
	 * @return
	 * @throws DALException
	 */
	Articles selectById(int noArticle) throws DALException;

	/**
	 * Methode pour avoir la liste des articles d'un utilisateur
	 * 
	 * @param noUtilisateur
	 * @return
	 * @throws DALException
	 */
	List<Articles> selectByNoUtilisateur(int noUtilisateur) throws DALException;

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
	void updateArticle(Articles article) throws DALException;

}
