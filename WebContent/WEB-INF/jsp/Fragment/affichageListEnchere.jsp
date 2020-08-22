<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<!--  Affichage de la liste des articles -->
		<c:forEach var="article" items="${listeArticlesAAfficher }">
			<div class="row">
				<div class="col-md-3">
					<!-- Affichage d'article en vente -->
					<div class="card" style="width: 18rem;">
						<div class="card-body">
							<!--  Nom de l'article avec un lien vers detail de l'article -->
							<h5 class="card-title">
								<a
									href="${pageContext.request.contextPath }/DetailVente?idArticle=${article.noArticle}">${article.nomArticle }</a>
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