package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetenchere.bll.ArticlesMgr;
import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.EnchereMgr;
import fr.eni.projetenchere.bll.RetraitMgr;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Enchere;
import fr.eni.projetenchere.bo.Retrait;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/DetailVente")
public class ServletDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recuperation du paramètre idArticle
		String noArticle = request.getParameter("idArticle");
		int noIdArticle = Integer.parseInt(noArticle);

		// initialisation de variable
		Article article = new Article();
		Retrait retrait = new Retrait();
		Enchere meilleurEnchere = new Enchere();

		// Récuperation de l'article a partir de son id
		try {
			article = ArticlesMgr.getArticle(noIdArticle);
			retrait = RetraitMgr.getRetraitByNoArticle(noIdArticle);
			meilleurEnchere = EnchereMgr.getEnchereByArticle_BestOffer(noIdArticle);

		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}

		// Envoi du paramètre article et de l'utilisateur
		request.setAttribute("meilleurEnchere", meilleurEnchere);
		request.setAttribute("retrait", retrait);
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", article.getUtilisateur());
		Utilisateur utilisateurGagnantEnchere = traitementArticle(article);
		// Si l'enchère n'est pas commencée on peux la modifier
		if (article.getDebutEnchere().isAfter(LocalDateTime.now())) {
			request.setAttribute("modifiable", true);
		}
		request.setAttribute("utilisateurGagnant", utilisateurGagnantEnchere);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));

		Utilisateur acheteur = null;
		Article articleEnVente = null;
		Retrait retraitArticleEnVente = null;
		Enchere meilleurEnchere = null;
		try {
			acheteur = UtilisateurMgr.getUtilisateur(noUtilisateur);
			articleEnVente = ArticlesMgr.getArticle(noArticle);
			retraitArticleEnVente = RetraitMgr.getRetraitByNoArticle(noArticle);

		} catch (BLLException e) {
			request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
			e.printStackTrace();
		}
		traitementArticle(articleEnVente);

		int proposition = Integer.parseInt(request.getParameter("proposition"));
		Enchere encherePropose = new Enchere(LocalDateTime.now(), proposition, noArticle, noUtilisateur);
		// Verification si l'enchère est possible
		if (EnchereMgr.verifEnchere(articleEnVente, acheteur, encherePropose)) {
			try {
				// Traitement de l'enchère
				meilleurEnchere = traitementEnchere(encherePropose, acheteur, articleEnVente);
				request.setAttribute("meilleurEnchere", meilleurEnchere);
			} catch (Exception e) {
				request.getRequestDispatcher("/WEB-INF/jsp/erreurConnexionServeur.jsp").forward(request, response);
				e.printStackTrace();
			}
		} else {
			String enchereInvalide = "L'enchère est invalide.";
			request.setAttribute("Erreur", enchereInvalide);
		}
		request.setAttribute("meilleurEnchere", encherePropose);
		request.setAttribute("retrait", retraitArticleEnVente);
		request.setAttribute("article", articleEnVente);
		request.setAttribute("utilisateur", articleEnVente.getUtilisateur());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * Méthode qui vérifie si l'enchère est fini et si le montant de de la vente est
	 * égale à 0
	 * 
	 * @param article
	 * @return
	 */
	protected Utilisateur traitementArticle(Article article) {
		// On regarde si la date de fin d'enchère est avant maintenant et donc que
		// l'enchère est fini
		Utilisateur utilisateur = null;
		if (article.getFinEnchere().isBefore(LocalDateTime.now())) {
			try {
				// On récupère la meilleur enchère de cet article
				Enchere enchere = EnchereMgr.getEnchereByArticle_BestOffer(article.getNoArticle());
				// On vérifie qu'il y'a une enchère
				if (enchere == null) {
					// S'il n'y a pas d'enchère le prix de vente = 0
					article.setPrixVente(0);
					// Si personne n'a remporté l'enchère on initialise le numéro d'utilisateur à 0
					utilisateur = new Utilisateur();
					utilisateur.setNoUtilisateur(0);
				} else {
					// Sinon il est égale au montant de la meilleur enchère
					article.setPrixVente(enchere.getMontantEnchere());
					// on récupère l'utilisateur qui a remporté l'enchère
					utilisateur = UtilisateurMgr.getUtilisateur(enchere.getNoUtilisateur());
				}
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		try

		{
			ArticlesMgr.modifierArticle(article);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	protected Enchere traitementEnchere(Enchere encherePropose, Utilisateur acheteur, Article articleEnVente)
			throws Exception {
		Enchere meilleurEnchere = null;
		acheteur.setCredit(acheteur.getCredit() - encherePropose.getMontantEnchere());
		Enchere deuxiemeMeilleurEnchere = new Enchere();
		try {
			// Mise à jour de la bd avec les crédits modifier pour l'acheteur
			UtilisateurMgr.modificationUtilisateur(acheteur);
			// Récupération de la dernière meilleur enchère
			deuxiemeMeilleurEnchere = EnchereMgr.getEnchereByArticle_BestOffer(articleEnVente.getNoArticle());
			// Ajout de l'enchere actuelle dans la BD
			EnchereMgr.ajouterEnchere(encherePropose);
			// La meilleur enchere deviens l'enchere proposer
			meilleurEnchere = encherePropose;
			// Remboursement de l'utilisateur que si il y'a une deuxième meilleur enchère
			if (deuxiemeMeilleurEnchere != null) {
				// Récupération de l'utilisateur en fonction du numéro d'utilisateur dans
				// l'enchère
				Utilisateur utilisateurARembourser = UtilisateurMgr
						.getUtilisateur(deuxiemeMeilleurEnchere.getNoUtilisateur());
				// Modification des crédits de l'utilisateur
				utilisateurARembourser
						.setCredit(utilisateurARembourser.getCredit() + deuxiemeMeilleurEnchere.getMontantEnchere());
				// Mise à jour de la bd avec les crédits modifier
				UtilisateurMgr.modificationUtilisateur(utilisateurARembourser);
			}
		} catch (BLLException e) {
			throw new Exception("Erreur traitementEnchere", e);
		}
		return meilleurEnchere;
	}

}
