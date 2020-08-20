<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styleNouvelleVente.css">
	
		<meta charset="utf-8">
	
		<title>Nouvelle vente</title>
		
	</head>
	
	
	<body>
		<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>
	
	
	
	
		
		<div id="image">
		</div>
		
	<div>
		<h1>Nouvelle Vente</h1>
	</div>	
		
	<div class="article">
		
		<form method="post" action="NouvelleVente">
		<div>
			<label for="nomArticle">Article : </label>
			<input type="text" name="nomArticle" id="nomArticle">
		</div>
		<br>
		<div>
			<label for="description" class="labeldescription">Description :</label>
			<textarea rows="5" cols="15" id="description" name="description" class="inputdescription"></textarea>
		</div>	
		<br><br><br><br><br>
		<div>
			<label for="categorie">Catégorie</label>
			<select id="categorie" name="categorie">
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtements</option>
				<option value="4">Sport & Loisirs</option>
			</select>
		</div>
		<br>
		<div>	
			<p>Photo de l'article : </p> <a href=""></a>
			
		<div>
			<label for="miseAPrix">Mise à prix </label>
			<input type="number" class="inputMiseAPrix" name="miseAPrix" step="1" min="0" >
		</div>
		<br>
		<div>
			<label for="debutEnchere">Début de l'enchère </label>
			<input type="date"  name="debutEnchere" id="debutEnchere">
		</div>
		<br>
		<div>
			<label for="finEnchere">Fin de l'enchère</label>
			<input type="date" name="finEnchere" id="finEnchere">
		</div>	
		<br>
		<div class="Retrait">
			<fieldset>
			
			
				<legend>Retrait</legend>
			
			<br>
			<div>	
				<label for="rue">Rue :</label>
				<input type="text" id="rue" name="rue" value="${utilisateur.rue}">
			</div>
			<br>
			<div>	
				<label for="codePostal">Code postal :</label>
				<input type="text" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
			</div>
			<br>
			<div>	
				<label for="ville">Ville :</label>
				<input type="text" id="ville" name="ville" value="${utilisateur.ville}">
			</div>
			</fieldset>
		</div>
		<br>
		<div>
			<button type="submit">Enregister</button>
		
			<a href="">Annuler</a>
		</div>
			
		</form>
	</div>	
		
		
		
	</body>
</html>