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
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>

	
	
			<div class="row mx-auto">
					<div class="mx-auto" style="width: 600px; margin-bottom: 50px; margin-top: 50px; margin-left: 300px;">
						<h1 style="width: 600px; padding-left: 130px;">Détail vente</h1>
					</div>
			</div>
	
	
	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="nomArticle">Nom article</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="nomArticle"
							aria-label="nomArticle" name="nomArticle" value="${article.nomArticle}" readonly="readonly">
					</div>
				</div>
	</div>
	
		<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="description">Description</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="description"
							aria-label="description" name="description" value="${article.description}" readonly="readonly">
					</div>
				</div>
		</div>
	
	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="categorie">Catégorie</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="categorie"
							aria-label="categorie" name="categorie" value="${article.categorie.libelle}" readonly="readonly">
					</div>
				</div>
		</div>
	
	
	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="meilleurOffre">Meilleure offre</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							aria-label="meilleurOffre" name="meilleurOffre" value="" readonly="readonly">
					</div>
				</div>
		</div>
	
	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="miseAprix">Mise à prix</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" placeholder="miseAprix"
							aria-label="miseAprix" name="miseAprix" value="${article.prixInitial}" readonly="readonly">
					</div>
				</div>
	</div>

	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="finEnchere">Fin de l'enchère</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
				
						<input type="text" class="form-control"
							aria-label="finEnchere" name="finEnchere" value="<fmt:parseDate value="${article.finEnchere}"
								pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate" type="both" />
							<fmt:formatDate value="${parsedDate }" dateStyle="long"
								timeStyle="medium" type="both" /> "readonly="readonly">
					</div>
				</div>
	</div>



	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Retrait</label>
				</div>
			
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							aria-label="Pseudo" name="pseudo" value="${utilisateur.rue}" readonly="readonly">
					</div>
				</div>
	</div>
	
	
	
	
		<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo"></label>
				</div>
			
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							aria-label="Pseudo" name="pseudo" value="${utilisateur.codePostal}" readonly="readonly">
					</div>
				</div>
	</div>


		<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo"></label>
				</div>
			
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control"
							aria-label="Pseudo" name="pseudo" value="${utilisateur.ville}" readonly="readonly">
					</div>
				</div>
	</div>

	<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Vendeur</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="text" class="form-control" 
							aria-label="Pseudo" name="pseudo" value="${utilisateur.pseudo}" readonly="readonly">
					</div>
				</div>
	</div>
	
		<div class="row">
				<div class="col-md-2" style="margin-left: 260px;">
					<label for="pseudo">Ma proposition</label>
				</div>
				<div class="col-sm-4">
					<div class="input-group mb-3">
						<input type="number" id="proposition" name="proposition" min="1" max="500" step="1" placeholder="Enchérissez" style="width: 150px;">
						<button type="submit">Enchérir</button>
					</div>
				</div>
	</div>

</body>
</html>