<%-- 
    Document   : login
    Created on : 16 juil. 2018, 12:31:59
    Author     : Administrateur
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LOGIN </h1>
        <form method="POST"> 
            <label>Le pseudo</label><input type="text" name="pseudo" />
            <label>AVATAR</label><input type="text" name="avatar" />

            <input type="submit" value="creer" />

            <input type="reset" value="annuler" />
        </form>
    </body>
</html>
