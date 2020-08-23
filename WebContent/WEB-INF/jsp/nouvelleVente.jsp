<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
	
	
		<meta charset="utf-8">
	
		<title>Nouvelle vente</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/Erreur.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/styleNouvelleVente.css">
	</head>
	
<div class="fond">	
	<body>
		<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>
	
	
	

		
		<div id="image">
		</div>
		
	<div>
		<h1>Nouvelle Vente</h1>
	</div>	
		
	<div class="article">
		
		<form method="post" action="NouvelleVente">
			<!--  Initialisation Message Erreur  -->
		<c:set var="erreur" value="${listeErreur}" />
		
		<div>
			<label for="nomArticle">Article : </label>
			<input type="text" name="nomArticle" id="nomArticle" class="${fn:contains( }"required="required">
		</div>
		<br>
		<div>
			<label for="description" class="labeldescription">Description :</label>
			<textarea rows="5" cols="15" id="description" name="description" class="inputdescription" required="required" ></textarea>
		</div>	
		<br><br><br><br><br>
		<div>
			<label for="categorie">Catégorie</label>
			<select id="categorie" name="categorie" required="required">
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtements</option>
				<option value="4">Sport & Loisirs</option>
			</select>
		</div>
		<br>
		<div>	
			<p>Photo de l'article : </p> <a href=""></a>
			
		<div>
			<label for="miseAPrix">Mise à prix </label>
			<input type="number" class="inputMiseAPrix" name="miseAPrix" step="1" min="1" required="required" >
		</div>
		<br>
		<div>
			<label for="debutEnchere">Début de l'enchère </label>
			<input type="date"  name="debutEnchere" id="debutEnchere" required="required">
		</div>
		<br>
		<div>
			<label for="finEnchere">Fin de l'enchère</label>
			<input type="date" name="finEnchere" id="finEnchere" required="required">
		</div>	
		<br>
		<div class="Retrait">
			<fieldset>
			
			
				<legend>Retrait</legend>
			
			<br>
			<div>	
				<label for="rue">Rue :</label>
				<input type="text" id="rue" name="rue" value="${utilisateur.rue}" required="required">
			</div>
			<br>
			<div>	
				<label for="codePostal">Code postal :</label>
				<input type="text" id="codePostal" name="codePostal" value="${utilisateur.codePostal}" required="required">
			</div>
			<br>
			<div>	
				<label for="ville">Ville :</label>
				
					<input type="text" id="ville" name="ville" value="${utilisateur.ville}" required="required">
				
			</div>
			</fieldset>
		</div>
		<br>
		<div>
			<button type="submit">Enregister</button>
		
			<a href="">Annuler</a>
		</div>
			
		</form>
	</div>	
		
		
		
	</body>
</div>	
</html>