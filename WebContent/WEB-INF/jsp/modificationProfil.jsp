<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Mon profil</title>

</head>

<body>
	<jsp:include page="/WEB-INF/jsp/enTete.jsp"></jsp:include>
	<h1>Mon profil</h1>

	<form action="${pageContext.request.contextPath}/ModificationProfil"
		method="post">

		<div class="colonnes">
			<div class="colonneA">
				<label for="pseudo">Pseudo</label> <input type="text" name="pseudo"
					value="${utilisateur.pseudo}" id="pseudo"> <label for="nom">Nom</label>
				<input type="text" name="nom" value="${utilisateur.nom}" id="nom">

				<label for="prenom">Prénom</label> <input type="text" name="prenom"
					value="${utilisateur.prenom}" id="prenom"> <label
					for="email">Email</label> <input type="text" name="email"
					value="${utilisateur.email}" id="email"> <label
					for="telephone">Téléphone</label> <input type="text"
					name="telephone" value="${utilisateur.telephone}" id="telephone">
			</div>

			<div class="colonneB">
				<label for="rue">Rue</label> <input type="text" name="rue"
					value="${utilisateur.rue}" id="rue"> <label
					for="codePostal">Code postal</label> <input type="text"
					name="codePostal" value="${utilisateur.codePostal}" id="codePostal">

				<label for="ville">Ville</label> <input type="text" name="ville"
					value="${utilisateur.ville}" id="ville"> <label
					for="ancienMotDePasse">Mot de passe actuel</label> <input
					type="password" name="ancienMotDePasse" id="ancienMotDePasse">

				<label for="nouveauMotDePasse">Nouveau mot de passe </label> <input
					type="password" name="nouveauMotDePasse" id="nouveauMotDePasse">

				<label for="confirmerNouveauMotDePasse">Confirmation</label> <input
					type="password" name="confirmerNouveauMotDePasse"
					id="confirmerNouveauMotDePasse">


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