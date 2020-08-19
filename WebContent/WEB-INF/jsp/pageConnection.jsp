<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
		
	</head>
	
	<body>
	
		<form action="Connexion" method="post">
			
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