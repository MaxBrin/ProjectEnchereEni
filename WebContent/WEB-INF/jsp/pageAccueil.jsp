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
	
	<p>Filtres : </p>
	
	<label for="Filtre :"></label>
	<input type="texte" placeholder="Le nom de l'article contient" >
	
	
	
	
	<p>Catégorie :</p>
	
	<select name="gender" id="">
	<option value="Toutes" name="gender">Toutes</option>
	<option value="" name="gender"></option>
	</select>
	
	
	<input type="submit" value="Rechercher"><br><br>
	
	
	<div>
	<label for="test"><input type="radio">Achats</label><br>
	
	<label for="color">
	<input type="checkbox" name="color" value="bleu">Enchères ouvertes<br>
	<input type="checkbox" name="color" value="bleu">Mes enchères<br>
	<input type="checkbox" name="color" value="bleu">Mes enchères remportées
	</label><br>
	</div>
	
	<br><br>
	
	<div>
	<label for="test"><input type="radio">Mes ventes</label><br>
	
	<label for="color">
	<input type="checkbox" name="color" value="bleu">Mes ventes en cours<br>
	<input type="checkbox" name="color" value="bleu">Ventes non débutées<br>
	<input type="checkbox" name="color" value="bleu">Ventes terminées<br>
	</label>
	</div>
	
	
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