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
        <link href="<spring:url value='/lib/css/bootstrap.css'/>" rel="stylesheet">
        <link href="<spring:url value='/css/main-template.css'/>" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

        <title>${title}</title>
        <spring:url var="langFr" value="">
            <spring:param name="lang" value="fr"/>
        </spring:url>
        <spring:url var="langEn" value="">
            <spring:param name="lang" value="en"/>
        </spring:url>

        <!--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
        <!-- Bootstrap core JavaScript -->
        <script src="<spring:url value='/lib/js/jquery.js'/>"></script>
        <script src="<spring:url value='/lib/js/bootstrap.bundle.js'/>"></script>
        <script>
            $(document).ready(function(e){
                $('.search-panel .dropdown-menu').find('a').click(function(e) {
                    e.preventDefault();
                    var param = $(this).attr("href").replace("#","");
                    var concept = $(this).text();
                    $('.search-panel span#search_concept').text(concept);
                    $('.input-group #search_param').val(param);
                });
            });
        </script>
    </head>

    <body>

    <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <a href="<spring:url value="/"/>"><img style="height:40px" src='<spring:url value="/images/logo_header.png"/>'/></a>

            <div class="row" style="width:50%;margin-left:1%">

                <form:form id="form"
                           method="GET"
                           action="/moumoute/research"
                           modelAttribute="itemToSearch"
                           style="width:100%">

                    <div class="input-group">
                        <div class="input-group-btn search-panel">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"> <span id="search_concept">  <spring:message code="filter_by"/></span>  <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu" role="menu">

                                <c:forEach var="category" items="${categories}">
                                    <li class="dropdown-item"><a href="#${category.id}">${category.categoryName}</a></li>
                                </c:forEach>

                                <li class="divider dropdown-item"></li>
                                <li class="dropdown-item"><a href="#all">  <spring:message code="all"/></a>
                            </ul>
                        </div>

                        <form:input path="category" id="search_param" value="all"  type="hidden" />
                        <spring:message code="search_term" var="search_term"/>
                        <form:input path="wigName" name="x" placeholder="${search_term}" cssClass="form-control" ></form:input><span class="input-group-btn"></span>
                        <form:button class="btn btn-secondary"><span class="glyphicon glyphicon-search"></span></form:button>

                    </div>
                </form:form>
            </div>

            <div class="container" style="margin-right: 5%; margin-right:5% ; width: auto" >
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">

                        <li class="nav-item active ${pageContext.request.requestURI.contains('/home') ? ' active' : ''}"> <!-- ça marche pas mais c'est un truc du genre -->
                            <a class="nav-link" href="<spring:url value="/home"/>">
                                <i class="fa fa-home"></i>
                                <spring:message code="home"/>
                                <!--<span class="sr-only">(current)</span>-->
                            </a>
                        </li>

                        <sec:authorize access="!isAuthenticated()">
                            <li class="nav-item ${pageContext.request.requestURI.contains('/login') ? ' active' : ''}">
                                <a class="nav-link" href="<spring:url value="/login"/>">
                                    <i class="fa fa-sign-in"  style="color:white"></i>
                                    <spring:message code="sign_in"/>
                                </a>
                            </li>
                        </sec:authorize>

                        <sec:authorize access="isAuthenticated()">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <i class="glyphicon glyphicon-user"></i>
                                    <sec:authentication property="principal.username"/>
                                </a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="#"><spring:message code="my_profile"/> </a>
                                    <a class="dropdown-item" href="<spring:url value="/logout"/>"><spring:message code="logout"/> </a>
                                </div>
                            </li>
                        </sec:authorize>

                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/cart"/>">
                                <i class="fa fa-shopping-cart"  style="color:white"></i>
                                <spring:message code="cart"/>
                                <span class="badge badge-info">${cartSize}</span>
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<spring:url value="/about"/>">
                                <i class="fa fa-info-circle"  style="color:white"></i>
                                <spring:message code="about"/>
                            </a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                <spring:message code="flagLanguage"/>
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="${langEn}"><span class="flag-icon flag-icon-gb"></span> <spring:message code="lang_en"/> </a>
                                <a class="dropdown-item" href="${langFr}"><span class="flag-icon flag-icon-fr"></span> <spring:message code="lang_fr"/> </a>
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
    </body>
</html>