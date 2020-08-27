<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Erreur de connexion</title>

<!-- Bootstrap CSS -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bootstrap/4.5.2/css/bootstrap.css">
	
</head>
<body>
	<div class="container">
		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
				<h1>ENI ENCHERE</h1>
			</div>
		</div>

		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
				<h3 class="text-danger ">Nous sommes désolés mais nous rencontrons actuellement des problèmes de serveurs.</h3>
			</div>
		</div>
		<div class="row mx-auto">
			<div class="mx-auto" style="width: 500px;">
		<a href="${pageContext.request.contextPath }/Accueil" class="btn btn-primary"> Réessayer</a>
			</div>
		</div>
	</div>
</body>
</html>