package fr.eni.projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletNouvelleVente
 */
@WebServlet("/NouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvelleVente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nom = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		String miseAPrix = request.getParameter("miseAPrix");
		try {
			LocalDateTime debutEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("debutEnchere")),
					LocalTime.now());
			LocalDateTime finEnchere = LocalDateTime.of(LocalDate.parse(request.getParameter("finEnchere")),
					LocalTime.now());
		} catch (DateTimeParseException e) {
			// TODO MESSAGE ERREUR DATE
		}
		// TODO VERIF DONNEES

	}

}
