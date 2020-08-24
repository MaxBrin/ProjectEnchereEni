package fr.eni.projetenchere.bll;

import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Utilisateur;
import fr.eni.projetenchere.dal.DALException;
import fr.eni.projetenchere.dal.DAOFactory;
import fr.eni.projetenchere.dal.EnchereDAO;

public class EnchereMgr {
	// Chargement implémentation categorie DAO
	private static EnchereDAO enchereDAO;
	static {
		enchereDAO = DAOFactory.getEnchereDAO();
	}

	/**
	 * Méthode pour ajouter une enchère
	 * 
	 * @param enchere
	 * @throws BLLException
	 */
	public void ajouterEnchere(Enchere enchere) throws BLLException {
		try {
			enchereDAO.insertEnchere(enchere);
		} catch (DALException e) {
			throw new BLLException("Erreur ajouterEnchere", e);
		}
	}

	/**
	 * Méthode pour récuperer la derniere enchere d'un article
	 * 
	 * @param noArticle
	 * @return
	 * @throws BLLException
	 */
	public Enchere getEnchereByArticle(int noArticle) throws BLLException {
		Enchere enchere = new Enchere();
		try {
			enchere = enchereDAO.selectBy_NoArticle(noArticle);
		} catch (DALException e) {
			throw new BLLException("Erreur getEnchereByArticle", e);
		}
		return enchere;
	}

	/**
	 * Méthode pour vérifier si une enchère est possible , il faut que le montant
	 * soit supérieur au prix initial de l'article , que l'utilisateur a encore
	 * assez de crédit pour faire l'enchère et que l'enchère soit supérieur à la
	 * dernière enchère
	 * 
	 * @param article
	 * @param utilisateur
	 * @param enchere
	 * @return
	 */
	public static boolean verifEnchere(Article article, Utilisateur utilisateur, Enchere enchere) {
		boolean valide = true;
		if (article.getPrixInitial() > enchere.getMontantEnchere()) {
			valide = false;
		}
		if (utilisateur.getCredit() < enchere.getMontantEnchere()) {
			valide = false;
		}
		Enchere derniereEnchere = null;
		try {
			derniereEnchere = enchereDAO.selectBy_NoArticle(article.getNoArticle());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (derniereEnchere != null && derniereEnchere.getMontantEnchere() < enchere.getMontantEnchere()) {
			valide = false;
		}
		return valide;
	}

}
