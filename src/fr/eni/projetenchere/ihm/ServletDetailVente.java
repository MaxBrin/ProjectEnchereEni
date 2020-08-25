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
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Article;
import fr.eni.projetenchere.bo.Enchere;
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

		// R�cup�ration de l'utilisateur dans la session

		HttpSession session = request.getSession();
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		Utilisateur utilisateur = new Utilisateur();
		if (!(noUtilisateur == null)) {
			try {
				utilisateur = UtilisateurMgr.getUtilisateur(noUtilisateur);
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
		}

		// Recuperation du paramètre idArticle
		String noArticle = request.getParameter("idArticle");
		int noIdArticle = Integer.parseInt(noArticle);
		Article article = new Article();

		// R�cuperation de l'article a partir de son id
		try {
			article = ArticlesMgr.getArticle(noIdArticle);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		// Envoie du paramètre article et de l'utilisateur
		request.setAttribute("article", article);
		request.setAttribute("utilisateur", utilisateur);
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
		Integer noUtilisateur = (Integer) session.getAttribute("noUtilisateur");
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));

		Utilisateur acheteur = null;
		Article articleEnVente = null;
		try {
			acheteur = UtilisateurMgr.getUtilisateur(noUtilisateur);
			articleEnVente = ArticlesMgr.getArticle(noArticle);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
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
