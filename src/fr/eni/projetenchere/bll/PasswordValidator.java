package fr.eni.projetenchere.bll;

import java.util.regex.Pattern;

public class PasswordValidator {
	// Pattern pour le password et v�rifier qu'il conttient au moins une
	// majuscule,une miniscule,une caract�re sp�ciaux et un chiffre
	private static final Pattern[] passwordRegexes = new Pattern[4];
	static {
		passwordRegexes[0] = Pattern.compile(".*[A-Z].*");
		passwordRegexes[1] = Pattern.compile(".*[a-z].*");
		passwordRegexes[2] = Pattern.compile(".*\\d.*");
		passwordRegexes[3] = Pattern.compile(".*[~!].*");
	}

	// V�rification que le mot de passe correspond au pattern
	public static boolean isLegalPassword(String pass) {

		for (int i = 0; i < passwordRegexes.length; i++) {
			if (!passwordRegexes[i].matcher(pass).matches())
				return false;
		}
		return true;
	}
}
