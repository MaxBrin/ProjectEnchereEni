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
	 * Méthode pour récuper le retrait
	 * 
	 * @param noRetrait
	 * @return
	 * @throws DALException
	 */
	Retrait selectByNoRetrait(int noArticle) throws DALException;
}
