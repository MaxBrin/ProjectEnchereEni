<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/Erreur.css">
<title>Mon profil</title>
</head>

<body>

	<h1>Mon profil</h1>

	<form action="CreationCompte" method="post">
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

				<c:forEach var="erreur" items="${listErreur}">

					<label for="pseudo">Pseudo</label>
					<c:choose>
						<c:when test="${erreur=='Pseudo'}">
							<input type="text" name="pseudo" id="erreur"
								value=${utilisateur.pseudo }>
						</c:when>
						<c:otherwise>
							<input type="text" name="pseudo" id="pseudo"
								value=${utilisateur.pseudo }>
						</c:otherwise>
					</c:choose>


					<label for="nom">Nom</label>
					<input type="text" name="nom" id="nom" value=${utilisateur.nom }>

					<label for="prenom">Prénom</label>
					<input type="text" name="prenom" id="prenom"
						value=${utilisateur.prenom }>

					

					<label for="email">Email</label>
					<c:choose>
						<c:when test="${erreur=='Email'}">
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
						<c:when test="${erreur=='Telephone'}">
							<input type="text" name="telephone" id="erreur"
								value=${utilisateur.telephone }>
						</c:when>
						<c:otherwise>
							<input type="text" name="telephone" id="telephone"
								value=${utilisateur.telephone }>
						</c:otherwise>
					</c:choose>

					<label for="rue">Rue</label>
					<input type="text" name="rue" id="rue" value=${utilisateur.rue }>

					<label for="codePostal">Code postal</label>
					<c:choose>
						<c:when test="${erreur=='CodePostal'}">
							<input type="text" name="codePostal" id="erreur"
								value=${utilisateur.codePostal }>
						</c:when>
						<c:otherwise>
							<input type="text" name="codePostal" id="codePostal"
								value=${utilisateur.codePostal }>
						</c:otherwise>
					</c:choose>

					<label for="ville">Ville</label>
					<input type="text" name="ville" id="ville"
						value=${utilisateur.ville }>

					<c:choose>
						<c:when test="${erreur=='MotDePasse' }">
							<label for="motDePasse">Mot de passe</label>
							<input type="password" name="motDePasse" id="erreur"
								value=${utilisateur.motDePasse }>

							<label for="confirmerMotDePasse">Confirmer</label>
							<input type="password" name="confirmerMotDePasse"
								id="erreur">
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
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<p id="erreurMdpInvalide">
			<c:if test="${messageErreur != null}">
					${messageErreur}
			</c:if>

		</p>

		<button type="submit">Enregistrer</button>
		<a href="/ProjectEnchereEni/Accueil">Annuler</a>


	</form>
</body>
</html>