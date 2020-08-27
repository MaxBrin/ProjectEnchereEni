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

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class ServletVersPageAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération valeur bouton radio
		String choix = request.getParameter("choix");

		if ("annuler".equals(choix)) {
			request.setAttribute("choixAchat", null);
		}

		if ("achat".equals(choix)) {
			request.setAttribute("choixAchat", "achat");
		}
		if ("mesVentes".equals(choix)) {
			request.setAttribute("choixAchat", "ventes");
		}
		// Récupération des listes Articles et Catégories
		request = Chargement.chargementListArticle(request);
		request = Chargement.chargementListCategorie(request);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//************Affichage articles en fonction de la recherche*****************
		// Récupération de l'id utilisateur
		HttpSession session = request.getSession();
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		// Récupération de la saisie de recherche par nom et transformation en tableau
		// de String
		String rechercheUtilisateur = request.getParameter("rechercherArticle").toUpperCase();
		String rechercheUtilisateurARenvoyer = request.getParameter("rechercherArticle");
		String[] tabMotsRecherche = rechercheUtilisateur.split(" ");
		// Récupération de la categorie
		String categorie = request.getParameter("categorie");
		Integer noCategorie = Integer.parseInt(categorie);
		// Récupération des boutons radio
		// String radioAchats = request.getParameter("achat");
		String radioMesVentes = request.getParameter("mesVentes");
		// Récupération des checkboxes
		// String chkboxeEncheresOuvertes = request.getParameter("encheresOuvertes");
		// String chkboxeMesEncheres = request.getParameter("mesEncheres");
		// String chkboxeEncheresEmportees = request.getParameter("encheresRemportees");
		String chkboxeMesVentesEnCours = request.getParameter("ventesEnCours");
		String chkboxeMesVentesNonDebutees = request.getParameter("ventesNonDebutees");
		String chkboxeVentesTerminees = request.getParameter("ventesTerminees");

		// Creation du filtre
		Filtre filtre = new Filtre();
		// Récupération des article en bdd
		List<Article> listeArticlesAAfficher = new ArrayList<>();
		// Attribution des filtres "recherche par nom" et "categorie"
		filtre.setNoCategorie(noCategorie);
		filtre.setSaisieUtilisateur(rechercheUtilisateur.split(" "));
		filtre.setEnCours(true);

		// Si un utilisateur est connecté
		if (noUtilisateur != null) {
			// Conversion du noUtilisateur String -> int pour l'ajouter au filtre
			int noUser = noUtilisateur;
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
				filtre.setNoUtilisateur(noUser);
				filtre.setEnCours(false);
			}

			// Ajout des filtres en fonction des checkboxes
			// Si la checkBox "Mes ventes en cours" est cochée
			if (chkboxeMesVentesEnCours != null) {
				filtre.setEnCours(true);
			}

			// Si la checkBox "Ventes non débutées" est cochée
			if (chkboxeMesVentesNonDebutees != null) {
				filtre.setNonDisponible(true);
			}
			// Si la checkBox "Ventes Terminees" est cochée
			if (chkboxeVentesTerminees != null) {
				filtre.setFini(true);
			}

		}
		try {
			// Filtrage de la liste
			listeArticlesAAfficher = ArticlesMgr.getListArticleFiltre(filtre);
		} catch (BLLException e) {
			e.printStackTrace();
		}

//**************************************************************************************		
		// Envoie des informations
		request = Chargement.chargementListCategorie(request);
		request.setAttribute("categorieSaisie", noCategorie);
		request.setAttribute("listeArticlesAAfficher", listeArticlesAAfficher);
		request.setAttribute("saisieUtilisateur", rechercheUtilisateurARenvoyer);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
		rd.forward(request, response);

	}

}
