package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.dal.CategorieDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;

public class CategorieMgr {
	private static CategorieDAO categorieDAO;
	static {
		categorieDAO = DAOFactory.getCategorieDAO();
	}

	public static List<Categorie> getListCategorie() throws BLLException {
		List<Categorie> listCategorie = new ArrayList<>();
		try {
			listCategorie = categorieDAO.selectALL();
		} catch (DALException e) {
			throw new BLLException("Erreur getListCategorie", e);
		}
		return listCategorie;
	}
}
