package fr.eni.projetenchere.dal;

import java.util.List;

import fr.eni.projetenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	void insertUtilisateur(Utilisateur utilisateur) throws DALException;

	public abstract List<Utilisateur> selectAll() throws DALException;

	public abstract void deleteUtilisateur() throws DALException;

	public abstract void updateUtilisateur(Utilisateur utilisateur) throws DALException;

	public abstract Utilisateur selectById(int id) throws DALException;
}
