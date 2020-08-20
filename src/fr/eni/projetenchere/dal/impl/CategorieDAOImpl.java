package fr.eni.projetenchere.dal.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.dal.CategorieDAO;
import fr.eni.projetenchere.dal.DALException;

public class CategorieDAOImpl implements CategorieDAO {
	private static final String SELECTALL = "SELECT no_categorie,libelle FROM CATEGORIE";

	@Override
	public List<Categorie> selectALL() throws DALException {
		List<Categorie> categories = new ArrayList<Categorie>();
		try (Statement stmt = ConnectionProvider.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECTALL);
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				categories.add(categorie);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur SelectAll Categorie", e);
		}
		return categories;
	}
}
