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
                    <p><spring:message code="empty_cart"></spring:message> <a href="<spring:url value="/home"/>"><spring:message code="right_here"></spring:message></a>.</p>
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
                                <td>
                                    <form:form id="form"
                                               method="POST"
                                               action="/moumoute/cart/updateItemQuantity"
                                               modelAttribute="itemToUpdate">
                                        <form:input path="idItem" value="${item.itemId}"  type="hidden" ></form:input>
                                        <form:input path="newQuantity" value="${item.quantity}"  type="number"  min="1" max="10" ></form:input>
                                        <form:button class="btn btn-secondary"><spring:message code="update"></spring:message></form:button>
                                    </form:form>
                                </td>
                                <td> <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.getItemPrice()}"/>€</td>
                                <td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.getItemPrice() * item.getQuantity() }"/>€</td>
                                <td><a href="<spring:url value="/cart/deleteItemFromCart?itemId=${item.itemId}"/>"><button class="btn btn-secondary"><spring:message code="delete"/></button></a></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td><strong><spring:message code="cart.total"/></strong></td>
                            <td></td>
                            <td><strong>${totalQuantity}</strong></td>
                            <td></td>
                            <td><strong>${totalPrice}€</strong></td>

                        </tr>
                    </table>
                    <a href="<spring:url value="/payment"/>"><button class="btn btn-secondary"><spring:message code="pay_with_paypal"/></button></a>
                </c:otherwise>
             </c:choose>
         </div>
     </div>
    </body>
</html>