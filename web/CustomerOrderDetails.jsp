<%-- 
    Document   : CustomerOrderDetails
    Created on : Jun 22, 2021, 11:52:19 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CustomerOrderDetails.css">
    </head>
    <body>
        <!--Header-->
        <%@include file="header.jsp" %>
        
        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="" class="col-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-9" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-3">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <c:set var="productCategoryList" value="${requestScope.PRODUCT_CATEGORY}"/>
                        <c:forEach var="productCategory" items="${productCategoryList}">
                        <div class="category">
                            <a href="">${productCategory.name}</a>
                        </div>
                        </c:forEach>
                    </div>
                </div>

                <!--Main content-->
                <c:set var="order" value="${requestScope.ORDER_DETAIL}"/>
                <div class="main-content container col-10">
                    <h1>Your Order</h1>
                    <div class="container order-details-wrapper col" style="padding: 1em 2em 2em 2em">
                        <div class="row d-flex justify-content-between" id="order-basic-info">
                            <div class="col-4">
                                <h2 style="font-weight: 600; line-height: 1em;">ID: ${order.orderId}</h2>
                                <span style="font-weight: 500;">${order.orderedDate}</span>
                            </div>
                            <div class="col-2 justify-content-center" id="order-status">
                                <c:choose>
                                    <c:when test="${order.status == 0}">Submitted</c:when>
                                    <c:when test="${order.status == 1}">Confirmed</c:when>
                                    <c:when test="${order.status == 2}">Completed</c:when>
                                </c:choose>
                            </div>
                        </div>
                        <c:set var="details" value="${order.details}"/>
                        <c:forEach var="detail" items="${details}">
                            <div class="item-wrapper row">
                                <img src="img/${detail.thumbnail}" alt="product thumbnail" class="col-2 align-self-stretch">
                                <div class="col-5">
                                    <h4>${detail.productName}</h4>
                                    <h6>
                                        <c:choose>
                                            <c:when test="${detail.salePrice != 0}">Unit price: $${detail.salePrice}</c:when>
                                            <c:otherwise>Unit price: $${detail.listPrice}</c:otherwise>
                                        </c:choose>
                                    </h6>
                                    <h6>Quantity: ${detail.quantity}</h6>
                                </div>
                                <div class="col-5 d-flex flex-column justify-content-between align-items-end">
                                    <h4>$${detail.detailTotal}</h4>
                                    <div>
                                        <button class="btn-feedback" onclick="location.href='custFeedback?productID=${detail.productId}'">FEEDBACK</button>
                                        <button class="btn-buy-again" onclick="location.href='viewProductDetails?productID=${detail.productId}'">BUY AGAIN</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>        
                        
                        
                        <div class="d-flex flex-row justify-content-between">
                            <c:if test="${order.status == 0}">
                                <div class="btn-cancel-update">
                                    <button id="btn-cancel">CANCEL</button>
                                    <button id="btn-update" onclick="location.href='updateOrder?orderID=${order.orderId}'">UPDATE</button>
                                </div>
                            </c:if>
                            <h3 id="order-total-price">Total: $${order.total}</h3>
                        </div>
                        <div id="contact-info" class="col-9">
                            <h6 style="font-size: 20px;">Contact info</h6>
                            <div class="row">
                                <h6 class="col-3">Full Name</h6>
                                <p>${order.receiverName}</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Gender</h6>
                                <c:if test="${order.receiverGender == 0}">
                                    <p>Male</p>
                                </c:if>
                                <c:if test="${order.receiverGender == 1}">
                                    <p>Female</p>
                                </c:if>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Email</h6>
                                <p>${order.receiverEmail}</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Mobile</h6>
                                <p>${order.receiverPhone}</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Address</h6>
                                <p>${order.receiverAddress}</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Note</h6>
                                <p>${order.note}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        
        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
