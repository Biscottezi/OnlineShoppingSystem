<%-- 
    Document   : ProductList
    Created on : May 26, 2021, 8:04:23 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Products</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/ProductPage.css">
        <style>
            .pagination > li > a {
                background-color: #EBF2FF;
                border-radius: 8px;
                color: black;
            }
            
            .pagination > li {
                margin-right: 0.7em;
            }
            
            .pagination > .active > a{
                background-color: #274156;
            }
        </style>
    </head>

    <body>
        <!--header-->
        <%@include file="header.jsp" %>

        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="searchProduct" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchProduct" value="${param.txtSearchProduct}">
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

                <div class="main-content col-10">
                    <div class="container" style="padding-left: 24px;">
                        <c:choose>
                            <c:when test="${not empty param.txtSearchProduct}">
                                <h3>Results for "${param.txtSearchProduct}"</h3>
                            </c:when>
                            <c:otherwise>
                                <h1>Latest products</h1>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="row product-row" id="data-container">
                        <c:set var="productList" value="${requestScope.ALL_PRODUCT_LIST}"/>
                        <c:forEach var="product" items="${productList}" varStatus="counter">
                            <div class="col-3 product-wrapper" id="prod${counter.count}" onclick="location.href='viewProductDetails?productID=${product.id}';" style="margin-top: 1em; overflow: hidden">
                            <div class="card">
                                <img src="img/${product.thumbnail}" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h4 class="card-title">${product.title}</h4>
                                    <c:choose>
                                        <c:when test="${product.salePrice != 0}">
                                            <h5 class="card-title card-price" style="text-decoration: line-through; font-size: 18px">$${product.listPrice}</h5>
                                            <h3 class="card-title card-price">$${product.salePrice}</h3>
                                        </c:when>
                                        <c:otherwise>
                                            <h3 class="card-title card-price">$${product.listPrice}</h3>
                                        </c:otherwise>
                                    </c:choose>
                                    <p class="card-text" style="max-height: 90px">${product.briefInfo}</p>
                                    <p class="card-text">Rated: ${product.ratedStar}/5 stars</p>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <br>
                    <div class="container">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </main>
        
        <script type="text/javascript">
            $(document).ready(function(){
                const pageSize = 2;

                let noOfProd = $(".product-wrapper").length;
                let noOfPage = Math.ceil(noOfProd / pageSize);
                for(let i = 1; i <= noOfPage; ++i){
                    $(".pagination").append("<li class=\"page-item\"><a class=\"page-link\" href=\"#\">" + i + "</a></li>")
                }

                //Hide all product
                $(".product-wrapper").each(function(index, value){
                    $(".product-wrapper").hide();
                });

                $(".page-link").first().parent().addClass("active");
                var trimEnd1 = parseInt($(".page-link").first().text(), 10) * pageSize;
                var trimStart1 = trimEnd1 - (pageSize - 1);
                for(let i = trimStart1; i <= trimEnd1; ++i){
                    var cardId = "#prod" + i.toString();
                    $(cardId).show();
                }

                $(".page-link").on('click', function(){
                    $(".page-link").each(function(index, value){
                        $(value).parent().removeClass("active");
    		    });

                    //Hide all cards
                    $(".product-wrapper").each(function(index, value){
                        $('.product-wrapper').hide();
                    })
  
                    $(this).parent().addClass("active");
                    var trimEnd = parseInt($(this).text(), 10) * pageSize;
                    var trimStart = trimEnd - (pageSize - 1);
                    for(let i = trimStart; i <= trimEnd; ++i){
                        var cardId = "#prod" + i.toString();
                        $(cardId).show();
                    }
                });
            });
        </script>
                        
        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
