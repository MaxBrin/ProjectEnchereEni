<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des enchères</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
		<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap" rel="stylesheet">	
</head>
	
<body>
	<div class="logoPlusNavigation">
		<p class="logo">ENI-ENCHERES</p>
		<c:choose>
			<c:when test="${utilisateur == null }">
				<div class="navigation">
					<a href="/ProjectEnchereEni/CreationCompte" class="">S'inscrire</a>
					<a href="/ProjectEnchereEni/Connexion">Se connecter</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="navigation">
					<a href="/ProjectEnchereEni/CreationCompte">Enchères</a><br>
					<a href="/ProjectEnchereEni/NouvelleVente">Vendre un article</a>
					<a href="/ProjectEnchereEni/ModificationProfil">Mon profil</a><br>
					<a href="/ProjectEnchereEni/Deconnexion">Déconnexion</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="corps">
		<h1 id="titre">LISTE DES ENCHERES</h1>
		<div class="formulaire">
			<form action="">
			<label for="filtre" class="labelFiltre">Filtres</label>
			<input type="texte" placeholder="Ex : voiture, console" id="filtre" >
		
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
		</form>
	</div>
		
	<div id="affichageEncheres">
	</div>
</div>
</body>
</html>