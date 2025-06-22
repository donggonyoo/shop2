<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세 보기</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .product-img {
            max-height: 400px;
            object-fit: cover;
            width: 100%;
        }
        .card {
            border: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-cart {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-cart:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
        .container {
            max-width: 800px;
        }
    </style>
</head>
<body>
    <div class="container py-5">
        <h2 class="text-center mb-4">상품 상세 보기</h2>
        <div class="card">
            <div class="row g-0">
                <div class="col-md-6">
                    <img src="../img/${item.pictureUrl}" class="product-img img-fluid rounded-start" alt="${item.name}">
                </div>
                <div class="col-md-6">
                    <div class="card-body">
                        <h5 class="card-title">${item.name}</h5>
                        <p class="card-text"><strong>가격:</strong> ${item.price}원</p>
                        <p class="card-text"><strong>상품설명:</strong> ${item.description}</p>
                        <form:form modelAttribute="ItemAddDto" action="/cart/cartAdd" class="mt-4">
                            <input type="hidden" name="id" value="${item.id}">
                            <div class="row g-2 align-items-center">
                                <div class="col-auto">
                                    <label for="quantity" class="form-label">수량:</label>
                                    <select name="quantity" id="quantity" class="form-select">
                                        <c:forEach begin="1" end="10" var="i">
                                            <option value="${i}">${i}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-auto">
                                    <button type="submit" class="btn btn-cart text-white">장바구니</button>
                                </div>
                                <div class="col-auto">
                                    <a href="list" class="btn btn-secondary">상품목록</a>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and Popper.js -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>