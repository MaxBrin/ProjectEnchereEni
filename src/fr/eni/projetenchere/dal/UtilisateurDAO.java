package fr.eni.projetenchere.dal;

import fr.eni.projetenchere.bo.Utilisateur;

public interface UtilisateurDAO {
	void insertUtilisateur (Utilisateur utilisateur) throws DALException;
}
