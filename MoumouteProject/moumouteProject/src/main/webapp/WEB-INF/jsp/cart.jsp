<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <c:choose>
            <c:when test="${cartSize  == 0}">
                <p>Votre cadi est vide, commandez quelque chose <a href="<spring:url value="/home"/>">ici</a>.</p>
            </c:when>
            <c:otherwise>
                <table>
                    <tr>
                        <th><spring:message code="cart.name"/></th>
                        <th><spring:message code="cart.quantity"/></th>
                        <th><spring:message code="cart.unit_price"/></th>
                        <th><spring:message code="cart.total_item_price"/></th>
                        <th><spring:message code="cart.delete"/></th>
                    </tr>
                    <c:forEach items="${cartItems}" var="item">
                        <tr>
                            <td>${item.getItemName()}</td>
                            <td>${item.getQuantity()}</td>
                            <td>${item.getItemPrice()}</td>
                            <td>${item.getItemPrice() * item.getQuantity()}</td>
                            <td>X</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><strong><spring:message code="cart.total"/></strong></td>
                        <td><strong>${totalPrice}</strong></td>
                        <td></td>
                    </tr>
                </table>
                <a href="<spring:url value="/payment"/>"><button>Payer avec paypal</button></a>
            </c:otherwise>
        </c:choose>
    </body>
</html>