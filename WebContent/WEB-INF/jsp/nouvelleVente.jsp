<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="utf-8">

<title>Nouvelle vente</title>

<!-- Bootstrap CSS -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">
		<!--   AFFICHAGE TITRE  -->

		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
			<c:choose> 
				<c:when test="${article == null}">
					<h1 class="offset-sm-1">Nouvelle Vente</h1>
				</c:when>
				<c:otherwise>
					<h1>Modifier Vente</h1>
				</c:otherwise>
			</c:choose>
			</div>
		</div>


		<form method="post" action="NouvelleVente">
			<!--  Initialisation Message Erreur  -->
			<c:set var="erreur" value="${listeErreur}" />

			<!--  NOM ARTICLE  -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="nomArticle">Article :</label>
				</div>
				<div class="col-sm-6">
					<div class="input-group mb-3">
						<input type="text"
							class="form-control ${erreur.containsKey('nomArticle')?'border border-danger':'border border-secondary' }"
							placeholder="Nom de l'article à vendre" aria-label="nomArticle"
							name="nomArticle" value="${article.nomArticle}"
							required="required">
					</div>
				</div>
			</div>
			<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
			<div class="row">
				<div class="col-sm-6 offset-sm-1">
					<c:if test="${erreur.containsKey('nomArticle') }">
						<p class="text-danger">${erreur.get('nomArticle')}</p>
					</c:if>
				</div>
			</div>

			<!--  DESCRIPTION ARTICLE  -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="description">Description :</label>
				</div>
				<div class="col-sm-6">
					<div class="input-group mb-3">
						<textarea rows="5" cols="15" class="form-control"
							placeholder="Description" aria-label="description"
							name="description">${article.description}</textarea>
					</div>
				</div>
			</div>

			<!-- CATEGORIE -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="categorie">Catégorie</label>
				</div>
				<div class="col-sm-2">
					<div class="input-group mb-3">
						<select class="form-control" aria-label="categorie"
							name="categorie" required="required">
							<c:forEach var="categorieDeLaListe" items="${listeCategories}">
								<option value="${categorieDeLaListe.noCategorie}"
									${(categorieSaisie == categorieDeLaListe.noCategorie)?'selected':''}>${categorieDeLaListe.libelle}</option>
							</c:forEach>

						</select>
					</div>
				</div>
			</div>

			<!-- PHOTO -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="photo">Photo de l'article</label>
				</div>
				<a href=""></a>
			</div>
			<br>
			<!-- MISE A PRIX -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="miseAPrix">Mise à prix </label>
				</div>
				<div class="col-sm-2">
					<input type="number" aria-label="miseAPrix"
						class="form-control ${fn:contains(erreur,'prixInitial')?'border border-danger':'border border-secondary' }"
						name="miseAPrix" step="1" min="1" required="required"
						placeholder="Entrez votre prix" value="${article.prixInitial}">
				</div>
			</div>
			<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
			<div class="row">
				<div class="col-sm-6 offset-sm-1">
					<c:if test="${erreur.containsKey('prixInitial') }">
						<p class="text-danger">${erreur.get('prixInitial')}</p>
					</c:if>
				</div>
			</div>
			<br>
			<!-- DEBUT DE L'ENCHERE -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="debutEnchere">Début de l'enchère :</label>
				</div>
				<div class="col-sm-3">
					<input type="date" aria-label="debutEnchere"
						class="form-control ${erreur.containsKey('datesEncheres')?'border border-danger':'border border-secondary' }"
						name="debutEnchere" required="required"
						value="${dateDebut}">
				</div>
			</div>

			<br>

			<!-- FIN DE L'ENCHERE -->
			<div class="row mx-auto">
				<div class="col-md-2 offset-sm-1">
					<label for="finEnchere">Fin de l'enchère :</label>
				</div>
				<div class="col-sm-3">
					<input type="date" aria-label="finEnchere"
						class="form-control ${erreur.containsKey('datesEncheres')?'border border-danger':'border border-secondary' }"
						name="finEnchere" required="required"
						value="${ dateFin}">
				</div>
			</div>
			<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
			<div class="row">
				<div class="col-sm-6 offset-sm-1">
					<c:if test="${erreur.containsKey('datesEncheres') }">
						<p class="text-danger">${erreur.get('datesEncheres')}</p>
					</c:if>
				</div>
			</div>
			<br>

			<!--   RETRAIT  -->
			<fieldset>
				<legend class="offset-sm-1">Retrait</legend>

				<!--   RUE  -->
				<div class="row mx-auto">
					<div class="col-md-2 offset-sm-1">
						<label for="rue">Rue :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('rue')?'border border-danger':'border border-secondary' }"
								placeholder="Rue" aria-label="rue" name="rue"
								value="${retrait.rue }">
						</div>
					</div>
				</div>
				<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
				<div class="row">
					<div class="col-sm-6 offset-sm-1">
						<c:if test="${erreur.containsKey('rue') }">
							<p class="text-danger">${erreur.get('rue')}</p>
						</c:if>
					</div>
				</div>

				<!--   CODE POSTAL  -->
				<div class="row mx-auto">
					<div class="col-md-2 offset-sm-1">
						<label for="codePostal">Code postal :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('codePostal')?'border border-danger':'border border-secondary' }"
								placeholder="Code Postal" aria-label="codePostal"
								name="codePostal" value="${retrait.codePostal }">
						</div>
					</div>
				</div>
				<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
				<div class="row">
					<div class="col-sm-6 offset-sm-1">
						<c:if test="${erreur.containsKey('codePostal') }">
							<p class="text-danger">${erreur.get('codePostal')}</p>
						</c:if>
					</div>
				</div>

				<!--   VILLE  -->
				<div class="row mx-auto">
					<div class="col-md-2 offset-sm-1">
						<label for="ville">Ville :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('ville')?'border border-danger':'border border-secondary' }"
								placeholder="Ville" aria-label="ville" name="ville"
								value="${retrait.ville }">
						</div>
					</div>
				</div>
				<!--  AFFICHAGE DU MESSAGE D'ERREUR -->
				<div class="row">
					<div class="col-sm-6 offset-sm-1">
						<c:if test="${erreur.containsKey('ville') }">
							<p class="text-danger">${erreur.get('ville')}</p>
						</c:if>
					</div>
				</div>


			</fieldset>

			<br>



			<div class="row mx-auto">
				<div class="mx-auto offset-sm-1">
					<button type="submit" class="btn btn-primary">Enregister</button>

					<a href="${pageContext.request.contextPath }/Accueil"
						class="btn btn-secondary ">Annuler</a>
				</div>
			</div>
		</form>
	</div>



</body>

</html>