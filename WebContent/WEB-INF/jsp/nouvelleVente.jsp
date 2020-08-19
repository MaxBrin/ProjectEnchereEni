<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nouvelle vente</title>
	</head>
	
	
	<body>
		
		<div id="image">
		</div>
		
		
		<h1>Nouvelle Vente</h1>
		
		<form method="post" action="">
			<label for="nomArticle">Article</label>
			<input type="text" name="nomArticle" id="nomArticle">
			
			<label for="description">Description</label>
			<textarea rows="5" cols="15" id="description" name="description"></textarea>
			
			<label for="categorie">Catégorie</label>
			<select id="categorie" name="categorie">
				<option>Informatique</option>
				<option>Ameublement</option>
				<option>Vêtements</option>
				<option>Sport & Loisirs</option>
			</select>
			
			<p>Photo de l'article : </p> <a href=""></a>
			
			<label for="miseAPrix">Mise à prix</label>
			<input type="number" name="miseAPrix" step="1" min="0">
			
			<label for="debutEnchere">Début de l'enchère</label>
			<input type="date" name="debutEnchere" id="debutEnchere">
			
			<label for="finEnchere">Début de l'enchère</label>
			<input type="date" name="finEnchere" id="finEnchere">
			
			<fieldset>
				<legend>Retrait</legend>
				
				<label for="rue">Rue</label>
				<input type="text" id="rue" name="rue" value="${utilisateur.rue}">
				
				<label for="codePostal">Code postal</label>
				<input type="text" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
				
				<label for="ville">Ville</label>
				<input type="text" id="ville" name="ville" value="${utilisateur.ville}">
			
			</fieldset>
			
			<button type="submit">Enregister</button>
			<a href="">Annuler</a>
			
		</form>
		
		
		
		
	</body>
</html>