package fr.eni.projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;

import fr.eni.projetenchere.bo.Utilisateur;



/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean utilisateurValid = true;
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		EmailValidator validator = EmailValidator.getInstance();
		if(!(validator.isValid(email))) {
			utilisateurValid=false;
			String emailNonValide = "L'email n'est pas valide";
			request.setAttribute("messageErreur", emailNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modificationProfil.jsp");
			rd.forward(request, response);
		}
		
		
		String telephone = request.getParameter("telephone");
		//validateur telephone
		
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String ancienMotDePasse = request.getParameter("ancienMotDePasse");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if(!(utilisateur.getMotDePasse().equals(ancienMotDePasse))) {
			
			
		}
		
		
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationNouveauMDP = request.getParameter("confirmerMotDePasse");
		if(!(nouveauMotDePasse.equals(confirmationNouveauMDP))) {
			utilisateurValid = false;
			String NouveauMDPNonValide = "Les deux mots de passe saisis ne sont pas identiques";
			request.setAttribute("messageErreur", NouveauMDPNonValide);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ModificationProfil.jsp");
		}
		
		
		//verifier si l'ancien mdp saisi ici est le meme que celui en bdd
		//verifier si nouveauMdp et confirmerMdp sont les memes
		
		
		
	}

}
