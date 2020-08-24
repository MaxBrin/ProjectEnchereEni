<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>



<meta charset="utf-8">

<title>Nouvelle vente</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/Erreur.css">

</head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<div class="container">
		<!--   AFFICHAGE TITRE  -->

		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
				<h1>Nouvelle Vente</h1>
			</div>
		</div>


		<form method="post" action="NouvelleVente">
			<!--  Initialisation Message Erreur  -->
			<c:set var="erreur" value="${listeErreur}" />

			<!--  NOM ARTICLE  -->
			<div class="row mx-auto">
				<div class="col-md-2">
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

			<!--  DESCRIPTION ARTICLE  -->
			<div class="row mx-auto">
				<div class="col-md-2">
					<label for="description">Description :</label>
				</div>
				<div class="col-sm-6">
					<div class="input-group mb-3">
						<textarea rows="5" cols="15"
							class="form-control"
							placeholder="Description" aria-label="description"
							name="description">${article.description}</textarea>
					</div>
				</div>
			</div>

			<!-- CATEGORIE -->
			<div class="row mx-auto">
				<div class="col-md-2">
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
				<div class="col-md-2">
					<label for="photo">Photo de l'article</label>
				</div>
				<a href=""></a>
			</div>
			<br>
			<!-- MISE A PRIX -->
			<div class="row mx-auto">
				<div class="col-md-2">
					<label for="miseAPrix">Mise à prix </label>
				</div>
				<div class="col-sm-2">
					<input type="number" aria-label="miseAPrix"
						class="form-control ${fn:contains(erreur,'prixInitial')?'border border-danger':'border border-secondary' }"
						name="miseAPrix" step="1" min="1" required="required" placeholder="Entrez votre prix"
						value="${article.miseAPrix}">
				</div>
			</div>
			<br>
			<!-- DEBUT DE L'ENCHERE -->
			<div class="row mx-auto">
				<div class="col-md-2">
					<label for="debutEnchere">Début de l'enchère :</label>
				</div>
				<div class="col-sm-3">
					<input type="date" aria-label="debutEnchere"
						class="form-control ${erreur.containsKey('datesEncheres')?'border border-danger':'border border-secondary' }"
						name="debutEnchere" required="required"
						value="${article.debutEnchere}">
				</div>
			</div>
			<br>

			<!-- FIN DE L'ENCHERE -->
			<div class="row mx-auto">
				<div class="col-md-2">
					<label for="finEnchere">Fin de l'enchère :</label>
				</div>
				<div class="col-sm-3">
					<input type="date" aria-label="finEnchere"
						class="form-control ${erreur.containsKey('datesEncheres')?'border border-danger':'border border-secondary' }"
						name="finEnchere" required="required"
						value="${article.finEnchere}">
				</div>
			</div>
			<br>

			<!--   RETRAIT  -->
			<fieldset>
				<legend>Retrait</legend>

				<!--   RUE  -->
				<div class="row mx-auto">
					<div class="col-md-2">
						<label for="rue">Rue :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('rue')?'border border-danger':'border border-secondary' }"
								placeholder="Rue" aria-label="rue" name="rue"
								value="${utilisateur.rue }">
						</div>
					</div>
				</div>

				<!--   CODE POSTAL  -->
				<div class="row mx-auto">
					<div class="col-md-2">
						<label for="codePostal">Code postal :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('codePostal')?'border border-danger':'border border-secondary' }"
								placeholder="Code Postal" aria-label="codePostal"
								name="codePostal" value="${utilisateur.codePostal }">
						</div>
					</div>
				</div>
			
				<!--   VILLE  -->
				<div class="row mx-auto">
					<div class="col-md-2">
						<label for="ville">Ville :</label>
					</div>
					<div class="col-sm-4">
						<div class="input-group mb-3">
							<input
								class="form-control ${erreur.containsKey('ville')?'border border-danger':'border border-secondary' }"
								placeholder="Ville" aria-label="ville" name="ville"
								value="${utilisateur.ville }">
						</div>
					</div>
				</div>


			</fieldset>

			<br>
			<c:forEach var="messageErreur" items="${listeErreur.values()}">
				<p>${messageErreur}</p>
			</c:forEach>


			<div class="row mx-auto">
				<div class="mx-auto">
					<button type="submit" class="btn btn-primary">Enregister</button>

					<a href="${pageContext.request.contextPath }/Accueil" class="btn btn-secondary">Annuler</a>
				</div>
			</div>
		</form>
	</div>



</body>

</html>