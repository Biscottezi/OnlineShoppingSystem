<%-- 
    Document   : CartCompletion
    Created on : Jun 12, 2021, 10:47:15 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cart Completion</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CartCompletion.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <script src="js/homepage.js"></script>
    </head>

    <body>
        <!--header-->
        <%@include file="header.jsp" %>

        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <c:set var="productCategoryList" value="${requestScope.PRODUCT_CATEGORY}"/>
                        <c:forEach var="productCategory" items="${productCategoryList}">
                        <div class="category">
                            <a href="viewProdByCate?categoryID=${productCategory.id}">${productCategory.name}</a>
                        </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="main-content container col-10" style="min-height: 700px;">
                    <h1>Order</h1>
                    <div class="col">
                        <div class="d-flex justify-content-center p-2">
                            <img src="img/cartCompletion.png" alt="cartCompletionImg">
                        </div>
                        <h2 class="d-flex justify-content-center pt-2">Thank you</h2>
                        <h3 class="d-flex justify-content-center p-2">Sit back and relax, your order is on its way!</h3>
                        <div class="d-flex flex-row justify-content-around p-2">
                            <button class="main-ctn-btn">HOME PAGE</button>
                            <c:if test="${not empty sessionScope.USER}">
                                <c:set var="user" value="${sessionScope.USER}"/>
                                <button class="main-ctn-btn" onclick="location.href='custOrderList?customerID=${user.id}'">VIEW ORDERS</button>
                            </c:if>
                            <button class="main-ctn-btn">BUY MORE</button>
                        </div>
                        <!--<div class="d-flex justify-content-center p-2">
                            <h4>Order confirmation was sent to receiver@gmail.com</h4>
                        </div>-->
                    </div>
                </div>
            </div>
        </main>

        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
