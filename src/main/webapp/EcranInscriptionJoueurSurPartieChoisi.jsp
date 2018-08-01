<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title> page de démarage</title>
        <link rel="stylesheet" type="text/css" href="styleB.css">
        <meta charset="utf-8">
    </head>

    <body>
        <div class="main">
            <div class="titre_tableau"> 
                Joueurs de cette partie ( je veux afficher ici le numero de la partie et son nom )
                ${dolar}
                <br><br>
            </div>
            <div class="mon_tableau">
                <c:forEach items="${joueursTable}" var="parAct">
                    nom du joueur     <p> ${parAct.pseudo} </p>  
                    <!-- je dois recuperer l'id de la pârtie choisis et l'envoyer dans ma servlet-->
                    <a href="EcranFinal"> <input type="submit" value="demarrer partie" /> </a>
                    <a href="listerParties"><input type="submit" value="Quitter" /> </a>
                    <br> 
                </c:forEach>
                <!-- creer fonction qui recupere les joueur inscris a une partie et qui propose 
                a chacun de demarer la partie  -->  
            </div>

            <div class="Demarrerpartie">
                <button type="button" value="rejoindre"> <a href="file:///C:/Users/Administrateur/Desktop/Documentation_java/page3.html"> Demarer partie  </button> </a>
                <button type="button" value="rejoindre"> <a href="file:///C:/Users/Administrateur/Desktop/Documentation_java/brouillion.html"> quitter partie </button> </a>
            </div>

    </body>

</html>