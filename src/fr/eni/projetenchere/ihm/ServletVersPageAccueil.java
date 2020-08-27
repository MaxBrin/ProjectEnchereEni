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
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.ihm.modele.Chargement;
import fr.eni.projetenchere.ihm.modele.Filtre;
import fr.eni.projetenchere.ihm.modele.Parametre;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class ServletVersPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération du numéro d'utilisateur si il est connecter
		HttpSession session = request.getSession();
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		// Récupération valeur bouton radio
		String choix = request.getParameter("choix");

		// Creation du filtre
		Filtre filtre = new Filtre();
		if ("annuler".equals(choix)) {
			request.setAttribute("choixAchat", null);
		}

		if ("achat".equals(choix)) {
			request.setAttribute("choixAchat", "achat");
		}
		if ("mesVentes".equals(choix)) {
			request.setAttribute("choixAchat", "ventes");
			filtre.setNoUtilisateurVendeur(noUtilisateur);
		}

		// Récupération des article en bdd
		List<Article> listeArticlesAAfficher = new ArrayList<>();
		// Attribution des filtres "recherche par nom" et "categorie"
		String[] saisieVide = { "" };
		filtre.setSaisieUtilisateur(saisieVide);
		filtre.setEnCours(true);
		// Récupération des listes Articles et Catégories
		try {
			// Filtrage de la liste
			listeArticlesAAfficher = ArticlesMgr.getListArticleFiltre(filtre);
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.setAttribute("listeArticlesAAfficher", listeArticlesAAfficher);
		request = Chargement.chargementListCategorie(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//************Affichage articles en fonction de la recherche*****************
		// Récupération de l'id utilisateur
		HttpSession session = request.getSession();
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		// Récupération de la saisie de recherche par nom
		String rechercheUtilisateur = request.getParameter("rechercherArticle").toUpperCase();
		String rechercheUtilisateurARenvoyer = request.getParameter("rechercherArticle");
		// Récupération de la categorie
		String categorie = request.getParameter("categorie");
		Integer noCategorie = Integer.parseInt(categorie);
		// Récupération des checkboxes
		String chkboxeEncheresOuvertes = request.getParameter("encheresOuvertes");
		String chkboxeMesEncheres = request.getParameter("mesEncheres");
		String chkboxeEncheresEmportees = request.getParameter("encheresRemportees");
		String chkboxeMesVentesEnCours = request.getParameter("ventesEnCours");
		String chkboxeMesVentesNonDebutees = request.getParameter("ventesNonDebutees");
		String chkboxeVentesTerminees = request.getParameter("ventesTerminees");
		//
		Parametre param = new Parametre(noUtilisateur, chkboxeEncheresOuvertes, chkboxeMesEncheres,
				chkboxeEncheresEmportees, chkboxeMesVentesEnCours, chkboxeMesVentesNonDebutees, chkboxeVentesTerminees,
				noCategorie, rechercheUtilisateur);
		// Creation du filtre
		Filtre filtre = getFiltre(param, request);
		// Récupération des article en bdd
		List<Article> listeArticlesAAfficher = new ArrayList<>();

		try {
			// Filtrage de la liste
			listeArticlesAAfficher = ArticlesMgr.getListArticleFiltre(filtre);
		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}

		// Récupération valeur bouton radio
		String choix = request.getParameter("choix");
		if ("annuler".equals(choix)) {
			request.setAttribute("choixAchat", null);
		}

		if ("achat".equals(choix)) {
			request.setAttribute("choixAchat", "achat");
		}
		if ("ventes".equals(choix)) {
			request.setAttribute("choixAchat", "ventes");

		}
//**************************************************************************************		
		// Envoie des informations
		request = Chargement.chargementListCategorie(request, response);
		request.setAttribute("categorieSaisie", noCategorie);
		request.setAttribute("listeArticlesAAfficher", listeArticlesAAfficher);
		request.setAttribute("saisieUtilisateur", rechercheUtilisateurARenvoyer);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

	/**
	 * Méthode pour créer le filtre pour la liste d'article
	 * 
	 * @param param
	 * @param request
	 * @return
	 */
	protected Filtre getFiltre(Parametre param, HttpServletRequest request) {
		// Creation du filtre
		Filtre filtre = new Filtre();
		// Attribution des filtres "recherche par nom" et "categorie"
		filtre.setNoCategorie(param.getNoCategorie());
		filtre.setSaisieUtilisateur(param.getRechercheUtilisateur().split(" "));
		filtre.setEnCours(true);

		// Si un utilisateur est connecté
		if (param.getNoUtilisateur() != null) {
			// Conversion du noUtilisateur String -> int pour l'ajouter au filtre
			int noUser = param.getNoUtilisateur();

			// Ajout des filtres en fonction des checkboxes
			// Si la checkBox "Mes ventes en cours" est cochée
			if (param.getChkboxeMesVentesEnCours() != null) {
				filtre.setNoUtilisateurVendeur(noUser);
				filtre.setEnCours(true);
			} else {
				filtre.setEnCours(false);
			}

			// Si la checkBox "Ventes non débutées" est cochée
			if (param.getChkboxeMesVentesNonDebutees() != null) {
				filtre.setNoUtilisateurVendeur(noUser);
				filtre.setNonDisponible(true);
			}
			// Si la checkBox "Ventes Terminees" est cochée
			if (param.getChkboxeVentesTerminees() != null) {
				filtre.setNoUtilisateurVendeur(noUser);
				filtre.setFini(true);
			}
			// Ajout des filtres en fonction des checkboxes
			// Si la checkBox "Encheres Ouvertes" est cochée
			if (param.getChkboxeEncheresOuvertes() != null) {
				filtre.setEnCours(true);
			}

			// Si la checkBox "Mes Enchères" est cochée
			if (param.getChkboxeMesEncheres() != null) {
				filtre.setNoUtilisateurAcheteur(noUser);
				filtre.setAchat(true);
			}
			// Si la checkBox "Mes Encheres Emportees" est cochée
			if (param.getChkboxeEncheresEmportees() != null) {
				filtre.setNoUtilisateurAcheteur(noUser);
				filtre.setAchat(true);
				filtre.setFini(true);
			}

		}
		return filtre;
	}

}
