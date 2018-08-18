<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="container">
        <form method="POST" action="https://www.sandbox.paypal.com/cgi-bin/webscr">
            <input type="hidden" name="business" value="chaussier.mathieu-facilitator@gmail.com">
            <input type="hidden" name="password" value="ECPP5DPKfPJMDVT1XMa1Ai569i84Kn7747xKXRQq_Imdtzvrr__XKCs-zgGZEaCUfuQrqOOzTlDgXT2V">
            <input type="hidden" name="cert_id" value="AXsj8KRhhKWT2f_T9wGIkR7E68h4TROXvZZuZiN9jl13bJIZwWQCZHpouXYfiktusmQKWDhZ5J_efYhF">
            <input type="hidden" name="cmd" value="_xclick">
            <input type="hidden" name="amount" value="10">
            <%--<c:forEach var="listItemsNames" items="${listItemsNames}">--%>
            <input type="hidden" name="item_name" value="On peut mettre une arrayList de string ici">
            <%--</c:forEach>--%>
            <input type="hidden" name="currency_code" value="EUR">
            <button type="submit">En route sur paypal</button>
        </form>
    </div>
</body>
</html>