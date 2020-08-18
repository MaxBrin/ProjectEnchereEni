<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon profil</title>
</head>

<body>

<h1>Mon profil</h1>

<form action="CreationCompte" method="post"> 
			
			<label for="pseudo">Pseudo</label>
			<input type="text" name="pseudo" id="pseudo">
			
			<label for="nom">Nom</label>
			<input type="text" name="nom" id="nom">
			
			<label for="prenom">Prénom</label>
			<input type="text" name="prenom" id="prenom">
			
			<label for="email">Email</label>
			<input type="email" name="email" id="email">
			
			<label for="telephone">Téléphone</label>
			<input type="text" name="telephone" id="telephone">
			
			<label for="rue">Rue</label>
			<input type="text" name="rue" id="rue">
			
			<label for="codePostal">Code postal</label>
			<input type="text" name="codePostal" id="codePostal">
			
			<label for="ville">Ville</label>
			<input type="text" name="ville" id="ville">
			
			<label for="motDePasse">Mot de passe</label>
			<input type="password" name="motDePasse" id="motDePasse">
			
			<label for="confirmerMotDePasse">Confirmer</label>
			<input type="password" name="confirmerMotDePasse" id="confirmerMotDePasse">
			
			<p id="erreurMdpInvalide"><c:if test="${messageErreur != null}">
					${messageErreur}
			</c:if>
			
			</p>
			
			<button type="submit">Enregistrer</button>
			<a href="/ProjectEnchereEni/Accueil">Annuler</a>
			
			
</form>
</body>
</html>