package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Enchere;

public interface EnchereDAO {
	/**
	 * Méthode pour inserer une enchere
	 * 
	 * @param enchere
	 * @throws DALException
	 */
	void insertEnchere(Enchere enchere) throws DALException;

	/**
	 * Méthode pour récuperer la meilleur enchère en fonction du numéro d'article
	 * 
	 * @param noArticle
	 * @return
	 * @throws DALException
	 */
	Enchere selectBy_NoArticle_BestOffer(int noArticle) throws DALException;

}
