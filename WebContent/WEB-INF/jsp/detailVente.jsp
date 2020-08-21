<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Détail vente</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>


	<div>
		<h2>Détail vente</h2>
	</div>
	
		<div>	
		<p>Nom article : ${article.nomArticle}</p>
	</div>
	
	<div>
		<p>Description : ${article.description}</p>
	</div>
	
	<div>
		<p>Catégorie : ${article.categorie.libelle}</p>
	</div>
	
	<div>
		<%//TODO: meilleur offre %>
		<p>Meilleure offre : </p>
	</div>
	
	<div>
		<p>Mise à prix : ${article.prixInitial}</p>
	</div>
	
	<div>
		<p>Fin de l'enchère : <fmt:parseDate value="${article.finEnchere}"
								pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="both" />
							<fmt:formatDate value="${parsedDate }" dateStyle="long"
								timeStyle="medium" type="both" /></p>
	</div>
	
	<div>
		<p>Retrait : <br>
			Rue : ${utilisateur.rue}<br>00
			Code Postal : ${utilisateur.codePostal}<br>
			Ville : ${utilisateur.ville}<br></p>
	</div>
	
	<div>
		
		<p>Vendeur : ${utilisateur.pseudo}</p>
	</div>
		
	<div>
		<label for="proposition">Ma proposition :</label>
		<input type="number" id="proposition" name="proposition" min="0" max="500" step="5" >
		<button type="submit">Enchérir</button>
	</div>

</body>
</html>