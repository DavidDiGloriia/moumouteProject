<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Mangeons le mulet !</title>

        <!-- Bootstrap core CSS -->
        <link href="<spring:url value='/lib/css/bootstrap.css'/>" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="<spring:url value='/css/main-template.css'/>" rel="stylesheet">

        <spring:url var="langFr" value="">
            <spring:param name="lang" value="fr"/>
        </spring:url>
        <spring:url var="langEn" value="">
            <spring:param name="lang" value="en"/>
        </spring:url>
    </head>
    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Services</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                        </li>
                        <li>
                            <a href="${langFr}"><p>Français</p></a>
                        </li>
                        <li>
                            <a href="${langEn}">Anglais</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <tiles:insertAttribute name = "main-content" />
        </div>



        <!-- Footer -->
        <footer class="py-5 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="<spring:url value='/lib/js/jquery.js'/>"></script>
        <script src="<spring:url value='/lib/js/bootstrap.bundle.js'/>"></script>
    </body>
</html>