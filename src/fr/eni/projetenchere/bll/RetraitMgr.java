package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.RetraitDAO;

public class RetraitMgr {
	// Chargement implémentation retrait DAO
	private static RetraitDAO retraitDAO;

	static {
		retraitDAO = DAOFactory.getRetraitDAO();
	}

	/**
	 * Méthode pour rajouter un retrait dans la BD
	 * 
	 * @param retrait
	 * @throws BLLException
	 */
	public static void ajouterRetrait(Retrait retrait) throws BLLException {
		try {
			retraitDAO.insertRetrait(retrait);
		} catch (DALException e) {
			throw new BLLException("Erreur ajouterRetrait", e);
		}
	}

}
