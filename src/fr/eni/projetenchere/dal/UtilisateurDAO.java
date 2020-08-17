package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	void insertUtilisateur(Utilisateur utilisateur) throws DALException;

	public abstract List<Utilisateur> selectAll() throws DALException;

}
