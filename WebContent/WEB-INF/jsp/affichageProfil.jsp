<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Affichage profil</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>

	<!-- L'utlisateur consulte le profil d'un autre vendeur -->
	<c:if test="${utilisateurVendeur != null}">
			<div class="row mx-auto">
				<div class="mx-auto" style="width: 250px; margin-bottom: 50px; margin-top: 50px">
					<h1>Profil de ${utilisateurVendeur.pseudo}</h1>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Pseudo</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurVendeur.pseudo}" readonly="readonly">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Prénom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurVendeur.prenom}" readonly="readonly">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Code Postal</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurVendeur.codePostal}" readonly="readonly">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Ville</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateurVendeur.ville}" readonly="readonly">
					</div>
				</div>
			</div>
	</c:if>
	
	<c:if test="${utilisateurVendeur != null}">
		<a href="${pageContext.request.contextPath }/ModificationProfil">Modifier</a>
	</c:if>
	
</body>
</html>