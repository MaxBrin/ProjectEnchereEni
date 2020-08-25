<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!--  CSS  -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/Fragment/enTete.css">
	
<!-- Bootstrap CSS -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">

<title>En-tête Bootstrap</title>

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath }/Accueil">ENI-Enchères</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${noUtilisateur != null }">
						<li class="nav-item "><a class="nav-link" href="">Enchères
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ProjectEnchereEni/NouvelleVente">Vendre un article</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ProjectEnchereEni/ModificationProfil?utilisateurTitulaire=${noUtilisateur}">Mon profil</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ProjectEnchereEni/Deconnexion">Déconnexion</a></li>
					</c:when>
					<c:otherwise>
						<li class="nav-item "><a class="nav-link"
							href="/ProjectEnchereEni/CreationCompte" class="">S'inscrire</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/ProjectEnchereEni/Connexion">Se connecter</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>


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
		src="${pageContext.request.contextPath }/bootstrap/4.5.2/js/bootstrap.js"
		></script>
</body>
</html>