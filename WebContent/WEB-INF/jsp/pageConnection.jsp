<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		
	</head>
	
	<body>
	
		<form action="ValidationConnection" method="post">
			
			<label for="identifiant">Identifiant</label>
			<input type="text" name="identifiant" id="identifiant">
			
			<label for="motDePasse">Mot de passe</label>
			<input type="password" name="motDePasse" id="motDePasse">
			
			<button type="submit">Connexion</button>
			
			<p>Se souvenir de moi</p>
			<input type="checkbox" name="seSouvenir">
			
			<a href="">Mot de passe oublié</a>
			
		
		</form>
	
	
	</body>
</html>