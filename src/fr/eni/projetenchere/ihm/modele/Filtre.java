package fr.eni.projetenchere.ihm.modele;

import java.util.List;

public class Filtre {

	private int noCategorie;
	private int noUtilisateur;
	private String[] saisieUtilisateur;
	private List<String> choixUtilisateur;

	public Filtre(int noCategorie, int noUtilisateur, String[] saisieUtilisateur, List<String> choixUtilisateur) {
		super();
		this.noCategorie = noCategorie;
		this.noUtilisateur = noUtilisateur;
		this.saisieUtilisateur = saisieUtilisateur;
		this.choixUtilisateur = choixUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public String[] getSaisieUtilisateur() {
		return saisieUtilisateur;
	}

	public List<String> getChoixUtilisateur() {
		return choixUtilisateur;
	}

}
