package fr.eni.projetenchere.ihm.modele;

import java.util.Arrays;

public class Filtre {

	private int noCategorie;
	private int noUtilisateur;
	private String[] saisieUtilisateur;
	private boolean EnCours;
	private boolean Fini;
	private boolean NonDisponible;

	public Filtre(int noCategorie, int noUtilisateur, String[] saisieUtilisateur, boolean enCours, boolean fini,
			boolean nonDisponible) {
		super();
		this.noCategorie = noCategorie;
		this.noUtilisateur = noUtilisateur;
		this.saisieUtilisateur = saisieUtilisateur;
		EnCours = enCours;
		Fini = fini;
		NonDisponible = nonDisponible;
	}

	public Filtre() {
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String[] getSaisieUtilisateur() {
		return saisieUtilisateur;
	}

	public void setSaisieUtilisateur(String[] saisieUtilisateur) {
		this.saisieUtilisateur = saisieUtilisateur;
	}

	public boolean isEnCours() {
		return EnCours;
	}

	public void setEnCours(boolean enCours) {
		EnCours = enCours;
	}

	public boolean isFini() {
		return Fini;
	}

	public void setFini(boolean fini) {
		Fini = fini;
	}

	public boolean isNonDisponible() {
		return NonDisponible;
	}

	public void setNonDisponible(boolean nonDisponible) {
		NonDisponible = nonDisponible;
	}

	@Override
	public String toString() {
		return "Filtre [noCategorie=" + noCategorie + ", noUtilisateur=" + noUtilisateur + ", saisieUtilisateur="
				+ Arrays.toString(saisieUtilisateur) + ", EnCours=" + EnCours + ", Fini=" + Fini + ", NonDisponible="
				+ NonDisponible + "]";
	}

}
