<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon profil</title>

</head>

<body>

<h1>Mon profil</h1>

<form action="/ModificationProfil" method="post">
			
		<div class="colonnes">
			<div class="colonneA">
			<label for="identifiant">Pseudo</label>
			<input type="text" name="pseudo" id="identifiant">
			
			<label for="identifiant">Nom</label>
			<input type="text" name="nom" id="identifiant">
			
			<label for="identifiant">Prénom</label>
			<input type="text" name="prenom" id="identifiant">
			
			<label for="identifiant">Email</label>
			<input type="text" name="email" id="identifiant">
			
			<label for="identifiant">Téléphone</label>
			<input type="text" name="telephone" id="identifiant">
			</div>
			
			<div class="colonneB">
			<label for="identifiant">Rue</label>
			<input type="text" name="rue" id="identifiant">
			
			<label for="identifiant">Code postal</label>
			<input type="text" name="codePostal" id="identifiant">
			
			<label for="identifiant">Ville</label>
			<input type="text" name="ville" id="identifiant">
			
			<label for="identifiant">Mot de passe actuel</label>
			<input type="text" name="ancienMotDePasse" id="identifiant">
			
			<label for="identifiant">Nouveau mot de passe </label>
			<input type="text" name="nouveauMotDePasse" id="identifiant">
			
			<label for="identifiant">Confirmation</label>
			<input type="password" name="confirmerNouveauMotDePasse" id="confirmerNouveauMotDePasse">
			
			<p id="erreurNouveauMdpInvalide"><c:if test="${messageErreur != null}">
				${messageErreur}
			</c:if>
			</div>
		</div>
			
			<h2>Crédit</h2>
			
			<button type="submit">Enregistrer</button>
			
			<a href="">Supprimer mon compte</a>
			
			
</form>
</body>
</html>