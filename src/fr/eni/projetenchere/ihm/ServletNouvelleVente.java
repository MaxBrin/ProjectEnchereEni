package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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

		// Récupération de l'utilisateur dans la session et de son id
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = null;
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e3) {
			e3.printStackTrace();
		}

		// Declaration de variables
		LocalDateTime debutEnchere = null;
		LocalDateTime finEnchere = null;
		int noCategorie = 0;
		int miseAPrix = 0;

		// Récupération des saisies de l'utilisateur sur l'article et l'adresse
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorieSaisie = request.getParameter("categorie");
		String miseAPrixSaisie = request.getParameter("miseAPrix");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		// Récupération des dates de l'enchère et transformation String -> LocalDateTime
		try {
			debutEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("debutEnchere")), LocalTime.now());
			finEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("finEnchere")), LocalTime.now());
		} catch (DateTimeParseException e) {
			// TODO MESSAGE ERREUR DATE
		}

		// Tentative de transformation des Strings en int
		try {
			noCategorie = Integer.parseInt(categorieSaisie);
			miseAPrix = Integer.parseInt(miseAPrixSaisie);
		} catch (Exception e) {
			// TODO MESSAGE ERREUR CATEGORIE / MISE A PRIX
		}

		// Creation de la Categorie
		Categorie categorie = null;
		try {
			categorie = CategorieMgr.getCategorie(noCategorie);
		} catch (BLLException e2) {
			e2.printStackTrace();
		}

		// Creation de l'article à partir des données récupérées et ajout dans la liste
		// des Articles
		Article article = new Article(nom, description, debutEnchere, finEnchere, miseAPrix, utilisateur, categorie);
		// Vérification de la validité des données saisies avant de valider l'article
		String erreur = ArticlesMgr.verifierVenteArticle(article, rue, codePostal, ville);
		if (erreur.isEmpty()) {
			try {
				ArticlesMgr.ajoutArticle(article);

			} catch (BLLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("listeErreur", erreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente");
		}

	}

}
