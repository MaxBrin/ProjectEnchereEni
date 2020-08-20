<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/Erreur.css">
<title>Mon profil</title>
</head>

<body>
	
	<h1>Mon profil</h1>

	<form action="${pageContext.request.contextPath }/CreationCompte" method="post">
		<c:choose>
			<c:when test="${listErreur ==null }">

				<label for="pseudo">Pseudo</label>
				<input type="text" name="pseudo" id="pseudo"
					value=${utilisateur.pseudo }>

				<label for="nom">Nom</label>
				<input type="text" name="nom" id="nom" value=${utilisateur.nom }>

				<label for="prenom">Prénom</label>
				<input type="text" name="prenom" id="prenom"
					value=${utilisateur.prenom }>

				<label for="email">Email</label>
				<input type="email" name="email" id="email"
					value=${utilisateur.email }>

				<label for="telephone">Téléphone</label>
				<input type="text" name="telephone" id="telephone"
					value=${utilisateur.telephone }>

				<label for="rue">Rue</label>
				<input type="text" name="rue" id="rue" value=${utilisateur.rue }>

				<label for="codePostal">Code postal</label>
				<input type="text" name="codePostal" id="codePostal"
					value=${utilisateur.codePostal }>

				<label for="ville">Ville</label>
				<input type="text" name="ville" id="ville"
					value=${utilisateur.ville }>

				<label for="motDePasse">Mot de passe</label>
				<input type="password" name="motDePasse" id="motDePasse"
					value=${utilisateur.motDePasse }>

				<label for="confirmerMotDePasse">Confirmer</label>
				<input type="password" name="confirmerMotDePasse"
					id="confirmerMotDePasse">
			</c:when>

			<c:otherwise>

				<c:set var="erreur" value="${listErreur}" />
				
				
				<label for="pseudo">Pseudo</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Pseudo') }">
						<input type="text" name="pseudo" id="erreur"
							value=${utilisateur.pseudo }>
					</c:when>
					<c:otherwise>
						<input type="text" name="pseudo" id="pseudo"
							value=${utilisateur.pseudo }>
					</c:otherwise>
				</c:choose>


				<label for="nom">Nom</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Nom') }">
						<input type="text" name="nom" id="erreur"
							value=${utilisateur.nom }>
					</c:when>
					<c:otherwise>
						<input type="text" name="nom" id="nom" value=${utilisateur.nom }>
					</c:otherwise>
				</c:choose>

				<label for="prenom">Prénom</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Prenom') }">
						<input type="text" name="prenom" id="erreur"
							value=${utilisateur.prenom }>
					</c:when>
					<c:otherwise>
						<input type="text" name="prenom" id="prenom"
							value=${utilisateur.prenom }>
					</c:otherwise>
				</c:choose>


				<label for="email">Email</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Email') }">
						<input type="text" name="email" id="erreur"
							value=${utilisateur.email }>
					</c:when>
					<c:otherwise>
						<input type="text" name="email" id="email"
							value=${utilisateur.email }>
					</c:otherwise>
				</c:choose>

				<label for="telephone">Téléphone</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Telephone') }">
						<input type="text" name="telephone" id="erreur"
							value=${utilisateur.telephone }>
					</c:when>
					<c:otherwise>
						<input type="text" name="telephone" id="telephone"
							value=${utilisateur.telephone }>
					</c:otherwise>
				</c:choose>

				<label for="rue">Rue</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Rue') }">
						<input type="text" name="rue" id="erreur"
							value=${utilisateur.rue }>
					</c:when>
					<c:otherwise>
						<input type="text" name="rue" id="rue" value=${utilisateur.rue }>
					</c:otherwise>
				</c:choose>



				<label for="codePostal">Code postal</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'CodePostal') }">
						<input type="text" name="codePostal" id="erreur"
							value=${utilisateur.codePostal }>
					</c:when>
					<c:otherwise>
						<input type="text" name="codePostal" id="codePostal"
							value=${utilisateur.codePostal }>
					</c:otherwise>
				</c:choose>

				<label for="ville">Ville</label>
				<c:choose>
					<c:when test="${fn:contains(erreur,'Ville') }">
						<input type="text" name="ville" id="erreur"
							value=${utilisateur.ville }>
					</c:when>
					<c:otherwise>
						<input type="text" name="ville" id="ville"
							value=${utilisateur.ville }>
					</c:otherwise>
				</c:choose>



				<c:choose>
					<c:when test="${fn:contains(erreur,'MotDePasse') }">
						<label for="motDePasse">Mot de passe</label>
						<input type="password" name="motDePasse" id="erreur"
							value=${utilisateur.motDePasse }>

						<label for="confirmerMotDePasse">Confirmer</label>
						<input type="password" name="confirmerMotDePasse" id="erreur">
					</c:when>

					<c:otherwise>
						<label for="motDePasse">Mot de passe</label>
						<input type="password" name="motDePasse" id="motDePasse"
							value=${utilisateur.motDePasse }>

						<label for="confirmerMotDePasse">Confirmer</label>
						<input type="password" name="confirmerMotDePasse"
							id="confirmerMotDePasse">
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
		
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
</html>