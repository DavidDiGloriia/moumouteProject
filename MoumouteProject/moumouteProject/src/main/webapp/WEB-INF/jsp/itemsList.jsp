<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/importTags.jsp"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>


<body>

<div class="row">

    <c:forEach var="item" items="${itemsList}">

        <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
                <a href="#"><img class="card-img-top" width="700" height="400" src="${item.pictureLink}" alt=""></a>
                <div class="card-body">
                    <h4 class="card-title">
                        <a href="#">${item.wigName}</a>
                    </h4>
                    <h5>${item.EVATPrice}</h5>
                    <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur! Lorem ipsum dolor sit amet.</p>
                </div>
                <div class="card-footer">
                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                </div>
            </div>
        </div>

    </c:forEach>



</div>







</body>
</html>