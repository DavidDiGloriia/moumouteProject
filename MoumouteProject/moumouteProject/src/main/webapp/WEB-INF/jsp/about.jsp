<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <H1><spring:message code="about.title"/></H1>
            </div>
            <div class="row">
                <div class="col-xs-offset-2 col-sm-8 text-justify">
                    <spring:message code="about.web_site_description"/>
                </div>
            </div>
            <div class="row">
                <H1><spring:message code="about.contact_us"/></H1>
            </div>
            <div class="row text-center">
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 img-responsive">
                    <a href="https://www.facebook.com/"><img src='<spring:url value="images/facebook.png"/>' width="25%"/></a>
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 img-responsive">
                    <a href="mailto:moumoute@gmail.com"><img src='<spring:url value="images/gmail.png"/>' width="25%"/></a>
                </div>
                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 img-responsive">
                    <a href="https://twitter.com/"><img src='<spring:url value="images/twitter.png"/>' width="25%"/></a>
                </div>
            </div>
        </div>
    </body>
</html>