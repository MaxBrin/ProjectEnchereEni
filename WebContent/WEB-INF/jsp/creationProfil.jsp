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
			<th>
				<div class="marge">
					<label for="nom">Nom</label> <input type="text" name="nom"
						class="${fn:contains(erreur,'Nom')?'erreur':'nom'}"
						value="${utilisateur.nom }" required="required">
				</div>
			</th>
			</tr>

			<tr>
				<!--  PRENOM  -->
				<th>
					<div class="marge">
						<label for="prenom">Prénom :</label> <input type="text"
							name="prenom"
							class="${fn:contains(erreur,'Prenom')?'erreur': 'prenom' }"
							value="${utilisateur.prenom }" required="required">
					</div>
				</th>

				<!--  EMAIL  -->
				<th>
					<div class="marge">
						<label for="email">Email :</label> <input type="text" name="email"
							class="${fn:contains(erreur,'Email')?'erreur':'email' }"
							value="${utilisateur.email }" required="required">
					</div>
				</th>
			</tr>

			<tr>
				<!--  TELEPHONE  -->
				<th>
					<div class="marge">
						<label for="telephone">Téléphone : </label> <input type="text"
							name="telephone"
							class="${fn:contains(erreur,'Telephone')?'erreur' : 'telephone' }"
							value="${utilisateur.telephone }">
					</div>
				</th>

				<!--  RUE  -->
				<th>
					<div class="marge">
						<label for="rue">Rue :</label> <input type="text" name="rue"
							class="${fn:contains(erreur,'Rue')?'erreur':'rue'}"
							value="${utilisateur.rue }">
					</div>
				</th>
			</tr>

			<tr>
				<!--  CODE POSTAL  -->
				<th>
					<div class="marge">
						<label for="codePostal">Code postal :</label> <input type="text"
							name="codePostal"
							class="${fn:contains(erreur,'CodePostal')? 'erreur' :'codePostal' }"
							value="${utilisateur.codePostal }">

					</div>
				</th>

				<!--  VILLE  -->
				<th>
					<div class="marge">
						<label for="ville">Ville :</label> <input type="text" name="ville"
							class="${fn:contains(erreur,'Ville')?'erreur':'ville' }"
							value="${utilisateur.ville }" />
					</div>
				</th>
			</tr>

			<tr>
				<!--  MOT DE PASSE -->
				<th><label for="motDePasse">Mot de passe :</label> <input
					type="password" name="motDePasse"
					class="${fn:contains(erreur,'MotDePasse')?'erreur':'motDePasse' }"
					value="${utilisateur.motDePasse }"></th>
				<th><label for="confirmerMotDePasse">Confirmation :</label> <input
					type="password" name="confirmerMotDePasse" id="motDePasse">
				</th>
			</tr>


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

			<button type="submit">Enregistrer</button>
			<a href="/ProjectEnchereEni/Accueil">Annuler</a>
		</form>
	</div>
</body>

</html>