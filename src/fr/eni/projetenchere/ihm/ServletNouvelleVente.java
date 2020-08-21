package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.CategorieMgr;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// R�cup�ration de l'utilisateur dans la session et de son id
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");

		// Je r�cup�re la liste des Articles en bdd
		List<Article> listeArticles = new ArrayList<>();
		try {
			listeArticles = ArticlesMgr.getListArticles();
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		// R�cup�ration des saisies de l'utilisateur sur l'artcile
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorieSaisie = request.getParameter("categorie");
		String miseAPrixSaisie = request.getParameter("miseAPrix");

		// Declaration de variables
		LocalDateTime debutEnchere = null;
		LocalDateTime finEnchere = null;
		int noCategorie = 0;
		int miseAPrix = 0;

		// Creation de l'objet Categorie

		try {
			noCategorie = Integer.parseInt(categorieSaisie);
			miseAPrix = Integer.parseInt(miseAPrixSaisie);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		// Récupération des dates de l'enchère
		try {
			debutEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("debutEnchere")), LocalTime.now());
			finEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("finEnchere")), LocalTime.now());
		} catch (DateTimeParseException e) {
			// TODO MESSAGE ERREUR DATE
		}
		// TODO VERIF DONNEES
		Utilisateur utilisateur = new Utilisateur();
		Categorie categorie = new Categorie();
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
			categorie = CategorieMgr.getCategorie(noCategorie);
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Article article = new Article(nom, description, debutEnchere, finEnchere, miseAPrix, utilisateur, categorie);
		listeArticles.add(article);

		try {
			ArticlesMgr.ajoutArticle(article);
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

}
