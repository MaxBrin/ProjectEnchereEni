package fr.eni.projetenchere.ihm;

import javax.servlet.RequestDispatcher;

public class Tampon {
	String erreurConnectionBD = "Nous sommes désolés mais nous rencontrons un problème de serveur actuellement. ";
	request.setAttribute("ErreurBD", erreurConnectionBD);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
	rd.forward(request, response);
}
