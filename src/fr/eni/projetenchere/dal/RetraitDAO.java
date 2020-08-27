package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Retrait;

public interface RetraitDAO {
	/**
	 * Méthode pour inserer un retrait
	 * 
	 * @param retrait
	 * @throws DALException
	 */
	void insertRetrait(Retrait retrait) throws DALException;

	/**
	 * Méthode pour récuper le retrait d'un article en fonction
	 * 
	 * @param noRetrait
	 * @return
	 * @throws DALException
	 */
	Retrait selectByNoArticle(int noArticle) throws DALException;

}
