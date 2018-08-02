<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
        <link href="CSS/premier.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Nosifer" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    logo
                </div>
                <div class="col-lg-7">
                    <div id="titreJeu"> Ma Partie JPA</div>
                </div>
            </div>
            <div class="row">
                <p class="text">Partie Disponible</p>
            </div>
            <div class="row">
                <div class="col-lg-12">

                    <c:forEach items="${listePartie}" var="parAct">
                        <div id="lignePartie">
                            <button type="button" class="btn btn-outline-warning btnRejoindrePartie">
                                <a href="Login?id=${parAct.id}"> REJOINDRE </a></button>
                            <button type="button" class="btn btn-outline-warning war"> ${parAct.nom} </button>   
                        </div> 
                    </c:forEach>
                    <a href="<c:url value="/CrerNouvellePartie"/>">Créer nouvelle partie </a>    
                </div>    

            </div>
         <!--<button type="button" class="btn btn-outline-warning"><a href="Login?id=${parAct.id}"> 
         REJOINDRE </a></button>   
        </div>
        <div class="row">
            Footer
        </div>
    </div>
            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    </body>
</html>