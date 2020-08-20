<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		
	


		
		<title>Insert title here</title>
<<<<<<< HEAD
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageConnexion.css">
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	</head>
	
	<body>
		<div class="body">
			<form action="Connexion" method="post">
				<label for="identifiant">Identifiant</label>
				<input type="text" name="identifiant" id="identifiant">
				
				<label for="motDePasse">Mot de passe</label>
				<input type="password" name="motDePasse" id="motDePasse">
				
				<button type="submit">Connexion</button>
				<c:if test="${erreurAuthentification!=null }">${erreurAuthentification }</c:if>
				<p>Se souvenir de moi</p>
				<input type="checkbox" name="seSouvenir">
				
				<a href="">Mot de passe oublié</a>
			</form>
		</div>
=======
		
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
			<c:if test="${erreurAuthentification!=null }">${erreurAuthentification }</c:if>
			<p>Se souvenir de moi</p>
			<input type="checkbox" name="seSouvenir">
			
			<a href="">Mot de passe oublié</a>
			
		
		</form>
>>>>>>> 0ea194064035a7ac43c84787124cddce37976baa
	
	
	</body>
</html>