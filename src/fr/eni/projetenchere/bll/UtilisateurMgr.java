package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.UtilisateurDAO;

public class UtilisateurMgr {
	// Chargement implémentation utilisateur DAO
	private static UtilisateurDAO utilisateurDAO;
	static {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	/**
	 * Méthode pour ajouter un utilisateur
	 * 
	 * @param utilisateur
	 * @throws BLLException
	 */
	public static void ajoutUtilisateur(Utilisateur utilisateur) throws BLLException {
		try {
			utilisateurDAO.insertUtilisateur(utilisateur);
			System.out.println(utilisateur.getNoUtilisateur());

		} catch (DALException e) {
			throw new BLLException("Erreur ajoutUtilisateur", e);
		}
	}

	/**
	 * Méthode pour récuperer la liste de tout les utilisateurs
	 * 
	 * @return
	 * @throws BLLException
	 */
	public static List<Utilisateur> getListUtilisateur() throws BLLException {
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		try {
			listUtilisateur = utilisateurDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur getListUtilisateur", e);
		}
		return listUtilisateur;
	}

	/**
	 * Méthode pour mettre à jour un utilisateur
	 * 
	 * @param utlisateur
	 * @throws BLLException
	 */
	public static void modificationUtilisateur(Utilisateur utlisateur) throws BLLException {
		try {
			utilisateurDAO.updateUtilisateur(utlisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur modificationUtilisateur", e);
		}
	}

	/**
	 * Méthode pour effacer un utilisateur
	 * 
	 * @param noUtilisateur
	 * @throws BLLException
	 */
	public static void effacerUtilisateur(int noUtilisateur) throws BLLException {
		try {
			utilisateurDAO.deleteUtilisateur(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur effacerUtilisateur", e);
		}
	}

	/**
	 * Methode pour récuperer un utilisateur en fonction de son numéro
	 */
	public static Utilisateur getUtilisateur(int noUtilisateur) throws BLLException {
		Utilisateur utilisateur;
		try {
			utilisateur = utilisateurDAO.selectById(noUtilisateur);
		} catch (DALException e) {
			throw new BLLException("Erreur getUtilisateur", e);
		}
		return utilisateur;
	}

	/**
	 * Méthode pour vérifier si les saisie de l'utilisateur permettent de créer une
	 * nouvelle vente
	 * 
	 * @param utilisateur
	 * @return
	 */
	public static HashMap<String, String> verifierUtilisateur(Utilisateur utilisateur) {
		HashMap<String, String> erreurs = new HashMap<String, String>();
		// Pseudo : utilisation d'une librairie pour vérifier qu'il est Alphanumeric
		if (utilisateur.getPseudo() == null || (!(StringUtils.isAlphanumeric(utilisateur.getPseudo())))
				|| utilisateur.getPseudo().trim().equals("")) {
			erreurs.put("pseudoNonValide", "Le pseudo n'est pas valide. ");
		}
		// Nom
		if (utilisateur.getNom() == null || utilisateur.getNom().trim().equals("")) {
			erreurs.put("nom", "Le nom doit être renseigné. ");
		}
		// Prenom
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().trim().equals("")) {
			erreurs.put("prenom", "Le prénom doit être renseigné.");
		}
		// Email : Utilisation d'une librairie pour vérifier que l'email est
		// valide(exemple@exemple.com)
		EmailValidator validator = EmailValidator.getInstance();
		if (!(validator.isValid(utilisateur.getEmail()))) {
			erreurs.put("emailNonValide", "L'email n'est pas valide.");
		}
		// Test si Pseudo et Email déjà présent

		// Récuperation de la liste des utilisateurs
		List<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		try {
			listUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			e.printStackTrace();
		}
		// Vérification dans cette liste pour voir si le pseudo ou l'email est déjà
		// présent
		for (Utilisateur utilisateurBD : listUtilisateur) {
			if (utilisateurBD.getPseudo().equals(utilisateur.getPseudo())) {
				erreurs.put("pseudoPresent", "Le pseudo est déjà présent.");
			}
			if (utilisateurBD.getEmail().equals(utilisateur.getEmail())) {
				erreurs.put("emailPresent", "L'email est déjà présent.");
			}
		}
		// Téléphone
		if (!(StringUtils.isNumeric(utilisateur.getTelephone())) || (!(utilisateur.getTelephone().length() == 10))) {
			erreurs.put("telephone", "Le numéro de téléphone n'est pas valide");

		}
		// Rue
		if (utilisateur.getRue() == null || utilisateur.getRue().trim().equals("")) {
			erreurs.put("rue", "La rue doit être renseigné.");
		}

		// CodePostal
		if (!(StringUtils.isNumeric(utilisateur.getCodePostal())) || (!(utilisateur.getCodePostal().length() == 5))) {
			erreurs.put("codePostal", "Le code postal doit être renseigné.");
		}

		// Ville
		if (utilisateur.getVille() == null || utilisateur.getVille().trim().equals("")) {
			erreurs.put("ville", "La ville doit être renseigné.");
		}
		// Test si les mot de passe ne sont pas identiquent
		if (utilisateur.getMotDePasse() == null) {
			erreurs.put("MotDePasseNonIdentique", "Les mots de passe ne sont pas identiques");

		} else if (!(PasswordValidator.isLegalPassword(utilisateur.getMotDePasse()))) {
			erreurs.put("MotDePasseVerif", "Le mot de passe n'est pas valide.");
		}

		return erreurs;
	}

}
