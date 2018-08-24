<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
     <div class="row">
         <div class="col-lg-12">
             <c:choose>
                <c:when test="${cartSize  == 0}">
                    <p>Votre cadi est vide, commandez quelque chose <a href="<spring:url value="/home"/>">ici</a>.</p>
                </c:when>
                <c:otherwise>
                    <table class="table">
                        <thead class="thead-dark">

                            <th><spring:message code="cart.name"/></th>
                            <th style="width:5%"></th>
                            <th><spring:message code="cart.quantity"/> </th>
                            <th><spring:message code="cart.unit_price"/> </th>
                            <th><spring:message code="cart.total_item_price"/></th>
                            <th></th>
                        </thead>
                        <c:forEach items="${cartItems}" var="item">
                            <tr>
                                <td>${item.getItemName()}</td>
                                <td><a href="<spring:url value="/items?itemId=${item.itemId}"/>"> <img class="card-img-top" width="70" height="40" src="${item.getPictureLink()}" alt=""></a></td>
                                <td>${item.getQuantity()}</td>
                                <td>${item.getItemPrice()}€</td>
                                <td>${item.getItemPrice() * item.getQuantity()}€</td>
                                <td><a href="<spring:url value="/cart/deleteItemFromCart?itemId=${item.itemId}"/>"><button class="btn btn-secondary">Supprimer</button></a></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td><strong><spring:message code="cart.total"/></strong></td>
                            <td><strong>${totalQuantity}</strong></td>
                            <td></td>
                            <td></td>
                            <td><strong>${totalPrice}€</strong></td>

                        </tr>
                    </table>
                    <a href="<spring:url value="/payment"/>"><button class="btn btn-secondary">Payer avec paypal</button></a>
                </c:otherwise>
             </c:choose>
         </div>


     </div>
    </body>
</html>