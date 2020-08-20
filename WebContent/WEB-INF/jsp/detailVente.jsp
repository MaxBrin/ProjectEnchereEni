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
		<p>Nom article :</p>
	</div>
	
	<div>
		<p>Description :</p>
	</div>
	
	<div>
		<p>Catégorie :</p>
	</div>
	
	<div>
		<p>Meilleure offre :</p>
	</div>
	
	<div>
		<p>Mise à prix :</p>
	</div>
	
	<div>
		<p>Fin de l'enchère :</p>
	</div>
	
	<div>
		<p>Retrait :</p>
	</div>
	
	<div>
		<p>Vendeur :</p>
	</div>
		
	<div>
		<label for="proposition">Ma proposition :</label>
		<input type="number" id="proposition" name="proposition" min="0" max="500" step="5">
		<button type="submit">Enchérir</button>
	</div>

</body>
</html>