<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		<p>Nom article : ${article.nom}</p>
	</div>
	
	<div>
		<p>Description : ${article.description}</p>
	</div>
	
	<div>
		<p>Catégorie : ${article.categorie}</p>
	</div>
	
	<div>
		<%//TODO: meilleur offre %>
		<p>Meilleure offre : </p>
	</div>
	
	<div>
		<p>Mise à prix : ${article.prixInitial}</p>
	</div>
	
	<div>
		<p>Fin de l'enchère : ${article.finEnchere}</p>
	</div>
	
	<div>
		<p>Retrait : ${utilisateur.rue}, ${utilisateur.codePostal}, ${utilisateur.ville}</p>
	</div>
	
	<div>
		<%//TODO: vendeur%>
		<p>Vendeur : ${utilisateur.pseudo}</p>
	</div>
		
	<div>
		<label for="proposition">Ma proposition :</label>
		<input type="number" id="proposition" name="proposition" min="0" max="500" step="5">
		<button type="submit">Enchérir</button>
	</div>

</body>
</html>