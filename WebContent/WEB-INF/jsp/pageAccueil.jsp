<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des enchères</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
	
<body>
	
	
	<c:choose>
		<c:when test="${utilisateur == null }">
		
	<a href="/ProjectEnchereEni/CreationCompte">S'inscrire</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Se connecter</a>
		</c:when>
		
		<c:otherwise>
	
	<a href="/ProjectEnchereEni/CreationCompte">Enchères</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Vendre un article</a>
	<br>
	<a href="/ProjectEnchereEni/CreationCompte">Mon profil</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Déconnexion</a>
		</c:otherwise>
		
	</c:choose>
	
	
	
		
	<h1>Liste des enchères</h1>
	
	<form action="">
	<label for="filtre" >Filtres</label>
	<input type="texte" placeholder="Le nom de l'article contient" id="filtre" >
	
	
	
	
	<p>Catégorie :</p>
	
	<select name="categorie" id="categorie">
		
		<option value="Informatique" name="categorie">Informatique</option>
		<option value="Ammeublement" name="categorie">Ameublement</option>	
		<option value="Vêtement" name="categorie">Vêtement</option>
		<option value="Sport & Loisirs" name="categorie">Sport & Loisirs</option>

	</select>
	
	
	
	
	<c:if test="${(utilisateur != null)}">
	
		<div>
		<a href="<%=request.getContextPath()%>/Accueil?choix=achat">Achats</a><br>
		<a href="<%=request.getContextPath()%>/Accueil?choix=mesVentes">Mes ventes</a><br>
		</div>
	</c:if>
		<c:if test="${(utilisateur != null) && (choixAchat == null) }">
		<%--Si l'utilisateur est connecté et qu'il n'a pas encore fait de choix --%>	
			<div>
					<input type="checkbox" name="encheresOuvertes" disabled="disabled">Enchères ouvertes<br>
					<input type="checkbox" name="mesEncheres" disabled="disabled">Mes enchères<br>
					<input type="checkbox" name="encheresRemportees" disabled="disabled">Mes enchères remportées<br>
				</div>
		
				<br><br>
		
				<div>
					<input type="checkbox" name="ventesEnCours" disabled="disabled">Mes ventes en cours<br>
					<input type="checkbox" name="ventesNonDebutess" disabled="disabled">Ventes non débutées<br>
					<input type="checkbox" name="ventesTerminees" disabled="disabled">Ventes terminées<br>
				</div>
		</c:if>
	
		<c:if test="${(choixAchat eq 'achat') and (utilisateur != null)}">
				<div>
					<input type="checkbox" name="encheresOuvertes">Enchères ouvertes<br>
					<input type="checkbox" name="mesEncheres">Mes enchères<br>
					<input type="checkbox" name="encheresRemportees">Mes enchères remportées<br>
				</div>
		
				<br><br>
		
				<div>
					<input type="checkbox" name="ventesEnCours" disabled="disabled">Mes ventes en cours<br>
					<input type="checkbox" name="ventesNonDebutess" disabled="disabled">Ventes non débutées<br>
					<input type="checkbox" name="ventesTerminees" disabled="disabled">Ventes terminées<br>
				</div>
			</c:if>
			
			
			<c:if test="${(choixAchat == 'ventes') && (utilisateur != null) }" >
				<div>
					<input type="checkbox" name="encheresOuvertes" disabled="disabled">Enchères ouvertes<br>
					<input type="checkbox" name="mesEncheres" disabled="disabled">Mes enchères<br>
					<input type="checkbox" name="encheresRemportees" disabled="disabled">Mes enchères remportées<br>
				</div>
		
				<br><br>
				<div>
					<input type="checkbox" name="ventesEnCours" >Mes ventes en cours<br>
					<input type="checkbox" name="ventesNonDebutess" >Ventes non débutées<br>
					<input type="checkbox" name="ventesTerminees" >Ventes terminées<br>
				</div>
			</c:if>
			

		
	
	<input type="submit" value="Rechercher"><br><br>
	<br>	
	</form>
	
	
	
	
	
	
	
	<textarea name="nom de l'article" id="" cols="40" rows="5">
	PC Gamer pour travailler 
	Prix :
	Fin de l'enchère :
	Vendeur :
	</textarea>	

	<textarea name="nom de l'article" id="" cols="40" rows="5">
	Rocket stove pour riz et pâtes 
	Prix :
	Fin de l'enchère :
	Vendeur :
	</textarea>	
	
	</body>
</html>