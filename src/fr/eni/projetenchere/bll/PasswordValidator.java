package fr.eni.projetenchere.bll;

public class PasswordValidator {
	// Pattern pour le password et v�rifier qu'il conttient au moins une
	// majuscule,une miniscule,une caract�re sp�ciaux et un chiffre
	private static final String pattern = "^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[^\\w\\s])\\S{8,}$";

	// V�rification que le mot de passe correspond au pattern
	public static boolean isLegalPassword(String pass) {

		return pass.matches(pattern);
	}
}
