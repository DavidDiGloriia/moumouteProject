<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <fmt:setLocale value = "en_US"/>

    <style>
        .money
        {
            color:darkred;
            font-size:150%;
        }

        .wigName
        {
            font-size:200%;
        }
    </style>
</head>


<body>

<div class="row">

    <c:forEach var="item" items="${itemsList}">

        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="<spring:url value="/items?itemId=${item.id}"/>"> <img class="card-img-top" width="700" height="400" src="${item.pictureLink}" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a class="wigName" href="<spring:url value="/items?itemId=${item.id}"/>"> ${item.wigName}</a>
                          <br>

                        <div class="money">

                            <c:choose>
                                <c:when test="${not empty item.promotion}">
                                    <s><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.EVATPrice*(1+(item.VATRate/100))}"/>€</s>
                                    <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${(item.EVATPrice*(1+(item.VATRate/100)))*(1- (item.promotion.percRed/100))}"/>€
                                    ( -<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.promotion.percRed}"/>%)
                                </c:when>
                                <c:otherwise>
                                    <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.EVATPrice*(1+(item.VATRate/100))}"/>€

                                </c:otherwise>
                            </c:choose>
                       </div>
                    </h4>
                    <p class="card-text">${item.description}</p>
                </div>
                <div class="card-footer">
                    <small class="text-muted"></small>
                </div>
            </div>
        </div>

    </c:forEach>



</div>







</body>
</html>