package fr.eni.projetenchere.ihm.modele;

import java.time.LocalDateTime;

public class Filtre {
	private String filtreSaisie;
	private int noCategorie;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private int noUtilisateur;

	public Filtre(String filtreSaisie, int noCategorie, LocalDateTime dateDebut, LocalDateTime dateFin,
			int noUtilisateur) {
		super();
		this.filtreSaisie = filtreSaisie;
		this.noCategorie = noCategorie;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.noUtilisateur = noUtilisateur;
	}

	public String getFiltreSaisie() {
		return filtreSaisie;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

}
