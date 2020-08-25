package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.ihm.modele.Chargement;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class ServletVersPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choix = request.getParameter("choix");

		if ("achat".equals(choix)) {
			request.setAttribute("choixAchat", "achat");
		}

		if ("mesVentes".equals(choix)) {
			request.setAttribute("choixAchat", "ventes");
		}
		request = Chargement.chargementListArticle(request);
		request = Chargement.chargementListCategorie(request);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//*********************************Traitement bouton select**********************************************

		// Récupération et transformation en int de la valeur du select
		String choixCategorie = request.getParameter("categorie");
		int noCategorie = Integer.parseInt(choixCategorie);
		List<Article> listeAAfficher = new ArrayList<>();
		listeAAfficher = trierArticleParCategorie(noCategorie);

//************Affichage articles en fonction de la recherche par nom en mode déconnexion*****************

		// Je récupère la saisie de l'utilisateur
		String rechercheUtilisateur = request.getParameter("rechercherArticle").toUpperCase();
		String rechercheUtilisateurARenvoyer = request.getParameter("rechercherArticle");
		// Je crée le tableau avec chaque mot de la recherche
		List<Article> listeArticlesAAfficher = null;

		if (rechercheUtilisateur.trim().length() == 0) {
			listeArticlesAAfficher = listeAAfficher;
		} else {
			listeArticlesAAfficher = trierArticleParRechercheNom(rechercheUtilisateur, listeAAfficher);
		}

//**************************************************************************************		
		// Envoie des informations
		request = Chargement.chargementListArticle(request);
		request = Chargement.chargementListCategorie(request);
		request.setAttribute("listeArticlesAAfficher", listeArticlesAAfficher);
		request.setAttribute("saisieUtilisateur", rechercheUtilisateurARenvoyer);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

//*****Méthode qui  renvoie une liste d'article en fonction du int de la catégorie***************************
	public List<Article> trierArticleParCategorie(int categorie) {
		List<Article> listeARetourner = new ArrayList<>();
		if (0 == categorie) {
			try {
				listeARetourner = ArticlesMgr.getListArticlesNonConnecte();
			} catch (BLLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				listeARetourner = ArticlesMgr.getListArticlesByNoCategorie(categorie);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		return listeARetourner;
	}

//***********Méthode qui retourne la liste d'articles a afficher en fonction de la recherche par nom***********************************	
	public List<Article> trierArticleParRechercheNom(String saisieUtilisateur, List<Article> listeArticle) {

		String[] listeMotsRecherche = saisieUtilisateur.split(" ");
		List<Article> listeARetourner = new ArrayList<>();
		List<Article> listeArticlesBdd = null;

		// Pour chaque mot de la recherche utlisateur
		for (String mot : listeMotsRecherche) {
			// Pour chaque article trié apres le select
			for (Article article : listeArticle) {
				String nomArticle = article.getNomArticle().toUpperCase();
				String[] motsDansNomArticle = nomArticle.split(" ");
				for (String motDansNom : motsDansNomArticle) {
					if (motDansNom.contains(mot)) {
						listeARetourner.add(article);
					}
				}
			}
		}

		return listeARetourner;
	}

}
