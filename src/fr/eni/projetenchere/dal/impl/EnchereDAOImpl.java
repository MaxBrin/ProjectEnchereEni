package fr.eni.projetenchere.dal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.EnchereDAO;

public class EnchereDAOImpl implements EnchereDAO {
	private static final String INSERT = "INSERT INTO ENCHERES VALUES (?,?,?,?)";
	private static final String SELECTBY_NOARTICLE = "SELECT no_enchere,date_enchere,montant_enchere,no_article,no_utilisateur FROM ENCHERES WHERE no_article=? ORDER BY date_enchere DESC";

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(INSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			pStmt.setTimestamp(1, Timestamp.valueOf(enchere.getDateEnchere()));
			pStmt.setInt(2, enchere.getMontantEnchere());
			pStmt.setInt(3, enchere.getNoArticle());
			pStmt.setInt(4, enchere.getNoUtilisateur());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			}

		} catch (SQLException e) {
			throw new DALException("Erreur insertEnchere", e);
		}

	}

	@Override
	public Enchere selectBy_NoArticle(int noArticle) throws DALException {
		Enchere enchere = null;
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(SELECTBY_NOARTICLE)) {
			pStmt.setInt(1, noArticle);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				enchere = new Enchere(rs.getInt("no_enchere"), rs.getTimestamp("date_enchere").toLocalDateTime(),
						rs.getInt("montant_enchere"), noArticle, rs.getInt("no_utilisateur"));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur selectBy_NoArticle", e);

		}
		return enchere;
	}
}
