package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.UtilisateurDAO;

public class UtilisateurMgr {

	private static UtilisateurDAO utilisateurDAO;
	static {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public UtilisateurMgr() {

	}

	public static void ajoutUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			utilisateurDAO.insertUtilisateur(utilisateur);

		} catch (DALException e) {
			throw new BLLException("Erreur ajoutUtilisateur", e);
		}
	}

	public static List<Utilisateur> getListUtilisateur() throws BLLException {
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		try {
			listUtilisateur = utilisateurDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur getListUtilisateur", e);
		}
		return listUtilisateur;
	}

	public void verifUtilisateur(Utilisateur utilisateur) {

	}
}
