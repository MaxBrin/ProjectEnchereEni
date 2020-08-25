<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Détail vente</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />



	<div class="row mx-auto">
		<div class="mx-auto"
			style="width: 600px; margin-bottom: 50px; margin-top: 50px; margin-left: 300px;">
			<h1 style="width: 600px; padding-left: 130px;">Détail vente</h1>
		</div>
	</div>


	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Nom article</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Pseudo"
					aria-label="Pseudo" name="pseudo" value="${article.nomArticle}"
					readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Description</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Pseudo"
					aria-label="Pseudo" name="pseudo" value="${article.description}"
					readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Catégorie</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Pseudo"
					aria-label="Pseudo" name="pseudo"
					value="${article.categorie.libelle}" readonly="readonly">
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Meilleure offre</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="" readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Mise à prix</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Pseudo"
					aria-label="Pseudo" name="pseudo" value="${article.prixInitial}"
					readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Fin de l'enchère</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" placeholder="Pseudo"
					aria-label="Pseudo" name="pseudo"
					value="<fmt:parseDate value="${article.finEnchere}"
								pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="both" />
							<fmt:formatDate value="${parsedDate }" dateStyle="long"
								timeStyle="medium" type="both" /> "
					readonly="readonly">
			</div>
		</div>
	</div>



	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Retrait</label>
		</div>

		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${utilisateur.rue}" readonly="readonly">
			</div>
		</div>
	</div>




	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo"></label>
		</div>

		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${utilisateur.codePostal}" readonly="readonly">
			</div>
		</div>
	</div>


	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo"></label>
		</div>

		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${utilisateur.ville}" readonly="readonly">
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2" style="margin-left: 260px;">
			<label for="pseudo">Vendeur</label>
		</div>
		<div class="col-sm-4">
			<div class="input-group mb-3">
				<input type="text" class="form-control" aria-label="Pseudo"
					name="pseudo" value="${utilisateur.pseudo}" readonly="readonly">
			</div>
		</div>
	</div>


	<form action="${pageContext.request.contextPath }/DetailVente"
		method="post">
		<input type="hidden" name="noArticle" value="${article.noArticle }">
		<div class="row">
			<div class="col-md-2" style="margin-left: 260px;">
				<label for="pseudo">Ma proposition</label>
			</div>
			<div class="col-sm-4">
				<div class="input-group mb-3">
					<input type="number" id="proposition" name="proposition" min="0"
						max="500" step="5">
					<button type="submit">Enchérir</button>
				</div>
			</div>
		</div>
	</form>


</body>
</html>