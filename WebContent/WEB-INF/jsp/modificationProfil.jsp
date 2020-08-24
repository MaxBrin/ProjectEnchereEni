<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">
<!-- Bootstrap CSS -->
<<<<<<< HEAD
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
=======
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">
>>>>>>> e4f5c7298b440fef6b5ede0814af9c18217e70b9


<title>Mon profil</title>

</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">


		<form action="${pageContext.request.contextPath}/ModificationProfil"
			method="post">
			<div class="row mx-auto">
				<div class="mx-auto" style="width: 200px;">
					<h1>Mon Profil</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="pseudo">Pseudo</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Pseudo"
							aria-label="Pseudo" name="pseudo" value="${utilisateur.pseudo}" required="required">
					</div>
				</div>
				<div class="col-md-2">
					<label for="nom">Nom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Nom"
							aria-label="Nom" name="nom" value="${utilisateur.nom}" id="nom" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="prenom">Prénom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Prénom"
							aria-label="prenom" name="prenom" value="${utilisateur.prenom}" required="required">
					</div>
				</div>
				<div class="col-md-2">
					<label for="email">Email</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Email"
							aria-label="email" name="email" value="${utilisateur.email}" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="telephone">Téléphone</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Téléphone"
							aria-label="telephone" name="telephone" value="${utilisateur.telephone}" required="required">
					</div>
				</div>
				<div class="col-md-2">
					<label for="rue">Rue</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Rue"
							aria-label="rue" name="rue" value="${utilisateur.rue}" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="codePostal">Code postal</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Code postal"
							aria-label="codePostal" name="codePostal" value="${utilisateur.codePostal}" required="required">
					</div>
				</div>
				<div class="col-md-2">
					<label for="ville">Ville</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="Ville"
							aria-label="ville" name="ville" value="${utilisateur.ville}" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="ancienMotDePasse">Mot de passe actuel</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password" class="form-control" 
							aria-label="ancienMotDePasse" name="ancienMotDePasse" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-2">
					<label for="nouveauMotDePasse">Nouveau mot de passe</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password" class="form-control" 
							aria-label="nouveauMotDePasse" name="nouveauMotDePasse">
					</div>
				</div>
				<div class="col-md-2">
					<label for="confirmerNouveauMotDePasse">Confirmation Mot de Passe</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password" class="form-control" 
							aria-label="confirmerNouveauMotDePasse" name="confirmerNouveauMotDePasse">
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-2">
					<label for="credit">Crédit : </label><c:out value=" ${utilisateur.credit}"/>
				</div>
			</div>

			<button type="button" class="btn btn-primary" type="submit">Enregistrer</button>
			<!-- Button trigger modal -->
			<button type="button" class="btn btn-secondary" data-toggle="modal"
				data-target="#Suppression">Supprimer le compte</button>

		</form>

		<!-- Modal -->

		<div class="modal fade" id="Suppression" tabindex="-1"
			aria-labelledby="SuppresionLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="SuppresionLabel">Suppression
							Compte</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>Veuillez rentrer votre mot de passe pour confirmer la
							suppression de compte :</p>
						<form methode="get"
							action="${pageContext.request.contextPath }/SupprimerCompte"
							id="formSuppression">
							<input type="password">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Annuler</button>
							<button type="Submit" class="btn btn-danger"">Supprimer</button>
						</form>
					</div>

				</div>
			</div>
		</div>
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
		src="${pageContext.request.contextPath }/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>

</body>
</html>