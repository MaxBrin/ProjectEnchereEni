package fr.eni.projetenchere.dal;

public class DAOFactory {
	public UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
