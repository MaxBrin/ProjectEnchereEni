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


		<form action="${pageContext.request.contextPath }/CreationCompte"
			method="post">

			<!--  Initialisation Message Erreur  -->
			<c:set var="erreur" value="${listErreur}" />


			<!--   Modification de l'id de l'input s'il y'a un message d'erreur qui permet de mettre des bordure en rouge -->


			<div class="row">
				<!--  PSEUDO  -->
				<div class="col-md-2">
					<label for="pseudo">Pseudo</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Pseudo')?'border border-danger':'border border-secondary' }"
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
						<input type="text"
							class="form-control ${fn:contains(erreur,'Email')?'border border-danger':'border border-secondary' }"
							placeholder="Email" aria-label="email" name="email"
							value="${utilisateur.email}" required="required">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<c:if test="${fn:contains(erreur,'PseudoNonValide') }">
			<p class="text-danger">Le pseudo est non valide</p>
					</c:if>

					<c:if test="${fn:contains(erreur,'PseudoPresent') }">
			<p class="text-danger">Le pseudo doit être renseigné.</p>
					</c:if>
				</div>
			</div>

			<!--  NOM  -->
			<div class="row">
			<div class="col-md-2">
					<label for="email">Nom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Nom')?'border border-danger':'border border-secondary' }"
							placeholder="Nom" aria-label="nom" name="nom"
							value="${utilisateur.nom}" required="required">
					</div>
				</div>
			

				<!--  PRENOM  -->
				<div class="col-md-2">
					<label for="email">Prénom</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Prénom')?'border border-danger':'border border-secondary' }"
							placeholder="prenom" aria-label="prenom" name="prenom"
							value="${utilisateur.prenom}" required="required">
					</div>
				</div>
			</div>	
				

				<!--  TELEPHONE  -->
				
				<div class="row">
			<div class="col-md-2">
					<label for="telephone">Téléphone</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Téléphone')?'border border-danger':'border border-secondary' }"
							placeholder="Téléphone" aria-label="telephone" name="telephone"
							value="${utilisateur.telephone}" required="required">
					</div>
				</div>
				

				<!--  RUE  -->
				
				<div class="col-md-2">
					<label for="email">Rue</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Rue')?'border border-danger':'border border-secondary' }"
							placeholder="rue" aria-label="rue" name="rue"
							value="${utilisateur.rue}" required="required">
					</div>
				</div>
			</div>
				
			
				<!--  CODE POSTAL  -->
				
					<div class="row">
				<div class="col-md-2">
					<label for="codePostal">Code postal</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Code postal')?'border border-danger':'border border-secondary' }"
							placeholder="Code postal" aria-label="codePostal" name="codePostal"
							value="${utilisateur.codePostal}" required="required">
					</div>
				</div>
				


				<!--  VILLE  -->
				
				<div class="col-md-2">
					<label for="ville">Ville</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${fn:contains(erreur,'Ville')?'border border-danger':'border border-secondary' }"
							placeholder="ville" aria-label="ville" name="ville"
							value="${utilisateur.ville}" required="required">
					</div>
				</div>
			</div>
				

				<!--  MOT DE PASSE -->
				
						<div class="row">
			<div class="col-md-2">
					<label for="motDePasse">Mot de passe</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="password"
							class="form-control ${fn:contains(erreur,'Mot de passe')?'border border-danger':'border border-secondary' }"
							placeholder="Mot de passe" aria-label="motDePasse" name="motDePasse"
							value="${utilisateur.motDePasse}" required="required">
					</div>
				</div>
	</table>
			
			<h4>


				<c:if test="${fn:contains(erreur,'Nom') }">
			Le nom doit être renseigné<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'Prenom') }">
			Le prénom doit être renseigné<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'EmailNonValide') }">
			L'email n'est pas valide.<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'EmailPresent') }">
			L'email est déjà présent<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'Telephone') }">
			Le numéro de téléphone n'est pas valide<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'Rue') }">
			La rue doit être renseigné<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'CodePostal') }">
			Le code postal n'est pas valide<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'Ville') }">
			La ville doit être renseigné<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'MotDePasseIdentique') }">
			Les mots de passe sont identiques<br>
				</c:if>

				<c:if test="${fn:contains(erreur,'MotDePasseVerif') }">
			Le mot de passe n'est pas valide. Il doit contenir au moins une majuscule,une minuscule,un caractère spéciaux et un chiffre<br>
				</c:if>


			</h4>
			
			
			<div class="row">
				<div class="col-md-2">
					<button type="submit" class="btn btn-secondary btn-lg">Enregistrer</button>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<a href="/ProjectEnchereEni/Accueil">Annuler</a>
					</div>
				</div>
			</div>
			
			
			
			<!--  <div class="row">
			<div class="col-md-2">
				<button type="submit" class="btn btn-secondary btn-lg">Enregistrer</button>
			</div>
			<a href="/ProjectEnchereEni/Accueil">Annuler</a>
			</div>-->
			
		</form>
	</div>
</body>

</html>