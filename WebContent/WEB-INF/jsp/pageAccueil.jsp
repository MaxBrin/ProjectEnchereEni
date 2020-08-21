<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Liste des enchères</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/stylePageAccueil.css">
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Architects+Daughter&display=swap"
	rel="stylesheet">


</head>

<body>
	<jsp:include page="/WEB-INF/jsp/Fragment/enTete.jsp" />
	<jsp:include page="/WEB-INF/jsp/Fragment/affichageFiltreEnchere.jsp" />
	<jsp:include page="/WEB-INF/jsp/Fragment/affichageListEnchere.jsp" />
		
	


</body>
</html>