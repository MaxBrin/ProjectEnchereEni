package fr.eni.projetenchere.dal.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO {
	private static final String INSERT = "INSERT INTO RETRAITS VALUES (?,?,?,?)";

	@Override
	public void insertRetrait(Retrait retrait) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(INSERT)) {
			pStmt.setInt(1, retrait.getNoArticle());
			pStmt.setString(2, retrait.getRue());
			pStmt.setString(3, retrait.getCodePostal());
			pStmt.setString(4, retrait.getVille());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur insertRetrait", e);
		}

	}

	@Override
	public Retrait selectByNoArticle(int noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRetrait(Retrait retrait) throws DALException {
		// TODO Auto-generated method stub

	}

}
