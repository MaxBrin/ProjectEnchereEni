package fr.eni.projetenchere.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Utilisateur;

public class UtilisateurDAOImpl implements UtilisateurDAO {
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECTALL = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal"
			+ ",ville,mot_de_passe,credit,administrateur FROM UTILISATEURS";
	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo=?,nom=?,prenom=?,email=?"
			+ ",telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?"
			+ ",administrateur=? WHERE no_utilisateur = ?";
	private static final String DELETE = "DELETE FROM UTILISATEUR WHERE no_utilisateur=?";
	private static final String SELECTBYID = "SELECT no_utilisateur,pseudo,nom,prenom,email,telephone,rue,code_postal"
			+ ",ville,mot_de_passe,credit,administrateur FROM UTILISATEURS WHERE no_utilisateur =?";

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(INSERT,
				Statement.RETURN_GENERATED_KEYS)) {
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.executeUpdate();
			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new DALException("Erreur insertUtilisateur", e);
		}
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		try (Statement stmt = ConnectionProvider.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(SELECTALL);
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"),
						rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
				listUtilisateur.add(utilisateur);
			}
		} catch (SQLException e) {
			throw new DALException("Erreur selectAll", e);
		}
		return listUtilisateur;
	}

	@Override
	public void deleteUtilisateur(int noUtilisateur) throws DALException {
		try (PreparedStatement pStmt = ConnectionProvider.getConnection().prepareStatement(DELETE)) {
			pStmt.setInt(1, noUtilisateur);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Erreur deleteUtilisateur", e);
		}

	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
