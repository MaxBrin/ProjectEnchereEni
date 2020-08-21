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


		<c:set var="erreur" value="${listErreur}" />
<br>
<table>
<tr>	
	<th>
	
		<div class="marge">
			<label for="pseudo">Pseudo :</label>
			
			<c:choose>
				<c:when test="${fn:contains(erreur,'Pseudo') }">
					<input type="text" name="pseudo" id="erreur"
						value="${utilisateur.pseudo }">
				</c:when>
				<c:otherwise>
					<input type="text" name="pseudo" id="pseudo"
						value="${utilisateur.pseudo }">
				</c:otherwise>
			</c:choose>
		</div>	
	</th>
	
		<!--  NOM -->
	<th>
		<div class="marge">
			<label for="nom">Nom :</label>
			<input type="text" name="nom"
				id="${fn:contains(erreur,'Nom')?'erreur':'nom'}"
				value="${utilisateur.nom }" required="required"> 
		</div>
	</th>
</tr>

<tr>	
	<!--  PRENOM -->	
	<th>
		<div class="marge">
			<label for="prenom">Prénom :</label>
			<input type="text" name="prenom" id="${fn:contains(erreur,'Prenom')?'erreur': 'prenom' }"
					value="${utilisateur.prenom }" required="required">
		</div>
	</th>
	
	
			
		<!--  EMAIL-->
	<th>
		<div class="marge">
			<label for="email">Email :</label>
			<input type="text" name="email" id="${fn:contains(erreur,'Email')?'erreur':'email' }"
					value="${utilisateur.email }" required="required">
		</div>
	</th>	
</tr>

<tr>
	<!--  TELEPHONE -->	
	<th>
	<div class="marge">	
		<label for="telephone">Téléphone : </label>
		<c:choose>
			<c:when test="${fn:contains(erreur,'Telephone') }">
				<input type="text" name="telephone" id="erreur"
					value="${utilisateur.telephone }">
			</c:when>
			<c:otherwise>
				<input type="text" name="telephone" id="telephone"
					value="${utilisateur.telephone }">
			</c:otherwise>
		</c:choose>
	</div>
	</th>

	<th>
	<div class="marge">
		<label for="rue">Rue :</label>
		<c:choose>
			<c:when test="${fn:contains(erreur,'Rue') }">
				<input type="text" name="rue" id="erreur"
					value="${utilisateur.rue }">
			</c:when>
			<c:otherwise>
				<input type="text" name="rue" id="rue" value="${utilisateur.rue }">
			</c:otherwise>
		</c:choose>
	</div>
	</th>
</tr>



<tr>
	<th>
	<div class="marge">
		<label for="codePostal">Code postal :</label>
		<c:choose>
			<c:when test="${fn:contains(erreur,'CodePostal') }">
				<input type="text" name="codePostal" id="erreur"
					value="${utilisateur.codePostal }">
			</c:when>
			<c:otherwise>
				<input type="text" name="codePostal" id="codePostal"
					value="${utilisateur.codePostal }">
			</c:otherwise>
		</c:choose>
	</div>
	</th>


	<th>
	
	<div class="marge">
		<label for="ville">Ville :</label>
		<c:choose>
			<c:when test="${fn:contains(erreur,'Ville') }">
				<input type="text" name="ville" id="erreur"
					value="${utilisateur.ville }" />
					</c:when>
			<c:otherwise>
				<input type="text" name="ville" id="ville"
					value="${utilisateur.ville}" />
					</c:otherwise>
		</c:choose>
	</div>
	
	</th>
</tr>
<tr>
	<th>
		<!--  MOT DE PASSE -->
		<label for="motDePasse">Mot de passe :</label>
		<input type="password" name="motDePasse" id="${fn:contains(erreur,'MotDePasse')?'erreur':'motDePasse' }"
					value="${utilisateur.motDePasse }" pattern="^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[^\\w\\s])\\S{8,}$">
	</th>


	<th>
	
		<label for="confirmerMotDePasse">Confirmation :</label>
		<input type="password" name="confirmerMotDePasse" id="motDePasse" pattern="^(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*\\d)(?=\\S*[^\\w\\s])\\S{8,}$">
	
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