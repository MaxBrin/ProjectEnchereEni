package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

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
import fr.eni.projetenchere.bll.RetraitMgr;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Categorie;
import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.ihm.modele.Chargement;

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
		// Récupération de l'utilisateur dans la session pour l'adresse par default
		HttpSession session = request.getSession();
		Integer noUtilisateur = (int) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = new Utilisateur();

		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e) {
			// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		Retrait retrait = new Retrait(utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille());
		// Vérification si l'utilisateur a cliqué sur "Modifier"
		if (!(("").equals(request.getParameter("ModificationArticle")))
				&& ((request.getParameter("ModificationArticle")) != null)) {
			// Récupération du numéro de l'article à modifier
			String noArticleAModifier = request.getParameter("ModificationArticle");
			int noArticle = Integer.parseInt(noArticleAModifier);
			Article article = null;
			// Récupération de l'article à modifier
			try {
				article = ArticlesMgr.getArticle(noArticle);
			} catch (BLLException e) {
				// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
				request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
				e.printStackTrace();
			}
			// Envoie d'attribut à afficher
			request.setAttribute("article", article);
			request.setAttribute("dateDebut", article.getDebutEnchere().toLocalDate());
			request.setAttribute("dateFin", article.getFinEnchere().toLocalDate());
		}
		// Si c'est une nouvelle vente chargment de la liste des catégorie
		request = Chargement.chargementListCategorie(request, response);
		// Envoie de l'utilisateur pour son adresse de retrait
		request.setAttribute("retrait", retrait);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération de l'utilisateur dans la session et de son id
		HttpSession session = request.getSession();
		int noUtilisateur = (int) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = null;
		try {
			utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
		} catch (BLLException e3) {
			// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e3.printStackTrace();
		}

		// Declaration de variables
		LocalDateTime debutEnchere = null;
		LocalDateTime finEnchere = null;
		int miseAPrix = 0;
		int categorieSaisie = 0;

		// Récupération des saisies de l'utilisateur sur l'article et l'adresse
		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");

		String miseAPrixSaisie = request.getParameter("miseAPrix");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		// Récupération des dates de l'enchère et transformation String -> LocalDateTime
		try {
			debutEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("debutEnchere")), LocalTime.now());
			finEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("finEnchere")), LocalTime.now());
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}

		// Tentative de transformation des Strings en int
		try {
			categorieSaisie = Integer.parseInt(request.getParameter("categorie"));
			miseAPrix = Integer.parseInt(miseAPrixSaisie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Creation de la Categorie
		Categorie categorie = new Categorie();
		try {
			categorie = CategorieMgr.getCategorie(categorieSaisie);
		} catch (BLLException e2) {
			// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e2.printStackTrace();
		}

		// Creation de l'article à partir des données récupérées et ajout dans la liste
		// des Articles
		Article article = new Article(nom, description, debutEnchere, finEnchere, miseAPrix, utilisateur, categorie);
		// Vérification de la validité des données saisies avant de valider l'article
		HashMap<String, String> erreurs = ArticlesMgr.verifierVenteArticle(article, rue, codePostal, ville);
		Retrait retrait = new Retrait(rue, codePostal, ville);
		RequestDispatcher rd;
		if (erreurs.isEmpty()) {

			try {
				ArticlesMgr.ajoutArticle(article);
			} catch (BLLException e) {
				// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
				request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
				e.printStackTrace();
			}
			retrait.setNoArticle(article.getNoArticle());
			try {
				RetraitMgr.ajouterRetrait(retrait);
			} catch (BLLException e) {
				// Si Erreur de connexion avec la base de donnée envoie sur une page l'indiquant
				request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
				e.printStackTrace();
			}
			// Chargement des listes à afficher par default
			request = Chargement.chargementListArticle(request, response);
			request = Chargement.chargementListCategorie(request, response);
			// Checkbox par default
			request.setAttribute("choixAchat", "achat");
			request.setAttribute("ckEncheresOuvertesCheck", true);
			// Redirection vers la pages d'accueil
			rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		} else {
			// Si il y'a des erreurs renvoie des données saisies par l'utilisateur
			request = Chargement.chargementListCategorie(request, response);
			request.setAttribute("listeErreur", erreurs);
			request.setAttribute("article", article);
			request.setAttribute("dateFin", article.getDebutEnchere().toLocalDate());
			request.setAttribute("dateDebut", article.getFinEnchere().toLocalDate());
			request.setAttribute("retrait", retrait);
			request.setAttribute("utilisateur", utilisateur);
			rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
		}
		rd.forward(request, response);

	}

}
