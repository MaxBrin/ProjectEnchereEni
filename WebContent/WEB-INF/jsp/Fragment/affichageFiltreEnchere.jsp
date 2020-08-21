<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="corps">
		<h1 id="titre">LISTE DES ENCHERES</h1>
		<div class="formulaire">
			<form action="${pageContext.request.contextPath }/Accueil"
				method="post">
				<label for="filtre" class="labelFiltre">Filtres</label> <input
					type="texte" placeholder="Ex : voiture, console" id="filtre"
					name="rechercherArticle">

				<p>Catégorie :</p>

				<select name="categorie" id="categorie">

					<option value="0" name="toutesCategories">Toutes</option>

					<c:forEach var="categorie" items="${listeCategories}">
						<option value="${categorie.noCategorie}"
							name="${categorie.libelle}">${categorie.libelle}</option>
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
	</div>
</body>
</html>