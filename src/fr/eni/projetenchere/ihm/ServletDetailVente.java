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
		Article article = new Article();
		Retrait retrait = new Retrait();

		// Récuperation de l'article a partir de son id
		try {
			article = ArticlesMgr.getArticle(noIdArticle);
			retrait = RetraitMgr.getRetraitByNoArticle(article.getNoArticle());
		} catch (BLLException e) {
			e.printStackTrace();
		}
		// Envoie du paramètre article et de l'utilisateur
		request.setAttribute("retrait", retrait);
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", article.getUtilisateur());
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
		try {
			acheteur = UtilisateurMgr.getUtilisateur(noUtilisateur);
			articleEnVente = ArticlesMgr.getArticle(noArticle);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		int proposition = Integer.parseInt(request.getParameter("proposition"));
		Enchere encherePropose = new Enchere(LocalDateTime.now(), proposition, noArticle, noUtilisateur);
		if (EnchereMgr.verifEnchere(articleEnVente, acheteur, encherePropose)) {

		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}

}
