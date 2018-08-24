<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <style>
        .card-title
        {
            font-size : 200%;
            color : darkslateblue;
        }
        .money
        {
            color:darkred;
            font-size:150%;
        }
    </style>
    <section>
        <div class="container py-3">
            <div class="card">
                <div class="row ">
                    <div class="col-md-4">
                        <a href="#"><img class="card-img-top" width="700" height="400" src="${item.pictureLink}" alt=""></a>
                    </div>
                    <div class="col-md-8 px-3">
                        <div class="card-block px-3">
                            <h4 class="card-title">${item.wigName}</h4>
                            <p class="card-text">${item.description}</p>
                            <div class="money">
                                <c:choose>
                                    <c:when test="${not empty item.promotion}">
                                        <s>${item.price}€</s>
                                        ${item.reductedPrice}€
                                        ( -<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.promotion.percRed}"/>%)
                                    </c:when>
                                    <c:otherwise>
                                        ${item.price}€
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <form:form id="form"
                                       method="POST"
                                       action="/moumoute/cart/addItemToCart"
                                       modelAttribute="itemToAdd"
                                       style="width:100%">

                                <form:input path="quantity" id="search_param" min="1" type="number" value="1"/>
                                <form:input path="itemId" id="search_param" value="${item.id}"  type="hidden" />
                                <form:button class="btn btn-secondary"> <spring:message code="add_to_cart"/></span> <span class="glyphicon glyphicon-shopping-cart" style="border-left:3px"></form:button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>

</body>
</html>