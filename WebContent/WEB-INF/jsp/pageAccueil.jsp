<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Liste des enchères</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">


</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>
	
	<div class="corps">
		<h1 id="titre">LISTE DES ENCHERES</h1>
		<div class="formulaire">
			<form action="${pageContext.request.contextPath }/Accueil" method="post">
				<label for="filtre" class="labelFiltre">Filtres</label>
				 <input type="texte" placeholder="Ex : voiture, console" id="filtre" name="rechercherArticle">

				<p>Catégorie :</p>

				<select name="categorie" id="categorie">
					
					<option value="0" name="toutesCategories">Toutes</option>
					
					<c:forEach var="categorie" items="${listeCategories}">
					<option value="${categorie.noCategorie}" name="${categorie.libelle}">${categorie.libelle}</option>
					</c:forEach>
				</select>
				
				<c:if test="${(noUtilisateur != null)}">
					<div>
						<a href="<%=request.getContextPath()%>/Accueil?choix=achat">Achats</a><br>
						<a href="<%=request.getContextPath()%>/Accueil?choix=mesVentes">Mes
							ventes</a><br>
					</div>
				</c:if>
				<c:if test="${(noUtilisateur != null) && (choixAchat == null) }">
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
				<c:if test="${(choixAchat eq 'achat') and (noUtilisateur != null)}">
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
				<c:if test="${(choixAchat == 'ventes') && (noUtilisateur != null) }">
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
							<a href="<%=request.getContextPath()%>/DetailVente?idArticle=${article.noArticle}">${article.nomArticle }</a>
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
	

</body>
</html>