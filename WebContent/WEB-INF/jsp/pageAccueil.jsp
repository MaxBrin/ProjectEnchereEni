<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Liste des enchères</title>

<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">

</head>


<body>

	<!-- INCLUSION EN-TETE -->
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">
		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
				<h1>LISTE DES ENCHERES</h1>
			</div>
		</div>

		<form action="${pageContext.request.contextPath}/Accueil"
			method="post">
			<!-- RECHERCHE ARTICLE PAR NOM -->
			<div class="row ">
				<div class="col-md-2">
					<label for="filtre" class="labelFiltre">Filtres</label>
				</div>
				<div class="col-md-4">
					<input type="text" class="form-control"
						placeholder="Ex : voiture, console" aria-label="labelFiltre"
						name="rechercherArticle">
				</div>
			</div>
			<!-- RECHERCHE PAR SELECT CATEGORIE -->
			<div class="row ">
				<div class="col-md-2">
					<label for="categorie" class="labelCategorie">Catégories</label>
				</div>
				<div class="col-md-4">
					<select class="custom-select" id="categorie" name="categorie">
						<!--  Valeur par defaut pour filtrer avec toutes les catégories  -->
						<option value="0" name="toutesCategories">Toutes</option>
						<!--  Affichage des catégories en fonction de la liste dans la BD  -->
						<c:forEach var="categorie" items="${listeCategories}">
							<option value="${categorie.noCategorie}"
								name="${categorie.libelle}" ${(categorieSaisie == categorie.noCategorie)?'selected':''}>${categorie.libelle}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-md-4 offset-sm-1">
					<button type="submit" class="btn btn-secondary btn-lg">Rechercher</button>
					<br> <br>
				</div>
			</div>

			<!--  Bouton choix achats ou ventes -->
			<c:if test="${(noUtilisateur != null)}">
				<div class="row ">
					<div class="col-md-1 offset-sm-2">

						<a href="${pageContext.request.contextPath }/Accueil?choix=achat"
							class="btn btn-secondary btn-sm">Achats</a>
					</div>
					<div class="col-md-2 offset-sm-1">
						<a
							href="${pageContext.request.contextPath }/Accueil?choix=mesVentes"
							class="btn btn-secondary btn-sm">Mes ventes</a>
					</div>
						
					<div class="col-md-2">
						<a
							href="${pageContext.request.contextPath }/Accueil?choix=annuler"
							class="btn btn-secondary btn-sm">Annuler</a>
					</div>	
						
	
								
				</div>
			</c:if>
			<!-- AFFICHAGE DES CHECKBOXES EN FONCTION DU CHOIX "ACHATS" OU "MES VENTES" -->
			
			<!--  ACHAT -->
			<c:if test="${(choixAchat eq 'achat') and (noUtilisateur != null)}">
			<input type="hidden" value="achat" name="choix">
				<div class="row ">
					<div class="col-md-8 offset-sm-2">
						<div>
							<input type="checkbox" name="encheresOuvertes" >Enchères
							ouvertes<br> <input type="checkbox" name="mesEncheres">Mes
							enchères<br> <input type="checkbox"
								name="encheresRemportees">Mes enchères remportées<br>
						</div>
					</div>
				</div>
			</c:if>
			
			<!--  VENTES -->
			<c:if test="${(choixAchat == 'ventes') && (noUtilisateur != null) }">
			<input type="hidden" value="ventes" name="choix">
				<div class="row ">
					<div class="col-md-8 offset-sm-4">
						<input type="checkbox" name="ventesEnCours">Mes ventes en
						cours<br> <input type="checkbox" name="ventesNonDebutees">Ventes
						non débutées<br> <input type="checkbox"
							name="ventesTerminees">Ventes terminées<br>
					</div>
				</div>
			</c:if>
		</form>

		<c:if test="${ErreurBD!=null}">
			<div class="row mx-auto">
				<div class="mx-auto" style="width: 500px;">
					<h3 class="text-danger ">${ErreurBD}</h3>
				</div>
			</div>
		</c:if>

		<div class="row   justify-content-center">
			<!--  Affichage de la liste des articles -->
			<c:forEach var="article" items="${listeArticlesAAfficher }">

				<div class="col-lg-3 col-md-6">
					<!-- Affichage d'article en vente -->
					<div class="card" style="width: 18rem;">
						<img src="..." class="card-img-top" alt="...">
						<div class="card-body">
							<!--  Nom de l'article avec un lien vers detail de l'article -->
							<h5 class="card-title">
								<c:choose>
									<c:when test="${noUtilisateur == null}">
										${article.nomArticle }
									</c:when>
									<c:otherwise>
										<a
											href="${pageContext.request.contextPath }/DetailVente?idArticle=${article.noArticle}">${article.nomArticle }</a>
									</c:otherwise>
								</c:choose>

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
								Vendeur : <a
									href="${pageContext.request.contextPath }/VisualiserProfil?utilisateurVendeur=${article.utilisateur.noUtilisateur}"
									class="card-link">${article.utilisateur.pseudo }</a>
							</p>
						</div>
					</div>
				</div>

			</c:forEach>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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