package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.UtilisateurDAO;

public class UtilisateurMgr {
		
	private UtilisateurDAO utilisateurDAO ;
	
	
	public UtilisateurMgr() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}


	public void ajoutUtilisateur (Utilisateur utilisateur) throws BLLException {
		try {
			utilisateurDAO.insertUtilisateur(utilisateur);
			
		} catch (DALException e) {
			throw new BLLException ("Erreur ajoutUtilisateur",e);
		}
	}
}
