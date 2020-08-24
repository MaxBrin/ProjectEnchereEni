<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/Erreur.css">
<title>Mon profil</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>



<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">
		<div class="row mx-auto">
			<div class="mx-auto" style="width: 200px;">
				<h1>Mon Profil</h1>
			</div>
		</div>
		<br> <br>

		<form action="${pageContext.request.contextPath }/CreationCompte"
			method="post">

			<!--  Initialisation Message Erreur  -->
			<c:set var="erreurs" value="${listErreur}" />


			<!--   Modification de l'id de l'input s'il y'a un message d'erreur qui permet de mettre des bordure en rouge -->


			<div class="row">
				<!--  PSEUDO  -->
				<div class="col-md-2">
					<label for="pseudo">Pseudo</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('pseudoNonValide')||erreurs.containsKey('pseudoPresent')?'border border-danger':'border border-secondary' }"
							placeholder="Pseudo" aria-label="Pseudo" name="pseudo"
							value="${utilisateur.pseudo}" required="required">
					</div>
				</div>
				<!--  EMAIL  -->
				<div class="col-md-2">
					<label for="email">Email</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="email"
							class="form-control ${erreurs.containsKey('email')?'border border-danger':'border border-secondary' }"
							placeholder="Email" aria-label="email" name="email"
							value="${utilisateur.email}" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('pseudoNonValide') }">
						<p class="text-danger">${erreurs.get('pseudoNonValide')}</p>
					</c:if>

					<c:if test="${erreurs.containsKey('pseudoPresent')}">
						<p class="text-danger">${erreurs.get('pseudoPresent')}</p>
					</c:if>
				</div>
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('emailNonValide') }">
						<p class="text-danger">${erreurs.get('emailNonValide')}</p>
					</c:if>

					<c:if test="${erreurs.containsKey('emailPresent')}">
						<p class="text-danger">${erreurs.get('emailPresent')}</p>
					</c:if>
				</div>
			</div>

			<div class="row">

				<!--  NOM  -->
				<div class="col-sm-2">
					<label for="nom">Nom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('nom')?'border border-danger':'border border-secondary' }"
							placeholder="Nom" aria-label="Nom" name="nom"
							value="${utilisateur.nom}" id="nom" required="required">
					</div>
				</div>

				<!--  PRENOM  -->
				<div class="col-sm-2">
					<label for="prenom">Prénom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('prenom')?'border border-danger':'border border-secondary' }"
							placeholder="Prénom" aria-label="prenom" name="prenom"
							value="${utilisateur.prenom}" required="required">
					</div>
				</div>

			</div>

			<!--  Afficher message d'erreurs -->
			<div class="row">
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('nom')}">
						<p class="text-danger">${erreurs.get('nom')}</p>
					</c:if>
				</div>
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('prenom')}">
						<p class="text-danger">${erreurs.get('prenom')}</p>
					</c:if>
				</div>
			</div>

			<div class="row">
				<!--  TELEPHONE  -->
				<div class="col-sm-2">
					<label for="telephone">Téléphone</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('telephone')?'border border-danger':'border border-secondary' }"
							placeholder="Téléphone" aria-label="telephone" name="telephone"
							value="${utilisateur.telephone}" required="required">
					</div>
				</div>

				<!--  RUE  -->
				<div class="col-sm-2">
					<label for="rue">Rue</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('rue')?'border border-danger':'border border-secondary' }"
							placeholder="Rue" aria-label="rue" name="rue"
							value="${utilisateur.rue}" required="required">
					</div>
				</div>
			</div>
			<!--  Afficher message d'erreurs -->
			<div class="row">
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('telephone')}">
						<p class="text-danger">${erreurs.get('telephone')}</p>
					</c:if>
				</div>
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('rue')}">
						<p class="text-danger">${erreurs.get('rue')}</p>
					</c:if>
				</div>
			</div>


			<div class="row">
				<!--  CODE POSTAL  -->
				<div class="col-sm-2">
					<label for="codePostal">Code postal</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('codePostal')?'border border-danger':'border border-secondary' }"
							placeholder="Code postal" aria-label="codePostal"
							name="codePostal" value="${utilisateur.codePostal}"
							required="required">
					</div>
				</div>

				<!--  VILLE  -->
				<div class="col-sm-2">
					<label for="ville">Ville</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreurs.containsKey('ville')?'border border-danger':'border border-secondary' }"
							placeholder="Ville" aria-label="ville" name="ville"
							value="${utilisateur.ville}" required="required">
					</div>
				</div>
			</div>
			<!--  Afficher message d'erreurs -->
			<div class="row">
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('codePostal')}">
						<p class="text-danger">${erreurs.get('codePostal')}</p>
					</c:if>
				</div>
				<div class="col-sm-6">
					<c:if test="${erreurs.containsKey('ville')}">
						<p class="text-danger">${erreurs.get('ville')}</p>
					</c:if>
				</div>
			</div>
			<div class="row">
				<!--  MOT DE PASSE ACTUEL  -->
				<div class="col-sm-2">
					<label for="motDePasse">Mot de passe :</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password"
							class="form-control ${erreurs.containsKey('MotDePasseNonValide') || erreurs.containsKey('MotDePasseNonIdentique')?'border border-danger':'border border-secondary' }"
							aria-label="motDePasse" name="motDePasse"
							value="${utilisateur.motDePasse }" required="required"
							pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
					</div>
				</div>
				<!-- CONFIRMATION  -->
				<div class="col-sm-2">
					<label for="confirmerMotDePasse">Confirmation :</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password"
							class="form-control ${erreurs.containsKey('MotDePasseNonValide') || erreurs.containsKey('MotDePasseNonIdentique')?'border border-danger':'border border-secondary' }"
							aria-label="confirmerMotDePasse" name="confirmerMotDePasse"
							required="required"
							pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$">
					</div>
				</div>
			</div>

			<br>
			<div class="row mx-auto">
				<div class="mx-auto">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<a href="/ProjectEnchereEni/Accueil" class="btn btn-secondary">Annuler</a>
				</div>
			</div>
		</form>
	</div>
</body>

</html>