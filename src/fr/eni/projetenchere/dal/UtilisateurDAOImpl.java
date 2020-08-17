package fr.eni.projetenchere.dal;

import java.sql.SQLException;

public class UtilisateurDAOImpl {
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	
	
	
	
	
	public void insertUtilisateur(Utilisateur utilisateur) {
		try {
			
		} catch (SQLException e) {
			throw new DALException("Erreur insertUtilisateur",e);
		}
	}
}
