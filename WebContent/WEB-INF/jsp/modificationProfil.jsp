<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/stylePageProfil.css">
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">



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





</body>
</html>