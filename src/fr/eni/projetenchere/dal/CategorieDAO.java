package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Categorie;

public interface CategorieDAO {
	List<Categorie> selectALL() throws DALException;

	Categorie selectByNoCategorie(int noCategorie) throws DALException;
}
