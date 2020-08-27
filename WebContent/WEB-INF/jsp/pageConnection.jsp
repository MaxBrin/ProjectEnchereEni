<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Connexion</title>

<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">



<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">


</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">


		<div class="row mx-auto">
			<div class="mx-auto offset-sm-3" >
				<h1>Connexion</h1>
			</div>
		</div>

		<br>
		<!--  Initialisation Message Erreur  -->
		<c:set var="erreur" value="${listeErreurs}" />
		
		
		<form action="Connexion" method="post">

			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-3">
					<label for="identifiant">Identifiant</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreur.containsKey('IdentifiantInvalide')?'border border-danger':'border border-secondary' }"
							placeholder="Identifiant" aria-label="Identifiant"
							name="identifiant" value="">
					</div>
				</div>
			</div>
			<!--  Afficher message d'erreurs -->
			<div class="row mx-auto">
				<div class="col-sm-6 offset-sm-3">
					<c:if test="${erreur.containsKey('IdentifiantInvalide')}">
						<p class="text-danger">${erreur.get('IdentifiantInvalide')}</p>
					</c:if>
				</div>
			</div>



			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-3">
					<label for="motDePasse">Mot de passe</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password"
							class="form-control ${erreur.containsKey('motDePasseInvalide')?'border border-danger':'border border-secondary' }"
							placeholder="Mot De Passe" aria-label="motDePasse"
							name="motDePasse" value="">
					</div>
				</div>
			</div>
			<!--  Afficher message d'erreurs -->
			<div class="row mx-auto">
				<div class="col-sm-6 offset-sm-3">
					<c:if test="${erreur.containsKey('motDePasseInvalide')}">
						<p class="text-danger">${erreur.get('motDePasseInvalide')}</p>
					</c:if>
				</div>
			</div>

			<br>

			
			<div class="row">
				<div class="col-md-3 offset-sm-5">
					<button type="submit" class="btn btn-primary btn-lg">Connexion</button>
					<br>
					<c:if test="${erreurAuthentification!=null }">${erreurAuthentification }</c:if>
				</div>
			</div>
		</form>
	</div>

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