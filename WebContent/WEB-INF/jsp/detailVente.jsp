<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/Fragment/StyleCommun.css">


<title>Détail vente</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />


	<!--  TITRE  -->
	<div class="row mx-auto">
		<div class="mx-auto">
			<h1>Détail vente</h1>
		</div>
	</div>

	<!--  NOM  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="nomArticle">Nom article</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="nomArticle"
					value="${article.nomArticle}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  DESCRIPTION  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="description">Description</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="description"
					value="${article.description}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  CATEGORIE  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="categorie">Catégorie</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="categorie"
					value="${article.categorie.libelle}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  MEILLEUR OFFRE  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="meilleureOffre">Meilleure offre</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="meilleureOffre"
					value="" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  MISE A PRIX  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="miseAPrix">Mise à prix</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="miseAPrix"
					value="${article.prixInitial}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  DATE DE FIN DE L'ENCHERE  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="finEnchere">Fin de l'enchère</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<!--   FORMATAGE DE LA DATE POUR FAIRE UN AFFICHAGE DANS CE STYLE 20 Aout 2020 10:30:25 -->
				<input type="text" class="form-control" aria-label="finEnchere"
					value="<fmt:parseDate value="${article.finEnchere}"
								pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="both" />
							<fmt:formatDate value="${parsedDate }" dateStyle="long"
								timeStyle="medium" type="both" /> "
					readonly="readonly">
			</div>
		</div>
	</div>


	<!--  AFFICHAGE DU RETRAIT DE L'ARTICLE  -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="pseudo">Retrait</label>
		</div>
		<!--  RUE  -->
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${retrait.rue}" readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row mx-auto">

		<!--  CODE POSTAL -->
		<div class="col-sm-4 offset-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${retrait.codePostal}" readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row mx-auto">

		<!--  VILLE  -->
		<div class="col-sm-4 offset-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${retrait.ville}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  PSEUDO DU VENDEUR DE L'ARTICLE -->
	<div class="row mx-auto">
		<div class="col-md-2 offset-sm-2">
			<label for="pseudo">Vendeur</label>
		</div>
		<div class="col-sm-4 ">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${utilisateur.pseudo}" readonly="readonly">
			</div>
		</div>
	</div>

	<!--  FORMULAIRE POUR ENCHERIR  -->
	<form action="${pageContext.request.contextPath }/DetailVente"
		method="post">
		<input type="hidden" name="noArticle" value="${article.noArticle }">
		<div class="row mx-auto">
			<div class="col-md-2 offset-sm-2">
				<label for="pseudo">Ma proposition</label>
			</div>
			<div class="col-md-4">
				<div class="input-group mb-3">
					<input type="number" id="proposition" name="proposition" min="0"
						max="500" step="5">
					<button type="submit" class="btn btn-primary">Enchérir</button>
				</div>
			</div>
		</div>
	</form>




</body>
</html>