package fr.eni.projetenchere.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Atributs
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDateTime debutEnchere;
	private LocalDateTime finEnchere;
	private int prixInitial;
	private int prixVente;
	private Utilisateur utilisateur;
	private Categorie categorie;

	// Constructeurs
	public Article() {
		super();
	}

	public Article(String nomArticle, String description, LocalDateTime debutEnchere, LocalDateTime finEnchere,
			int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public Article(int noArticle, String nomArticle, String description, LocalDateTime debutEnchere,
			LocalDateTime finEnchere, int prixInitial, int prixVente, Utilisateur utilisateur, Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public Article(int noArticle, String nomArticle, String description, LocalDateTime debutEnchere,
			LocalDateTime finEnchere, int prixInitial, Utilisateur noUtilisateur, Categorie categorie) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	// Getter Setters
	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDebutEnchere() {
		return debutEnchere;
	}

	public void setDebutEnchere(LocalDateTime debutEnchere) {
		this.debutEnchere = debutEnchere;
	}

	public LocalDateTime getFinEnchere() {
		return finEnchere;
	}

	public void setFinEnchere(LocalDateTime finEnchere) {
		this.finEnchere = finEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setNoCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
