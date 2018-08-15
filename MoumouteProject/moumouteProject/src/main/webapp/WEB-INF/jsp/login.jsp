<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<spring:url value='/css/login.css'/>" rel="stylesheet">
    </head>
    <body>
        <div class="log-form">
            <h2><spring:message code="login.title"/></h2>
            <form:form  id="loginForm"
                        method="post"
                        modelAttribute="user">

                <spring:message code="login.username" var="usernameMsg"/>
                <form:input path="username" type="text" placeholder="${usernameMsg}"/>
                <div class="display-error">
                    <form:errors path="username"/>
                </div>

                <spring:message code="login.password" var="passwordMsg"/>
                <form:input path="password" type="password" placeholder="${passwordMsg}"/>
                <div class="display-error">
                    <form:errors path="password"/>
                </div>

                <form:button class="btn"><spring:message code="login.login_btn"/></form:button>
                <a class="register" href="<spring:url value="/register"/>"><spring:message code="login.register"/></a>
                <div class="display-error margin-top">
                    <c:if test="${errorMessage}"><spring:message code="login.fail"/></c:if>
                </div>
            </form:form>
        </div>
    </body>
</html>