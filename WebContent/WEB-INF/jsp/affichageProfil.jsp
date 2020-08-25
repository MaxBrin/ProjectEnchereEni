<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Affichage profil</title>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/stylePageAccueil.css">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>

	<!-- L'utlisateur consulte le profil d'un autre vendeur -->
			<!-- Titre  -->
			<div class="row mx-auto">
				<div class="mx-auto" style="width: 600px; margin-bottom: 50px; margin-top: 50px; margin-left: 300px;">
					<h1 style="width: 600px;">Profil de ${utilisateurAAfficher.pseudo}</h1>
				</div>
			</div>
			<!-- PSEUDO -->
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Pseudo</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurAAfficher.pseudo}" readonly="readonly">
					</div>
				</div>
			</div>
			<!-- PRENOM -->
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Prénom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurAAfficher.prenom}" readonly="readonly">
					</div>
				</div>
			</div>
			<!-- CODE POSTAL -->
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Code Postal</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurAAfficher.codePostal}" readonly="readonly">
					</div>
				</div>
			</div>
			<!-- VILLE -->
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Ville</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurAAfficher.ville}" readonly="readonly">
					</div>
				</div>
			</div>
	<!-- Si l'utilisateur consulte son propre profil un bouton "modifier" s'affiche -->
	<c:if test="${utilisateurAAfficher.noUtilisateur == noUtilisateur}">
	<div class="row mx-auto">
			<a href="${pageContext.request.contextPath }/ModificationProfil"
			class="btn btn-secondary btn-sm" style="width: 100px;">Modifier</a><br>
	</div>	
	</c:if>
	
</body>
</html>