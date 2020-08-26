package fr.eni.projetenchere.dal.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.ArticleDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.ihm.modele.Filtre;

public class ArticleDAOImpl implements ArticleDAO {
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,null,?,?)";
	private static final String SELECTALL = "SELECT no_article,nom_article,description,date_debut_encheres,"
			+ "date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,c.no_categorie,"
			+ "pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur,"
			+ "libelle FROM ARTICLES_VENDUS a JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur "
			+ "JOIN CATEGORIES c ON c.no_categorie=a.no_categorie ";
	private static final String SELECTBYID = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,c.no_categorie,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur,libelle FROM ARTICLES_VENDUS a JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur JOIN CATEGORIES c ON c.no_categorie=a.no_categorie WHERE no_article=?";
	private static final String SELECTBY_NOUTILISATEUR = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,c.no_categorie,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur,libelle FROM ARTICLES_VENDUS a JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur JOIN CATEGORIES c ON c.no_categorie=a.no_categorie WHERE a.no_utilisateur=?";
	private static final String SELECTBY_NOCATEGORIE = "SELECT no_article,nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,u.no_utilisateur,c.no_categorie,pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur,libelle FROM ARTICLES_VENDUS a JOIN UTILISATEURS u ON u.no_utilisateur = a.no_utilisateur JOIN CATEGORIES c ON c.no_categorie=a.no_categorie WHERE c.no_categorie=?";
	private static final String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur =?";
	private static final String UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?,description=?,date_debut_encheres=?,"
			+ "date_fin_encheres=?,prix_initial=?,prix_vente=?,no_utilisateur=?,no_categorie=? WHERE no_article=? ";

	@Override
	public void insertArticle(Article article) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(INSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setTimestamp(3, Timestamp.valueOf(article.getDebutEnchere()));
			pStmt.setTimestamp(4, Timestamp.valueOf(article.getFinEnchere()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(7, article.getCategorie().getNoCategorie());
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
	public List<Article> selectAllArticle(Filtre filtre) throws DALException {
		List<Article> listArticles = new ArrayList<>();
		String requete = SELECTALL + creationRequeteSql(filtre);
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(requete)) {

			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				Article article = new Article(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
						rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), utilisateur, categorie);
				listArticles.add(article);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur selectAllArticle", e);
		}
		return listArticles;
	}

	@Override
	public Article selectById(int noArticle) throws DALException {
		Article article = null;
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(SELECTBYID)) {
			pStmt.setInt(1, noArticle);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				article = new Article(rs.getInt("no_article"), rs.getString("nom_article"), rs.getString("description"),
						rs.getTimestamp("date_debut_encheres").toLocalDateTime(),
						rs.getTimestamp("date_fin_encheres").toLocalDateTime(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), utilisateur, categorie);
			}

		} catch (SQLException e) {
			throw new DALException("Erreur selectAllArticle", e);
		}
		return article;
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
	public void updateArticle(Article article) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(UPDATE)) {
			pStmt.setString(1, article.getNomArticle());
			pStmt.setString(2, article.getDescription());
			pStmt.setTimestamp(3, Timestamp.valueOf(article.getDebutEnchere()));
			pStmt.setTimestamp(4, Timestamp.valueOf(article.getFinEnchere()));
			pStmt.setInt(5, article.getPrixInitial());
			pStmt.setInt(6, article.getPrixVente());
			pStmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pStmt.setInt(8, article.getCategorie().getNoCategorie());
			pStmt.setInt(9, article.getNoArticle());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur updateArticle", e);
		}

	}

	protected String creationRequeteSql(Filtre filtre) {
		StringBuilder sbRequete = new StringBuilder();
		if (filtre != null) {
			List<String> listeRequete = new ArrayList<String>();
			String[] saisieUtilisateur = filtre.getSaisieUtilisateur();
			if (saisieUtilisateur.length > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("(nom_article LIKE '%" + saisieUtilisateur[0] + "%' ");
				for (int i = 1; i < saisieUtilisateur.length; i++) {
					sb.append("Or nom_article LIKE '%" + saisieUtilisateur[i] + "%' ");
				}
				sb.append(")");
				listeRequete.add(sb.toString());
			}
			if (filtre.getNoCategorie() != 0) {
				listeRequete.add("c.no_categorie = " + filtre.getNoCategorie() + " ");
			}
			if (filtre.getNoUtilisateur() != 0) {
				listeRequete.add("u.no_utilisateur = " + filtre.getNoUtilisateur() + " ");
			}
			List<String> choixUtilisateur = new ArrayList<>();
			if (filtre.isEnCours()) {
				choixUtilisateur.add("date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE() ");
			}
			if (filtre.isFini()) {
				choixUtilisateur.add("date_fin_encheres <= GETDATE() ");
			}
			if (filtre.isNonDisponible()) {
				choixUtilisateur.add("date_debut_encheres >= GETDATE() ");
			}
			StringBuilder choix = new StringBuilder();
			if (!(choixUtilisateur.isEmpty())) {
				choix.append("(");
				choix.append(choixUtilisateur.get(0));
				for (int i = 1; i < choixUtilisateur.size(); i++) {
					choix.append(" OR ");
					choix.append(choixUtilisateur.get(i));
				}
				choix.append(")");
				listeRequete.add(choix.toString());
			}
			if (!(listeRequete.isEmpty())) {
				sbRequete.append(" WHERE ");
				sbRequete.append(listeRequete.get(0));
				for (int i = 1; i < listeRequete.size(); i++) {
					sbRequete.append(" AND ");
					sbRequete.append(listeRequete.get(i));
				}
			}
		}
		return sbRequete.toString();
	}

}
