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
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/styleCreationProfil.css">

</head>
<div class="fond">


<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />


	<h1>Mon profil</h1>

	<form action="${pageContext.request.contextPath }/CreationCompte"
		method="post">

		<!--  Initialisation Message Erreur  -->
		<c:set var="erreur" value="${listErreur}" />
<br>
<table>
<tr>	
	<!--   Modification de l'id de l'input s'il y'a un message d'erreur qui permet de mettre des bordure en rouge -->
	
	<!--  PSEUDO  -->
	<th>
		<div class="marge">
			<label for="pseudo">Pseudo :</label>
			<input type="text" name="pseudo" class="${fn:contains(erreur,'Pseudo')?'erreur':'pseudo' }"
			value="${utilisateur.pseudo }">
		</div>	
	</th>
	
	<!--  NOM  -->
	<th>
		<div class="marge">
			<label for="nom">Nom</label> 
			<input type="text" name="nom" class="${fn:contains(erreur,'Nom')?'erreur':'nom'}"
			value="${utilisateur.nom }" required="required">
		</div>
	</th>
</tr>

<tr>	
	<!--  PRENOM  -->	
	<th>
		<div class="marge">
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" class="${fn:contains(erreur,'Prenom')?'erreur': 'prenom' }"
					value="${utilisateur.prenom }" required="required">
		</div>
	</th>
			
	<!--  EMAIL  -->
	<th>
		<div class="marge">
			<label for="email">Email :</label>
			<input type="text" name="email" class="${fn:contains(erreur,'Email')?'erreur':'email' }"
					value="${utilisateur.email }" required="required">
		</div>
	</th>	
</tr>

<tr>
	<!--  TELEPHONE  -->	
	<th>
	<div class="marge">	
		<label for="telephone">Téléphone : </label>
		<input type="text" name="telephone" class="${fn:contains(erreur,'Telephone')?'erreur' : 'telephone' }"
		value="${utilisateur.telephone }">
	</div>
	</th>
	
	<!--  RUE  -->	
	<th>
	<div class="marge">
		<label for="rue">Rue :</label>
		<input type="text" name="rue" class="${fn:contains(erreur,'Rue')?'erreur':'rue'}"
		value="${utilisateur.rue }">
	</div>
	</th>
</tr>

<tr>
	<!--  CODE POSTAL  -->	
	<th>
	<div class="marge">
		<label for="codePostal">Code postal :</label>
		<input type="text" name="codePostal" class="${fn:contains(erreur,'CodePostal')? 'erreur' :'codePostal' }"
		value="${utilisateur.codePostal }">
		
	</div>
	</th>

	<!--  VILLE  -->	
	<th>
	<div class="marge">
		<label for="ville">Ville :</label>
		<input type="text" name="ville" class="${fn:contains(erreur,'Ville')?'erreur':'ville' }"
		value="${utilisateur.ville }" />
	</div>
	</th>
</tr>

<tr>
	<!--  MOT DE PASSE -->
	<th>
		<label for="motDePasse">Mot de passe :</label>
		<input type="password" name="motDePasse" class="${fn:contains(erreur,'MotDePasse')?'erreur':'motDePasse' }"
					value="${utilisateur.motDePasse }" >
	</th>
	<th>
		<label for="confirmerMotDePasse">Confirmation :</label>
		<input type="password" name="confirmerMotDePasse" id="motDePasse" >
	</th>	
</tr>


</table>
		<h4>
			<c:if test="${fn:contains(erreur,'PseudoNonValide') }">
			Le pseudo n'est pas valide.<br>
			</c:if>

			<c:if test="${fn:contains(erreur,'PseudoPresent') }">
			Le pseudo doit être renseigné.<br>
			</c:if>

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
</body>
</div>
</html>