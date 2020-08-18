package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class ServletVersCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMdp = request.getParameter("confirmerMotDePasse");
		
		String mdpNonValide = "";
		Utilisateur utlisateur;
		
		if(motDePasse.equals(confirmationMdp)) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100, false);
			try {
				UtilisateurMgr.ajoutUtilisateur(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
			rd.forward(request, response);
		} else {
			mdpNonValide = "Les deux mots de passe saisis ne sont pas identiques";
			request.setAttribute("messageErreur", mdpNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}
		
		
		
		
		
		
	}

}
