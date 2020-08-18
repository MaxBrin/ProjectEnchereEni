package fr.eni.projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class CreationCompte
 */
@WebServlet("/CreationCompte")
public class ServletVersCreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean utilisateurValid = true;
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		EmailValidator validator = EmailValidator.getInstance();
		if (!(validator.isValid(email))) {
			utilisateurValid = false;
			String emailNonValide = "L'email n'est pas valide";
			request.setAttribute("messageErreur", emailNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}
		String telephone = request.getParameter("telephone");
		if (!(StringUtils.isNumeric(telephone)) || telephone.length() > 10 || telephone.length() < 10) {
			utilisateurValid = false;
			String telephoneNonValide = "Le numero de telephone n'est pas valide";
			request.setAttribute("messageErreur", telephoneNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		if (!(StringUtils.isNumeric(codePostal)) || (!(codePostal.length() == 5))) {
			utilisateurValid = false;
			String codePostalNonValide = "Le code Postal n'est pas valide";
			request.setAttribute("messageErreur", codePostalNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmationMdp = request.getParameter("confirmerMotDePasse");

		if (!(motDePasse.equals(confirmationMdp))) {
			utilisateurValid = false;
			String mdpNonValide = "Les deux mots de passe saisis ne sont pas identiques";
			request.setAttribute("messageErreur", mdpNonValide);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}

		if (utilisateurValid) {
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, 100, false);

			try {
				UtilisateurMgr.ajoutUtilisateur(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");

			rd.forward(request, response);
		}

	}

}
