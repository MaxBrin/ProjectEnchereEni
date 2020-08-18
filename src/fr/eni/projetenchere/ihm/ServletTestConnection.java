package fr.eni.projetenchere.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetenchere.bll.BLLException;
import fr.eni.projetenchere.bll.UtilisateurMgr;
import fr.eni.projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletTestConnection
 */
@WebServlet("/ServletTestConnection")
public class ServletTestConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ServletTestConnection() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateurTampon1 = new Utilisateur("Neo", "Brin", "Maxime", "max@max.max", "0123456789",
				"10 rue franklin", "44000", "Nantes", "Pa$$w0rd", 100, true);
		Utilisateur utilisateurTampon2 = new Utilisateur("Bob", "Dupond", "Robert", "bob@bob.bob", "9876543210",
				"5 rue franklin", "44000", "Nantes", "Pa$$w0rd", 200, false);
		try {
			UtilisateurMgr.ajoutUtilisateur(utilisateurTampon1);
			UtilisateurMgr.ajoutUtilisateur(utilisateurTampon2);
			System.out.println(UtilisateurMgr.getListUtilisateur());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(utilisateurTampon1.getNoUtilisateur());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
