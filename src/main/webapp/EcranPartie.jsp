<%-- 
    Document   : EcranPartie
    Created on : 16 juil. 2018, 15:31:17
    Author     : Administrateur
 Cette ecran va contenir :
  --> la liste des joueurs de la partie avec leur cartes et le nombre de cartes 
  --> et pour le joueur sa va afficher le conrtenu de ses carte 
  --> pour la partie joueur actuelle on devra faire avec les session pour changer l'affichage 
    d'un joueur a autre selon son etat de jeu deans la partie 

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./CSS/5point1.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Permanent+Marker" rel="stylesheet">
        <link href="url(https://fonts.googleapis.com/css?family=Denk+One)" rel="stylesheet">
        <title>Partie en cours</title>
    </head>
    <body>
        <div class="boite">    
            <header> 
                <div class="image">
                <img class="logo"src="CSS/2.GIF" alt=""/>
                </div>
                <h1> Ma sorciere JPA </h1>
                <!-- une image Logo -->
            </header>

            <nav>
            </nav>
            <section>

                <div class="joueursEnemi">
                    <c:forEach items="${MesJoueursDeLaPartie}" var="joueurACT">
                        <div class="Joueur">  
                            <p> PSEUDO : ${joueurACT.pseudo}</p>
                            <p> IL A : ${joueurACT.getCartes().size()} CARTES</p>
                        </div>
                    </c:forEach>

                </div>
                <div class="milieu">
                    
                    <span><a><input type="submit" value="LANCER SORT"/></a></span>

                    <span><input type="submit" value="PASSER MON TOUR" /></a></span>
                </div>
                <div class="player">
                    <p> ${JoueurAlaMain.getPseudo()} </p>
                    <p> ${JoueurAlaMain.getAvatar()} </p>
                    <c:forEach items="${JoueurAlaMain.getCartes()}" var="carte">
                        <p> ${carte.getIngredient()} une oulalalalalalalalal </p>
                    </c:forEach>
                </div>
            </section>

            <footer>            
            </footer>
        </div>                             
    </body>
</html>
