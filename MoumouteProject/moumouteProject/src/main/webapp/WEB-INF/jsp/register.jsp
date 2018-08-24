<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<spring:url value='/css/register.css'/>" rel="stylesheet">
    </head>
    <body>
        <div class="reg-form">
            <h2><spring:message code="register.title"/></h2>

            <form:form  id="registrationForm"
                        method="post"
                        action="/moumoute/register"
                        modelAttribute="user">

                <spring:message code="register.username" var="usernameMsg"/>
                <form:input type="text" path="username" placeholder="${usernameMsg}"/>
                <div class="display-error">
                    <form:errors path="username"/>
                    <c:if test="${wrongUsername}"><spring:message code="register.username_used"/></c:if>
                </div>

                <spring:message code="register.lastname" var="lastnameMsg"/>
                <form:input type="text" path="lastname" placeholder="${lastnameMsg}"/>
                <div class="display-error">
                    <form:errors path="lastname"/>
                </div>

                <spring:message code="register.firstname" var="firstnameMsg"/>
                <form:input type="text" path="firstname" placeholder="${firstnameMsg}"/>
                <div class="display-error">
                    <form:errors path="firstname"/>
                </div>

                <spring:message code="register.email" var="emailMsg"/>
                <form:input type="text" path="email" placeholder="${emailMsg}"/>
                <div class="display-error">
                    <form:errors path="email"/>
                    <c:if test="${wrongEmail}"><spring:message code="register.email_used"/></c:if>
                </div>

                <spring:message code="register.password" var="passwordMsg"/>
                <form:input type="password" path="password" placeholder="${passwordMsg}"/>
                <div class="display-error">
                    <form:errors path="password"/>
                </div>

                <spring:message code="register.confirm_password" var="confirmPasswordMsg"/>
                <form:input type="password" path="confirmPassword" placeholder="${confirmPasswordMsg}"/>
                <div class="display-error">
                    <form:errors path="confirmPassword"/>
                    <c:if test="${wrongPassword}"><spring:message code="register.password_not_match"/></c:if>
                </div>

                <spring:message code="register.street" var="streetMsg"/>
                <form:input type="text" path="street" placeholder="${streetMsg}"/>
                <div class="display-error">
                    <form:errors path="street"/>
                </div>

                <spring:message code="register.postal_code" var="postalCodeMsg"/>
                <form:input type="text" path="postalCode" placeholder="${postalCodeMsg}"/>
                <div class="display-error">
                    <form:errors path="postalCode"/>
                </div>

                <spring:message code="register.city" var="cityMsg"/>
                <form:input type="text" path="city" placeholder="${cityMsg}"/>
                <div class="display-error">
                    <form:errors path="city"/>
                </div>

                <spring:message code="register.country" var="countryMsg"/>
                <form:input type="text" path="country" placeholder="${countryMsg}"/>
                <div class="display-error">
                    <form:errors path="country"/>
                </div>

                <spring:message code="register.phone_number" var="phoneNumberMsg"/>
                <form:input path="phoneNumber" placeholder="${phoneNumberMsg} (*)"/>
                <div class="display-error">
                    <form:errors path="phoneNumber"/>
                </div>

                <form:button class="btn"><spring:message code="register.register_btn"/></form:button>
                <a class="login" href="<spring:url value="/login"/>"><spring:message code="register.login"/></a>
                <div class="display-error">
                    <c:if test="${errorOccurred}"><spring:message code="register.error_occurred"/></c:if>
                </div>
            </form:form>
        </div>
    </body>
</html>