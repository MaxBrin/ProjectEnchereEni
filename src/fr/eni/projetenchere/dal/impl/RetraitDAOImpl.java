package fr.eni.projetenchere.dal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO {
	private static final String INSERT = "INSERT INTO RETRAITS VALUES (?,?,?,?)";
	private static final String SELECTBY_NOARTICLE = "SELECT no_article,rue,code_postal,ville FROM RETRAITS WHERE no_article =?";

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
		Retrait retrait = null;
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(SELECTBY_NOARTICLE)) {
			pStmt.setInt(1, noArticle);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				retrait = new Retrait(rs.getInt("no_article"), rs.getString("rue"), rs.getString("code_postal"),
						rs.getString("ville"));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur selectByNoArticle", e);
		}
		return retrait;
	}

}
