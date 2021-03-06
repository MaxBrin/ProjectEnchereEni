package fr.eni.projetenchere.bo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Enchere implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noEnchere;
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	private int noArticle;
	private int noUtilisateur;

	public Enchere() {
		super();
	}

	public Enchere(LocalDateTime dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
	}

	public Enchere(int noEnchere, LocalDateTime dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + "]";
	}

}
