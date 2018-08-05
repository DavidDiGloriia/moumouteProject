<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<spring:url value='/css/login.css'/>" rel="stylesheet">
    </head>
    <body>
        <div class="log-form">
            <h2>Login to your account</h2>
            <form>
                <input type="text" title="username" placeholder="username" />
                <input type="password" title="username" placeholder="password" />
                <button type="submit" class="btn">Login</button>
                <a class="forgot" href="#">Forgot Username?</a>
            </form>
        </div>
    </body>
</html>