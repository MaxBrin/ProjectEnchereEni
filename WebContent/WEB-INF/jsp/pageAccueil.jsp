<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
<title>Liste des enchères</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

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
					<a href="/ProjectEnchereEni/CreationCompte">Enchères</a><br> <a
						href="/ProjectEnchereEni/NouvelleVente">Vendre un article</a> <a
						href="/ProjectEnchereEni/ModificationProfil">Mon profil</a><br>
					<a href="/ProjectEnchereEni/Deconnexion">Déconnexion</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="corps">
		<h1 id="titre">LISTE DES ENCHERES</h1>
		<div class="formulaire">
			<form action="${pageContext.request.contextPath }/Accueil" method="post">
				<label for="filtre" class="labelFiltre">Filtres</label>
				 <input type="texte" placeholder="Ex : voiture, console" id="filtre">

				<p>Catégorie :</p>

				<select name="categorie" id="categorie">
					
					<option value="0" name="toutesCategories">Toutes</option>
					
					<c:forEach var="categorie" items="${listeCategories}">
					<option value="${categorie.noCategorie}" name="${categorie.libelle}">${categorie.libelle}</option>
					</c:forEach>
				</select>
				
				<c:if test="${(utilisateur != null)}">
					<div>
						<a href="<%=request.getContextPath()%>/Accueil?choix=achat">Achats</a><br>
						<a href="<%=request.getContextPath()%>/Accueil?choix=mesVentes">Mes
							ventes</a><br>
					</div>
				</c:if>
				<c:if test="${(utilisateur != null) && (choixAchat == null) }">
					<%--Si l'utilisateur est connecté et qu'il n'a pas encore fait de choix --%>
					<div>
						<input type="checkbox" name="encheresOuvertes" disabled="disabled">Enchères
						ouvertes<br> <input type="checkbox" name="mesEncheres"
							disabled="disabled">Mes enchères<br> <input
							type="checkbox" name="encheresRemportees" disabled="disabled">Mes
						enchères remportées<br>
					</div>
					<div>
						<input type="checkbox" name="ventesEnCours" disabled="disabled">Mes
						ventes en cours<br> <input type="checkbox"
							name="ventesNonDebutess" disabled="disabled">Ventes non
						débutées<br> <input type="checkbox" name="ventesTerminees"
							disabled="disabled">Ventes terminées<br>
					</div>
				</c:if>
				<c:if test="${(choixAchat eq 'achat') and (utilisateur != null)}">
					<div>
						<input type="checkbox" name="encheresOuvertes">Enchères
						ouvertes<br> <input type="checkbox" name="mesEncheres">Mes
						enchères<br> <input type="checkbox" name="encheresRemportees">Mes
						enchères remportées<br>
					</div>

					<br>
					<br>

					<div>
						<input type="checkbox" name="ventesEnCours" disabled="disabled">Mes
						ventes en cours<br> <input type="checkbox"
							name="ventesNonDebutess" disabled="disabled">Ventes non
						débutées<br> <input type="checkbox" name="ventesTerminees"
							disabled="disabled">Ventes terminées<br>
					</div>
				</c:if>
				<c:if test="${(choixAchat == 'ventes') && (utilisateur != null) }">
					<div>
						<input type="checkbox" name="encheresOuvertes" disabled="disabled">Enchères
						ouvertes<br> <input type="checkbox" name="mesEncheres"
							disabled="disabled">Mes enchères<br> <input
							type="checkbox" name="encheresRemportees" disabled="disabled">Mes
						enchères remportées<br>
					</div>
					<br>
					<br>
					<div>
						<input type="checkbox" name="ventesEnCours">Mes ventes en
						cours<br> <input type="checkbox" name="ventesNonDebutess">Ventes
						non débutées<br> <input type="checkbox"
							name="ventesTerminees">Ventes terminées<br>
					</div>
				</c:if>

				<input type="submit" value="Rechercher"><br> <br>
			</form>
		</div>

		<div id="affichageEncheres">
			<!--  Affichage de la liste des articles -->
			<c:forEach var="article" items="${listeArticlesAAfficher }">
				<!-- Affichage d'article en vente -->
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<!--  Nom de l'article avec un lien vers detail de l'article -->
						<h5 class="card-title">
							<a href="">${article.nomArticle }</a>
						</h5>
						<!--  prix de l'article -->
						<h6 class="card-subtitle mb-2 text-muted">Prix :
							${article.prixInitial}</h6>
						<!--  Affichage de la date de fin d'enchere au format 01 janvier 2020 00:00:00 -->
						<p class="card-text">
							Fin de l'enchère :
							<!--  Formatage de la date -->
							<fmt:parseDate value="${article.finEnchere}"
								pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="both" />
							<fmt:formatDate value="${parsedDate }" dateStyle="long"
								timeStyle="medium" type="both" />
						</p>
						<!--  Liens vers le profil du vendeur de l'article -->
						<p class="card-text">
							Vendeur : <a href="" class="card-link">${article.utilisateur.pseudo }</a>
						</p>


					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>

</body>
</html>