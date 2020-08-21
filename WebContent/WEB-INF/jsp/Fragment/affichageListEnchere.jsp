<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="affichageEncheres">
			<!--  Affichage de la liste des articles -->
			<c:forEach var="article" items="${listeArticlesAAfficher }">
				<!-- Affichage d'article en vente -->
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<!--  Nom de l'article avec un lien vers detail de l'article -->
						<h5 class="card-title">
							<a
								href="${pageContext.request.contextPath }/DetailVente?idArticle=${article.noArticle}">${article.nomArticle }</a>
						</h5>
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#Suppression">Afficher les détails des
							enchères</button>
						<br>

						<!-- Modal -->
						<div class="modal fade" id="Suppression" tabindex="-1"
							aria-labelledby="SuppresionLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="SuppresionLabel">${article.nomArticle }</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<p>Description : ${article.description}</p>

										<div>
											<p>Catégorie : ${article.categorie.libelle}</p>
										</div>

										<div>
											<!--  TODO Meilleur Offre   -->
											<p>Meilleure offre :</p>
										</div>

										<div>
											<p>Mise à prix : ${article.prixInitial}</p>
										</div>

										<div>
											<p>
												Fin de l'enchère :
												<fmt:parseDate value="${article.finEnchere}"
													pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDate"
													type="both" />
												<fmt:formatDate value="${parsedDate }" dateStyle="long"
													timeStyle="medium" type="both" />
											</p>
										</div>

										<div>
											<p>
												Retrait : <br> Rue : ${utilisateur.rue}<br> Code
												Postal : ${utilisateur.codePostal}<br> Ville :
												${utilisateur.ville}<br>
											</p>
										</div>

										<div>

											<p>Vendeur : ${utilisateur.pseudo}</p>
										</div>
										<form methode="get" >
											<div>
												<label for="proposition">Ma proposition :</label>
												<input type="number" id="proposition" name="proposition" min="0" max="500" step="5" >
												<button type="submit">Enchérir</button>
										</div>
										</form>
									</div>

								</div>
							</div>
						</div>
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

</body>
</html>