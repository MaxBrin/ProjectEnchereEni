package fr.eni.projetenchere.bll;

public class PasswordValidator {
	// Pattern pour le password et vérifier qu'il conttient au moins une
	// majuscule,une miniscule,un caractère spécial et un chiffre
	private static final String pattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";

	// V�rification que le mot de passe correspond au pattern
	public static boolean isLegalPassword(String pass) {

		return pass.matches(pattern);
	}
}
