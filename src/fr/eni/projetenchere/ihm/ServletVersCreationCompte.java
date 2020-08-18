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
	private static List<Utilisateur> listUtilisateur;

	@Override
	public void init() throws ServletException {
		try {
			listUtilisateur = UtilisateurMgr.getListUtilisateur();
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur("", "", "", "", "", "", "", "", "", 0, false);
		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
				motDePasse, 100, false);
		if (!(motDePasse.equals(confirmationMdp))) {
			utilisateur.setMotDePasse(null);
		}

		if (verifUtilisateur(utilisateur, request, response)) {
			try {
				UtilisateurMgr.ajoutUtilisateur(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");

			rd.forward(request, response);
		}

	}

	protected boolean verifUtilisateur(Utilisateur utilisateur, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean utilisateurValid = true;
		StringBuilder sb = new StringBuilder();
		List<String> listErreur = new ArrayList<>();
		if (!(StringUtils.isNumeric(utilisateur.getCodePostal())) || (!(utilisateur.getCodePostal().length() == 5))) {
			utilisateurValid = false;
			sb.append("Le code Postal n'est pas valide");
			listErreur.add("CodePostal");
		}
		EmailValidator validator = EmailValidator.getInstance();
		if (!(validator.isValid(utilisateur.getEmail()))) {
			utilisateurValid = false;
			sb.append("L'email n'est pas valide");
			listErreur.add("Email");
		}
		for (Utilisateur utilisateurBD : listUtilisateur) {
			if (utilisateurBD.getPseudo().equals(utilisateur.getPseudo())) {
				utilisateurValid = false;
				sb.append("Le pseudo est déjà utilisé");
				listErreur.add("Pseudo");
			}
			if (utilisateurBD.getEmail().equals(utilisateur.getEmail())) {
				utilisateurValid = false;
				sb.append("L'email est déjà utilisé");
				listErreur.add("Email");
			}
		}
		if (!(StringUtils.isNumeric(utilisateur.getTelephone())) || (!(utilisateur.getTelephone().length() == 10))) {
			utilisateurValid = false;
			sb.append("Le numero de telephone n'est pas valide");
			listErreur.add("Telephone");

		}
		if (utilisateur.getMotDePasse() == null) {
			utilisateurValid = false;
			sb.append("Les deux mots de passe ne sont pas identiques.");
			listErreur.add("MotDePasse");
		}
		if (!(utilisateurValid)) {
			request.setAttribute("messageErreur", sb.toString());
			request.setAttribute("listErreur", listErreur);
			request.setAttribute("utilisateur", utilisateur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationProfil.jsp");
			rd.forward(request, response);
		}

		return utilisateurValid;
	}

}
