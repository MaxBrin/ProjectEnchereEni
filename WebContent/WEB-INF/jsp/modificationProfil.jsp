<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleModificationProfil.css">
	<!-- Fonts -->
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap" rel="stylesheet">	
	
	
	
	<title>Mon profil</title>

</head>

<body>
		<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>
	<h1>Mon profil</h1>

	<form action="${pageContext.request.contextPath}/ModificationProfil"
		method="post">

		<div class="colonnes">
			<div class="labelsA">
				<label for="pseudo">Pseudo</label><br>
				<label for="prenom">Prénom</label><br>
				<label for="telephone">Téléphone</label><br>
				<label for="codePostal">Code postal</label><br>
				<label for="ancienMotDePasse">Mot de passe actuel</label><br>
				<label for="nouveauMotDePasse">Nouveau mot de passe </label><br>
			</div>
				
			<div class="colonneA">
				<input type="text" name="pseudo" value="${utilisateur.pseudo}" id="pseudo"><br> 
				<input type="text" name="prenom" value="${utilisateur.prenom}" id="prenom"><br> 
				<input type="text" name="telephone" value="${utilisateur.telephone}" id="telephone"><br>
				<input type="text" name="codePostal" value="${utilisateur.codePostal}" id="codePostal"><br>
				<input type="password" name="ancienMotDePasse" id="ancienMotDePasse"><br>
				<input type="password" name="nouveauMotDePasse" id="nouveauMotDePasse"><br>
			</div>

			<div class="labelsB">
				<label for="nom">Nom</label><br>
				<label for="email">Email</label><br>
				<label for="rue">Rue</label><br>
				<label for="ville">Ville</label><br>
				<label for="confirmerNouveauMotDePasse">Confirmation</label><br>
			</div>
			<div class="colonneB">
				<input type="text" name="nom" value="${utilisateur.nom}" id="nom"><br>
				<input type="text" name="email" value="${utilisateur.email}" id="email"><br>
				<input type="text" name="rue" value="${utilisateur.rue}" id="rue"> <br>
				<input type="text" name="ville" value="${utilisateur.ville}" id="ville"> <br>
				<input type="password" name="confirmerNouveauMotDePasse" id="confirmerNouveauMotDePasse"><br>
			</div>
		</div>

		
		<p>
			<label for="credit">Crédit </label>${utilisateur.credit}
		</p>

		<c:if test="${message != null}">
			<p>${message}</p>
		</c:if>
		<button type="submit">Enregistrer</button>
	</form>


	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#Suppression">Supprimer le compte</button>

	<!-- Modal -->

	<div class="modal fade" id="Suppression" tabindex="-1" aria-labelledby="SuppresionLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="SuppresionLabel">Suppression Compte</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Veuillez rentrer votre mot de passe pour confirmer la
						suppression de compte :</p>
					<form methode="get"
						action="${pageContext.request.contextPath }/SupprimerCompte" id="formSuppression">
						<input type="password">
						<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Annuler</button>
					<button type="Submit" class="btn btn-primary">Supprimer</button>
					</form>
				</div>
				
			</div>
		</div>
	</div>






</body>
</html>