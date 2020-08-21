<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Affichage profil</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
	<link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp"/>




	<div>
		<p>Pseudo :</p>
	</div>
	
	<div>
		<p>Nom :</p>
	</div>

	<div>
		<p>Prénom :</p>
	</div>

	<div>
		<p>Email :</p>
	</div>

	<div>
		<p>Téléphone :</p>
	</div>
	
	<div>
		<p>Rue :</p>
	</div>
	
	<div>
		<p>Code postal :</p>
	</div>
	
	<div>
		<p>Ville :</p>
	</div>	
	
<a href="">Modifier</a>


	
</body>
</html>