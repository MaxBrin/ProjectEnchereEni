package fr.eni.projetenchere.ihm.modele;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bo.Article;

public class FiltresListe {

	public static List<Article> filtrerVentesEnCours(List<Article> listeArticlesBdd) {

		LocalDateTime dateActuelle = LocalDateTime.now();
		List<Article> listeFiltree = new ArrayList<>();

		for (Article article : listeArticlesBdd) {
			if (dateActuelle.isBefore(article.getFinEnchere()) && dateActuelle.isAfter(article.getDebutEnchere())) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

	public static List<Article> filtrerVentesTerminees(List<Article> listeArticlesBdd) {
		LocalDateTime dateActuelle = LocalDateTime.now();
		List<Article> listeFiltree = new ArrayList<>();

		for (Article article : listeArticlesBdd) {
			if (dateActuelle.isAfter(article.getFinEnchere())) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

	public static List<Article> filtrerVentesAVenir(List<Article> listeArticlesBdd) {
		LocalDateTime dateActuelle = LocalDateTime.now();
		List<Article> listeFiltree = new ArrayList<>();

		for (Article article : listeArticlesBdd) {
			if (dateActuelle.isBefore(article.getFinEnchere())) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

}
