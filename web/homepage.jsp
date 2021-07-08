<%-- 
    Document   : homepage
    Created on : May 25, 2021, 8:23:00 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Homepage</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/homepage.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <script src="js/homepage.js"></script>
    </head>

    <body>
        <!--Header-->
        <%@include file="header.jsp" %>

        <!--Main content-->
        <main>
            <!--Banner-->
            <div id="carouselExampleIndicators" class="carousel slide container" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="img/banner1.jpg" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/banner2.jpg" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" src="img/banner3.jpg" alt="Third slide">
                    </div>
                </div>
            </div>

            <!--On sale product slider-->
            <c:set var="onsaleProducts" value="${requestScope.SLIDER_PRODUCTS}"/>
            <div class="container slider-wrapper">
                <div class="col-12">
                    <div class="row">
                        <h2 class="slider-title">On sale right now!</h2>
                    </div>
                    <div id="sale-slider" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="container">
                                    <div class="row">
                                        <c:forEach var="product" items="${onsaleProducts}" begin="0" end="3">
                                            <div class="col-3" onclick="location.href='viewProductDetails?productID=${product.id}';">
                                                <div class="card" style="min-height: 530px; margin: auto;">
                                                    <img src="img/${product.thumbnail}" alt="product-thumbnail" class="card-img-top">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${product.title}</h5>
                                                        <c:choose>
                                                            <c:when test="${product.salePrice != 0}">
                                                                <h5 class="card-title" style="text-decoration: line-through">$${product.listPrice}</h5>
                                                                <h3 class="card-title">$${product.salePrice}</h3>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <h3 class="card-title">$${product.listPrice}</h3>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <p class="card-text">${product.briefInfo}</p>
                                                        <p class="card-text">Star: ${product.ratedStar}/5</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container">
                                    <div class="row">
                                        <c:forEach var="product" items="${onsaleProducts}" begin="4" end="7">
                                            <div class="col-3" onclick="location.href='viewProductDetails?productID=${product.id}';">
                                                <div class="card" style="min-height: 530px; margin: auto;">
                                                    <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                    <div class="card-body">
                                                        <h5 class="card-title">${product.title}</h5>
                                                        <c:choose>
                                                            <c:when test="${product.salePrice != 0}">
                                                                <h5 class="card-title" style="text-decoration: line-through">$${product.listPrice}</h5>
                                                                <h3 class="card-title">$${product.salePrice}</h3>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <h3 class="card-title">$${product.listPrice}</h3>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <p class="card-text">${product.briefInfo}</p>
                                                        <p class="card-text">Star: ${product.ratedStar}/5</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <a class="carousel-control-prev" href="#sale-slider" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#sale-slider" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            </div>

            <!--Featured products-->
            <div class="container featured-wrapper">
                <div class="container">
                    <div class="row">
                        <h2 class="slider-title col-8">Featured Products</h2>
                        <div class="view-more col-4">
                            <a href="viewAllProduct">View more</a>
                        </div>
                    </div>
                    <div class="col-12">       
                        <div class="row">
                            <c:set var="featuredProducts" value="${requestScope.FEATURED_PRODUCT}"/>
                            <c:forEach var="product" items="${featuredProducts}">
                                <div class="col-3" style="margin-top: 1em" onclick="location.href='viewProductDetails?productID=${product.id}';">
                                    <div class="card" style="min-height: 530px; margin: auto;">
                                        <img src="img/${product.thumbnail}" alt="product-thumbnail" class="card-img-top">
                                        <div class="card-body">
                                            <h5 class="card-title">${product.title}</h5>
                                            <c:choose>
                                                <c:when test="${product.salePrice != 0}">
                                                    <h5 class="card-title" style="text-decoration: line-through">$${product.listPrice}</h5>
                                                    <h3 class="card-title">$${product.salePrice}</h3>
                                                </c:when>
                                                <c:otherwise>
                                                    <h3 class="card-title">$${product.listPrice}</h3>
                                                </c:otherwise>
                                            </c:choose>
                                            <p class="card-text">${product.briefInfo}</p>
                                            <p class="card-text">Rated: ${product.ratedStar}/5 stars</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <!--Blogs-->
            <c:set var="postList" value="${requestScope.FEATURED_POST}"/>
            <div class="container blog-wrapper">
                <div class="container">
                    <div class="row">
                        <h2 class="slider-title col-8">Blogs</h2>
                        <div class="view-more col-4">
                            <a href="viewBlogList">View more</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-5">
                            <c:forEach var="post" items="${postList}" begin="0" end="0">
                                <div class="card" style="height: 500px; overflow: hidden;" onclick="location.href='viewBlogDetails?selectedPostID=${post.id}';">
                                    <img src="img/${post.thumbnail}" alt="post-thumbnail" class="card-img-top">
                                    <div class="card-body">
                                        <h3 class="card-title">${post.title}</h3>
                                        <p class="card-text">${post.briefInfo}</p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="col-7 container">
                            <c:forEach var="post" items="${postList}" begin="1" end="4">
                                <div class="row" style="height: 120px; margin-bottom: 5px;" onclick="location.href='viewBlogDetails?selectedPostID=${post.id}';">
                                    <img src="img/${post.thumbnail}" alt="post-thumbnail" class="col-3">
                                    <h5 class="col-9" style="overflow: hidden;">${post.title}</h5>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

        </main>

        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
