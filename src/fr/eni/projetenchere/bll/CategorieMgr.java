package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.dal.CategorieDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;

public class CategorieMgr {
	// Chargement implémentation categorie DAO
	private static CategorieDAO categorieDAO;
	static {
		categorieDAO = DAOFactory.getCategorieDAO();
	}

	/**
	 * Méthode pour récupérer la liste des catégories
	 * 
	 * @return
	 * @throws BLLException
	 */
	public static List<Categorie> getListCategorie() throws BLLException {
		List<Categorie> listCategorie = new ArrayList<>();
		try {
			listCategorie = categorieDAO.selectALL();
		} catch (DALException e) {
			throw new BLLException("Erreur getListCategorie", e);
		}
		return listCategorie;
	}

	/**
	 * Méthode pour récupere une catégorie en fonction de son numéro
	 * 
	 * @param noCategorie
	 * @return
	 * @throws BLLException
	 */
	public static Categorie getCategorie(int noCategorie) throws BLLException {
		Categorie categorie = new Categorie();
		try {
			categorie = categorieDAO.selectByNoCategorie(noCategorie);
		} catch (DALException e) {
			throw new BLLException("Erreur getCategorie", e);
		}
		return categorie;
	}
}
