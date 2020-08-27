<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Liste des enchères</title>



<!-- Bootstrap CSS -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">
</head>


<body>

	<!-- INCLUSION EN-TETE -->
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">
		<div class="row mx-auto">
			<div class="mx-auto offset-sm-3">
				<h1>Liste des Enchères</h1>
			</div>
		</div>

		<form action="${pageContext.request.contextPath}/Accueil"
			method="post">
			<div class="row mx-auto">
				<div class="col-md-6 offset-sm-2">
					<!-- RECHERCHE ARTICLE PAR NOM -->
					<div class="row mx-auto">
						<div class="col-md-4 ">
							<label for="filtre" class="labelFiltre">Filtres</label>
						</div>
						<div class="col-md-8">
							<input type="text" class="form-control"
								placeholder="Ex : voiture, console" aria-label="labelFiltre"
								name="rechercherArticle">
						</div>
					</div>
					<!-- RECHERCHE PAR SELECT CATEGORIE -->
					<div class="row mx-auto">
						<div class="col-md-4 ">
							<label for="categorie" class="labelCategorie">Catégories</label>
						</div>
						<div class="col-md-8">
							<select class="custom-select" id="categorie" name="categorie">
								<!--  Valeur par defaut pour filtrer avec toutes les catégories  -->
								<option value="0" name="toutesCategories">Toutes</option>
								<!--  Affichage des catégories en fonction de la liste dans la BD  -->
								<c:forEach var="categorie" items="${listeCategories}">
									<option value="${categorie.noCategorie}"
										${(categorieSaisie == categorie.noCategorie)?'selected':''}>${categorie.libelle}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-2 ">
					<button type="submit" class="btn btn-primary btn-lg">Rechercher</button>

				</div>
			</div>
			<br>

			<!--  Bouton choix achats ou ventes -->
			<c:if test="${(noUtilisateur != null)}">

				<div class="row ">
					<div class="col-md-2 offset-sm-4">
						<a href="${pageContext.request.contextPath }/Accueil?choix=achat"
							class="btn btn-secondary btn-sm">Achats</a>
					</div>
					<div class="col-md-2 ">
						<a
							href="${pageContext.request.contextPath }/Accueil?choix=mesVentes"
							class="btn btn-secondary btn-sm">Mes ventes</a>
					</div>
				</div>

			</c:if>

			<!-- AFFICHAGE DES CHECKBOXES EN FONCTION DU CHOIX "ACHATS" OU "MES VENTES" -->

			<!--  ACHAT -->

			<c:if test="${(choixAchat eq 'achat') and (noUtilisateur != null)}">
				<input type="hidden" value="achat" name="choix">
				<div class="row ">
					<div class="col-md-2 offset-sm-4">
						<div>
							<input type="checkbox" name="encheresOuvertes"
								${ckEncheresOuvertesCheck?'checked':'' }>Enchères
							ouvertes<br> <input type="checkbox" name="mesEncheres"
								${ckMesEncheresCheck?'checked':'' }>Mes enchères<br>
							<input type="checkbox" name="encheresRemportees"
								${ckEncheresEmporteesCheck?'checked':'' }>Mes enchères
							remportées<br>
						</div>
					</div>
				</div>

			</c:if>


			<!--  VENTES -->
			<c:if test="${(choixAchat == 'ventes') && (noUtilisateur != null) }">
				<input type="hidden" value="ventes" name="choix">
				<div class="row ">
					<div class="col-md-4 offset-sm-6">
						<input type="checkbox" name="ventesEnCours"
							${ckMesVentesEnCoursCheck ?'checked':'' }>Mes ventes en
						cours<br> <input type="checkbox" name="ventesNonDebutees"
							${ckMesVentesNonDebuteesCheck ?'checked':'' }>Ventes non
						débutées<br> <input type="checkbox" name="ventesTerminees"
							${ckVentesTermineesCheck ?'checked':'' }>Ventes terminées<br>
					</div>
				</div>
			</c:if>
		</form>
	</div>
	<br>
	<br>


	<div class="row justify-content-center">
		<!--  Affichage de la liste des articles -->
		<c:forEach var="article" items="${listeArticlesAAfficher }">
			<div class="justify-content-around row-cols-4 ">
				<div class="col-md-1 offset-sm-1">
					<!-- Affichage d'article en vente -->
					<div class="card" style="width: 18rem;">
						<img
							src="${pageContext.request.contextPath }/img/Photo Objets.jpg"
							class="card-img-top" alt="photo article">
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
			</div>
		</c:forEach>
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