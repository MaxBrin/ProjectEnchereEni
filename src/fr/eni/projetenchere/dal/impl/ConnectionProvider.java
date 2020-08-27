package fr.eni.projetenchere.dal.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//import fr.eni.javaee.suividesrepas.dal.ConnectionProvider;

public abstract class ConnectionProvider {
	private static DataSource dataSource;

	/**
	 * Au chargement de la classe, la DataSource est recherch�e dans l'arbre JNDI
	 */
	static {
		Context context;
		try {
			// cr�er un context
			context = new InitialContext();
			// Recherche de la dataSource qui va pvr fournir des connections vers la bdd. La
			// ressource recherch�e commence tjs par "java:comp/env/
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}

	/**
	 * Cette m�thode retourne une connection op�rationnelle issue du pool de
	 * connexion vers la base de donn�es.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		// demande une connexion avec getConnection()
		// met la demande en attente tant qu'il n'y a pas de cnx dispo dans le pool
		return ConnectionProvider.dataSource.getConnection();
	}
}