package fr.eni.projetenchere.ihm.modele;

public class Filtre {

	private int noCategorie;
	private int noUtilisateurVendeur;
	private int noUtilisateurAcheteur;
	private String[] saisieUtilisateur;
	private boolean enCours;
	private boolean fini;
	private boolean nonDisponible;
	private boolean achat;

	public Filtre() {
		super();
	}

	public Filtre(int noCategorie, int noUtilisateurVendeur, int noUtilisateurAcheteur, String[] saisieUtilisateur,
			boolean enCours, boolean fini, boolean nonDisponible, boolean achat) {
		super();
		this.noCategorie = noCategorie;
		this.noUtilisateurVendeur = noUtilisateurVendeur;
		this.noUtilisateurAcheteur = noUtilisateurAcheteur;
		this.saisieUtilisateur = saisieUtilisateur;
		this.enCours = enCours;
		this.fini = fini;
		this.nonDisponible = nonDisponible;
		this.achat = achat;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public int getNoUtilisateurVendeur() {
		return noUtilisateurVendeur;
	}

	public void setNoUtilisateurVendeur(int noUtilisateurVendeur) {
		this.noUtilisateurVendeur = noUtilisateurVendeur;
	}

	public int getNoUtilisateurAcheteur() {
		return noUtilisateurAcheteur;
	}

	public void setNoUtilisateurAcheteur(int noUtilisateurAcheteur) {
		this.noUtilisateurAcheteur = noUtilisateurAcheteur;
	}

	public String[] getSaisieUtilisateur() {
		return saisieUtilisateur;
	}

	public void setSaisieUtilisateur(String[] saisieUtilisateur) {
		this.saisieUtilisateur = saisieUtilisateur;
	}

	public boolean isEnCours() {
		return enCours;
	}

	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}

	public boolean isFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

	public boolean isNonDisponible() {
		return nonDisponible;
	}

	public void setNonDisponible(boolean nonDisponible) {
		this.nonDisponible = nonDisponible;
	}

	public boolean isAchat() {
		return achat;
	}

	public void setAchat(boolean achat) {
		this.achat = achat;
	}

}
