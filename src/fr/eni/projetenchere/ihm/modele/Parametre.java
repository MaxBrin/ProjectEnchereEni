package fr.eni.projetenchere.ihm.modele;

public class Parametre {
	private Integer noUtilisateur;
	private String chkboxeEncheresOuvertes;
	private String chkboxeMesEncheres;
	private String chkboxeEncheresEmportees;
	private String chkboxeMesVentesEnCours;
	private String chkboxeMesVentesNonDebutees;
	private String chkboxeVentesTerminees;
	private Integer noCategorie;
	private String rechercheUtilisateur;

	public Parametre(Integer noUtilisateur, String chkboxeEncheresOuvertes, String chkboxeMesEncheres,
			String chkboxeEncheresEmportees, String chkboxeMesVentesEnCours, String chkboxeMesVentesNonDebutees,
			String chkboxeVentesTerminees, Integer noCategorie, String rechercheUtilisateur) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.chkboxeEncheresOuvertes = chkboxeEncheresOuvertes;
		this.chkboxeMesEncheres = chkboxeMesEncheres;
		this.chkboxeEncheresEmportees = chkboxeEncheresEmportees;
		this.chkboxeMesVentesEnCours = chkboxeMesVentesEnCours;
		this.chkboxeMesVentesNonDebutees = chkboxeMesVentesNonDebutees;
		this.chkboxeVentesTerminees = chkboxeVentesTerminees;
		this.noCategorie = noCategorie;
		this.rechercheUtilisateur = rechercheUtilisateur;
	}

	public Integer getNoUtilisateur() {
		return noUtilisateur;
	}

	public String getChkboxeEncheresOuvertes() {
		return chkboxeEncheresOuvertes;
	}

	public String getChkboxeMesEncheres() {
		return chkboxeMesEncheres;
	}

	public String getChkboxeEncheresEmportees() {
		return chkboxeEncheresEmportees;
	}

	public String getChkboxeMesVentesEnCours() {
		return chkboxeMesVentesEnCours;
	}

	public String getChkboxeMesVentesNonDebutees() {
		return chkboxeMesVentesNonDebutees;
	}

	public String getChkboxeVentesTerminees() {
		return chkboxeVentesTerminees;
	}

	public Integer getNoCategorie() {
		return noCategorie;
	}

	public String getRechercheUtilisateur() {
		return rechercheUtilisateur;
	}

}
