package fr.eni.projetenchere.ihm.modele;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Utilisateur;

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
		{

		}
		LocalDateTime dateActuelle = LocalDateTime.now();
		List<Article> listeFiltree = new ArrayList<>();

		for (Article article : listeArticlesBdd) {
			if (dateActuelle.isBefore(article.getFinEnchere())) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

	public static List<Article> filtrerVenteUserEncours(Utilisateur utilisateur) {
		LocalDateTime dateActuelle = LocalDateTime.now();
		int noUtilisateur = utilisateur.getNoUtilisateur();
		List<Article> articlesUtilisateur = new ArrayList<>();
		List<Article> listeFiltree = new ArrayList<Article>();
		try {
			articlesUtilisateur = ArticlesMgr.getListArticlesByNoUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		for (Article article : articlesUtilisateur) {
			if (article.getFinEnchere().isAfter(dateActuelle) && article.getDebutEnchere().isAfter(dateActuelle)) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

	public static List<Article> filtrerVentesUserFinies(Utilisateur utilisateur) {
		LocalDateTime dateActuelle = LocalDateTime.now();
		int noUtilisateur = utilisateur.getNoUtilisateur();
		List<Article> articlesUtilisateur = new ArrayList<>();
		List<Article> listeFiltree = new ArrayList<Article>();
		try {
			articlesUtilisateur = ArticlesMgr.getListArticlesByNoUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		for (Article article : articlesUtilisateur) {
			if (article.getFinEnchere().isAfter(dateActuelle)) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

	public static List<Article> filtrerVentesUserAVenir(Utilisateur utilisateur) {
		LocalDateTime dateActuelle = LocalDateTime.now();
		int noUtilisateur = utilisateur.getNoUtilisateur();
		List<Article> articlesUtilisateur = new ArrayList<>();
		List<Article> listeFiltree = new ArrayList<Article>();
		try {
			articlesUtilisateur = ArticlesMgr.getListArticlesByNoUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		for (Article article : articlesUtilisateur) {
			if (article.getDebutEnchere().isBefore(dateActuelle)) {
				listeFiltree.add(article);
			}
		}
		return listeFiltree;
	}

}
