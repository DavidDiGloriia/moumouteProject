<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <div class="container">
        <form method="POST" action="https://www.sandbox.paypal.com/cgi-bin/webscr">
            <input type="hidden" name="business" value="chaussier.mathieu-facilitator@gmail.com">
            <input type="hidden" name="password" value="ECPP5DPKfPJMDVT1XMa1Ai569i84Kn7747xKXRQq_Imdtzvrr__XKCs-zgGZEaCUfuQrqOOzTlDgXT2V">
            <input type="hidden" name="cert_id" value="AXsj8KRhhKWT2f_T9wGIkR7E68h4TROXvZZuZiN9jl13bJIZwWQCZHpouXYfiktusmQKWDhZ5J_efYhF">
            <input type="hidden" name="cmd" value="_xclick">
            <input type="hidden" name="amount" value="${totalPrice}">
            <input type="hidden" name="item_name" value="${itemsLabel}">
            <input type="hidden" name="currency_code" value="EUR">
            <input type="hidden" name="return" value="http://localhost:8082/moumoute/payment/paymentSucceed">
            <input type="hidden" name="cancel_return" value="http://localhost:8082/moumoute/home">
            <button type="submit"><spring:message code="payment.start_paypal"/> </button>
        </form>
    </div>
</body>
</html>