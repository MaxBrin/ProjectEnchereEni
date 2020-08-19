package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

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
			System.out.println(utilisateur.getNoUtilisateur());

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

	public static void modificationUtilisateur(Utilisateur utlisateur) throws BLLException {
		try {
			utilisateurDAO.updateUtilisateur(utlisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur modificationUtilisateur", e);
		}
	}

	public static void effacerUtilisateur(int noUtilisateur) throws BLLException {
		try {
			utilisateurDAO.deleteUtilisateur(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur effacerUtilisateur", e);
		}
	}

	public static Utilisateur getUtilisateur(int noUtilisateur) throws BLLException {
		Utilisateur utilisateur;
		try {
			utilisateur = utilisateurDAO.selectById(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur getUtilisateur", e);
		}
		return utilisateur;
	}

	public static String verifUtilisateur(Utilisateur utilisateur) {
		StringBuilder erreur = new StringBuilder();
		// TEST donn�es saisie

		// Pseudo
		if (utilisateur.getPseudo() == null || (!(StringUtils.isAlphanumeric(utilisateur.getPseudo())))
				|| utilisateur.getPseudo().trim().equals("")) {
			erreur.append("PseudoNonValide");
		}

		// Nom
		if (utilisateur.getNom() == null || utilisateur.getNom().trim().equals("")) {
			erreur.append("Nom");
		}

		// Prenom
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().equals("")) {
			erreur.append("Prenom");
		}

		// Email
		EmailValidator validator = EmailValidator.getInstance();
		if (!(validator.isValid(utilisateur.getEmail()))) {
			erreur.append("EmailNonValide");
		}

		// Test si Pseudo et Email d�j� pr�sent

		// R�cuperation de la liste des utilisateurs
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		try {
			listUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Vérification dans cette liste pour voir si le pseudo ou l'email est déjà
		// présent
		for (Utilisateur utilisateurBD : listUtilisateur) {
			if (utilisateurBD.getPseudo().equals(utilisateur.getPseudo())) {
				erreur.append("PseudoPresent");
			}
			if (utilisateurBD.getEmail().equals(utilisateur.getEmail())) {
				erreur.append("EmailPresent");
			}
		}

		// T�l�phone
		if (!(StringUtils.isNumeric(utilisateur.getTelephone())) || (!(utilisateur.getTelephone().length() == 10))) {
			erreur.append("Telephone");

		}

		// Rue
		if (utilisateur.getRue() == null || utilisateur.getRue().trim().equals("")) {
			erreur.append("Rue");
		}

		// CodePostal
		if (!(StringUtils.isNumeric(utilisateur.getCodePostal())) || (!(utilisateur.getCodePostal().length() == 5))) {
			erreur.append("CodePostal");
		}

		// Ville
		if (utilisateur.getVille() == null || utilisateur.getVille().trim().equals("")) {
			erreur.append("Ville");
		}
		// Test si les mot de passe sont identiquent
		if (utilisateur.getMotDePasse() == null) {
			erreur.append("MotDePasseIdentique");

		} else if (!(PasswordValidator.isLegalPassword(utilisateur.getMotDePasse()))) {
			erreur.append("MotDePasseVerif");
		}

		return erreur.toString();
	}

}
