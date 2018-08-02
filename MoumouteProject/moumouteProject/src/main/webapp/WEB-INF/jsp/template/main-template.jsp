<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.css">


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
            <img style="height:40px" src='<spring:url value="/images/logo_header.png"/>'/>
            <div class="container">




                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">

                            <a class="nav-link" href="#">
                                <i class="fa fa-home" style="color:white"></i>
                                <spring:message code="home"/>
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">

                            <a class="nav-link" href="#">
                                <i class="fa fa-sign-in"  style="color:white"></i>
                                <spring:message code="sign_in"/>
                            </a>
                        </li>

                        <li class="nav-item">

                            <a class="nav-link" href="#">
                                <i class="fa fa-shopping-cart"  style="color:white"></i>
                                <spring:message code="basket"/>
                                <span class="badge badge-info">15</span>

                            </a>
                        </li>


                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <spring:message code="flagLanguage"/>
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${langEn}"><span class="flag-icon flag-icon-gb"></span> English (UK)</a>
                                <a class="dropdown-item" href="${langFr}"><span class="flag-icon flag-icon-fr"></span> Français</a>
                            </div>
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
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2018</p>
            </div>
        </footer>

        <!-- Bootstrap core JavaScript -->
        <script src="<spring:url value='/lib/js/jquery.js'/>"></script>
        <script src="<spring:url value='/lib/js/bootstrap.bundle.js'/>"></script>
    </body>
</html>