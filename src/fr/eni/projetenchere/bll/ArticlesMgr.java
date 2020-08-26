package fr.eni.projetenchere.bll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.dal.ArticleDAO;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.ihm.modele.Filtre;

public class ArticlesMgr {
	// Chargement implémentation article DAO
	private static ArticleDAO articleDAO;

	static {
		articleDAO = DAOFactory.getArticleDAO();
	}

	/**
	 * Méthode pour ajouter un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public static void ajoutArticle(Article article) throws BLLException {
		try {
			articleDAO.insertArticle(article);

		} catch (DALException e) {
			throw new BLLException("Erreur ajoutArticle", e);
		}
	}

	/**
	 * Méthode pour modifier un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	public static void modifierArticle(Article article) throws BLLException {
		try {
			articleDAO.updateArticle(article);
		} catch (DALException e) {
			throw new BLLException("Erreur modifierArticle", e);
		}
	}

	/**
	 * Méthode pour effacer un article
	 * 
	 * @param noArticle
	 * @throws BLLException
	 */
	public static void effacerArticle(int noArticle) throws BLLException {
		try {
			articleDAO.deleteArticle(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur effacerArticle", e);
		}
	}

	/**
	 * Méthode pour récupérer la liste de tout les articles de liste selon le filtre
	 * 
	 * @return
	 * @throws BLLException
	 */
	public static List<Article> getListArticleFiltre(Filtre filtre) throws BLLException {
		List<Article> listArticles = new ArrayList<>();
		try {
			listArticles = articleDAO.selectAllArticle(filtre);
		} catch (DALException e) {
			throw new BLLException("Erreur getListArticles", e);
		}
		return listArticles;
	}

	/**
	 * Méthode pour récupérer un article gràce à son noArticle
	 * 
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */
	public static Article getArticle(int noArticle) throws BLLException {
		Article article = null;
		try {
			article = articleDAO.selectById(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur getArticle", e);
		}
		return article;
	}

	// Méthode pour vérifier si les saisie de l'utilisateur permettent de créer une
	// nouvelle vente

	public static HashMap<String, String> verifierVenteArticle(Article article, String rue, String codePostal,
			String ville) {
		HashMap<String, String> erreurs = new HashMap<String, String>();
		if (article.getNomArticle().trim().equals("") || article.getNomArticle() == null) {
			erreurs.put("nomArticle", "Nom de l'article invalide. ");
		}
		if (article.getPrixInitial() == 0) {
			erreurs.put("prixInitial", "Le prix initial de vente ne peut pas être égal à zero. ");
		}
		if (article.getFinEnchere().isBefore(article.getDebutEnchere().plusDays(1).minusSeconds(1))) {
			erreurs.put("datesEncheres",
					"Dates d'enchères invalides. Il faut 1 jour entre le debut de l'enchère et la fin de l'enchère");
		}
		if (rue.trim().equals("")) {
			erreurs.put("rue", "Adresse invalide");
		}
		if (codePostal.trim().equals("") || !(StringUtils.isNumeric(codePostal))) {
			erreurs.put("codePostal", "Adresse invalide");
		}
		if (ville.trim().equals("")) {
			erreurs.put("ville", "Adresse invalide");
		}
		return erreurs;
	}

}
