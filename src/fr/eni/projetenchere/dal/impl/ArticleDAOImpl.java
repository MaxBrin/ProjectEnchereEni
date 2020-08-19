package fr.eni.projetenchere.dal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Articles;
import fr.eni.projetenchere.dal.ArticleDAO;
import fr.eni.projetenchere.dal.DALException;

public class ArticleDAOImpl implements ArticleDAO {
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?,?)";
	private static final String SELECTALL = "SELECT no_article,nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie" + "FROM ARTICLES_VENDUS";
	private static final String SELECTBYID = "SELECT no_article,nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie"
			+ "FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String SELECTBY_NOUTILISATEUR = "SELECT no_article,nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie"
			+ "FROM ARTICLES_VENDUS WHERE no_utilisateur=?";;
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur =?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?,description=?,date_debut_encheres=?,"
			+ "date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article=? ";

	@Override
	public void insertArticle(Articles article) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(INSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setTimestamp(3, Timestamp.valueOf(article.getDebutEnchere()));
			pStmt.setTimestamp(4, Timestamp.valueOf(article.getFinEnchere()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, article.getNoUtilisateur());
			pStmt.setInt(8, article.getNoCategorie());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur insertArticle", e);
		}

	}

	@Override
	public List<Articles> selectAllArticle() throws DALException {
		List<Articles> listArticles = new ArrayList<>();
		try (Statement stmt = ConnectionProvider.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECTALL);
			while (rs.next()) {
				Articles article = new Articles(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
						rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				listArticles.add(article);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur selectAllArticle", e);
		}
		return listArticles;
	}

	@Override
	public Articles selectById(int noArticle) throws DALException {
		Articles article = null;
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(SELECTBYID)) {
			pStmt.setInt(1, noArticle);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				article = new Articles(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
						rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
			}

		} catch (SQLException e) {
			throw new DALException("Erreur selectAllArticle", e);
		}
		return article;
	}

	@Override
	public List<Articles> selectByNoUtilisateur(int noUtilisateur) throws DALException {
		List<Articles> listArticles = new ArrayList<>();
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(SELECTBY_NOUTILISATEUR)) {
			pStmt.setInt(1, noUtilisateur);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Articles article = new Articles(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
						rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				listArticles.add(article);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur selectByNoUtilisateur", e);
		}
		return listArticles;
	}

	@Override
	public void deleteArticle(int noArticle) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(DELETE)) {
			pStmt.setInt(1, noArticle);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur deleteArticle", e);
		}

	}

	@Override
	public void updateArticle(Articles article) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(UPDATE)) {
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setTimestamp(3, Timestamp.valueOf(article.getDebutEnchere()));
			pStmt.setTimestamp(4, Timestamp.valueOf(article.getFinEnchere()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, article.getNoUtilisateur());
			pStmt.setInt(8, article.getNoCategorie());
			pStmt.setInt(9, article.getNoArticle());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur updateArticle", e);
		}

	}

}
