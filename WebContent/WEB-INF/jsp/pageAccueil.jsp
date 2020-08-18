<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
	<meta charset="UTF-8">
	<title>Liste des enchères</title>
	
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
	
<body>
	
	
	
	<a href="/ProjectEnchereEni/CreationCompte">S'inscrire</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Se connecter</a>
	
	
	
	<a href="/ProjectEnchereEni/CreationCompte">Enchères</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Vendre un article</a>
	<br>
	<a href="/ProjectEnchereEni/CreationCompte">Mon profil</a><br>
	<br>
	<a href="/ProjectEnchereEni/Connexion">Déconnexion</a>
	
	
		
	<h1>Liste des enchères</h1>
	
	<form action="">
	<label for="filtre" >Filtres</label>
	<input type="texte" placeholder="Le nom de l'article contient" id="filtre" >
	
	
	
	
	<p>Catégorie :</p>
	
	<select name="categorie" id="categorie">
		
		<option value="Informatique" name="categorie">Informatique</option>
		<option value="Ammeublement" name="categorie">Ammeublement</option>	
		<option value="Vêtement" name="categorie">Vêtement</option>
		<option value="Sport & Loisirs" name="categorie">Sport & Loisirs</option>

	</select>
	
	
	
	
	
	<div>
		<input type="radio" name="choixAchatOuVente">Achats<br>
		<input type="radio" name="choixAchatOuVente">Mes ventes<br>
	</div>
	
	
	<div>
		<input type="checkbox" name="encheresOuvertes">Enchères ouvertes<br>
		<input type="checkbox" name="mesEncheres">Mes enchères<br>
		<input type="checkbox" name="encheresRemportees">Mes enchères remportées<br>
	</div>
	
	<br><br>
	
	<div>
	
	
	<div>
		<input type="checkbox" name="ventesEnCours">Mes ventes en cours<br>
		<input type="checkbox" name="ventesNonDebutess">Ventes non débutées<br>
		<input type="checkbox" name="ventesTerminees">Ventes terminées<br>
	</div>
	
	<input type="submit" value="Rechercher"><br><br>
	<br>	
	
	
	
	
	
	
	
	
	<textarea name="nom de l'article" id="" cols="40" rows="5">
	PC Gamer pour travailler 
	Prix :
	Fin de l'enchère :
	Vendeur :
	</textarea>	

	<textarea name="nom de l'article" id="" cols="40" rows="5">
	Rocket stove pour riz et pâtes 
	Prix :
	Fin de l'enchère :
	Vendeur :
	</textarea>	
	
	</body>
</html>