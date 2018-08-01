<%-- 
    Document   : CreerNouvelleParti
    Created on : 13 juil. 2018, 15:10:46
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Création d'une nouvelle partie</h1>
        
        <form method="POST">
            <label> Veuillez choisir un nom </label>
            <input type="text" name="nomPartie" /> <br> 
            <input type="submit" value="CREER"/>
            <input type="reset" value="Reset"/>
            
        </form>
        
    </body>
</html>
