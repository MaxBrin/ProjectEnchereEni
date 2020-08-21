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
		request = Chargement.chargementList(request);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//*********************************Traitement bouton select***********************************************

		// Récupération de la valeur du select
		String choixCategorie = request.getParameter("categorie");
		int noCategorie = Integer.parseInt(choixCategorie);

		// Création de la liste à renvoyer pour l'afficher
		List<Article> listeAAfficher = new ArrayList<>();

		if ("0".equals(choixCategorie)) {
			try {
				listeAAfficher = ArticlesMgr.getListArticles();
			} catch (BLLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				listeAAfficher = ArticlesMgr.getListArticlesByNoCategorie(noCategorie);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

//******************************Affichage articles en fonction de la recherche par nom en mode déconnexion**********************************************

		// Initialisation et récupération de la liste de tous les articles de la bdd
		List<Article> listeArticle = new ArrayList<>();
		try {
			listeArticle = ArticlesMgr.getListArticles();
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Je récupère la saisie de l'utilisateur
		String rechercheUtilisateur = request.getParameter("rechercherArticle").toUpperCase();
		// Je crée le tableau avec chaque mot de la recherche
		String[] listeMotsRecherche = rechercheUtilisateur.split(" ");

		List<Article> listeArticleFiltreeParNom = new ArrayList<>();

		for (String mot : listeMotsRecherche) {
			for (Article article : listeArticle) {
				String nomArticle = article.getNomArticle().toUpperCase();
				String[] motsDansNomArticle = nomArticle.split(" ");
				for (String motDansNom : motsDansNomArticle) {
					if (motDansNom.equals(mot)) {
						listeArticleFiltreeParNom.add(article);
						break;
					}
				}
			}
		}

//**************************************************************************************		
		// Envoie des informations
		request.setAttribute("listeArticlesFiltreeParNom", listeArticleFiltreeParNom);
		request = Chargement.chargementList(request);
		request.setAttribute("listeArticlesAAfficher", listeAAfficher);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

}
