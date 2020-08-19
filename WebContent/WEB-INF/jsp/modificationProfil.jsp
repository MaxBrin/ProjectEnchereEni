<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html> 
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
	<title>Mon profil</title>

</head>

<body>

<h1>Mon profil</h1>

<form action="${pageContext.request.contextPath}/ModificationProfil" method="post">
			
		<div class="colonnes">
			<div class="colonneA">
			<label for="pseudo">Pseudo</label>
			<input type="text" name="pseudo" value="${utilisateur.pseudo}" id="pseudo">
			
			<label for="nom">Nom</label>
			<input type="text" name="nom" value="${utilisateur.nom}" id="nom">
			
			<label for="prenom">Prénom</label>
			<input type="text" name="prenom" value="${utilisateur.prenom}" id="prenom">
			
			<label for="email">Email</label>
			<input type="text" name="email" value="${utilisateur.email}" id="email">
			
			<label for="telephone">Téléphone</label>
			<input type="text" name="telephone" value="${utilisateur.telephone}" id="telephone">
			</div>
			
			<div class="colonneB">
			<label for="rue">Rue</label>
			<input type="text" name="rue" value="${utilisateur.rue}" id="rue">
			
			<label for="codePostal">Code postal</label>
			<input type="text" name="codePostal" value="${utilisateur.codePostal}" id="codePostal">
			
			<label for="ville">Ville</label>
			<input type="text" name="ville" value="${utilisateur.ville}" id="ville">
			
			<label for="ancienMotDePasse">Mot de passe actuel</label>
			<input type="password" name="ancienMotDePasse"   id="ancienMotDePasse">
			
			<label for="nouveauMotDePasse">Nouveau mot de passe </label>
			<input type="password" name="nouveauMotDePasse"   id="nouveauMotDePasse">
			
			<label for="confirmerNouveauMotDePasse">Confirmation</label>
			<input type="password" name="confirmerNouveauMotDePasse"  id="confirmerNouveauMotDePasse">
			
			
			</div>
		</div>
			
			<p>
			<label for="credit" >Crédit  </label>${utilisateur.credit}
			</p>
			
			<c:if test="${message != null}">
				<p>${message}</p>
			</c:if>
			
			<button type="submit">Enregistrer</button>
			
			<a href="">Supprimer mon compte</a>
			
			
</form>
</body>
</html>