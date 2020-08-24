<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		
	


		
		<title>Connexion</title>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	
		
	</head>
	
	<body>
		<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>
		
		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
				<h1>LISTE DES ENCHERES</h1>
			</div>
		</div>
		
		
		 <form action="Connexion" method="post">
		<div class="col-md-4"></div>
		
			
			<label for="identifiant">Identifiant</label>
			<input type="text" name="identifiant" id="identifiant">
			
			<label for="motDePasse">Mot de passe</label>
			<input type="password" name="motDePasse" id="motDePasse">
			
			<button type="submit" class="btn btn-secondary btn-lg">Connexion</button>
			<c:if test="${erreurAuthentification!=null }">${erreurAuthentification }</c:if>
			<p>Se souvenir de moi</p>
			<input type="checkbox" name="seSouvenir">
			
			<a href="">Mot de passe oublié</a>
			
		
				
		</form>
	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
	</body>
</html>