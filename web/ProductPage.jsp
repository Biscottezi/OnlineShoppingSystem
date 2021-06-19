<%-- 
    Document   : ProductList
    Created on : May 26, 2021, 8:04:23 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>

    <body>
        <!--header-->
        <%@include file="header.jsp" %>

        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-3">
                    <div class="col">
                        <form action="" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <div class="category">
                            <a href="">Smartphone</a>
                        </div>
                        <div class="category">
                            <a href="">Laptop</a>
                        </div>
                        <div class="category">
                            <a href="">Smartwatch</a>
                        </div>
                        <div class="category">
                            <a href="">Earphone</a>
                        </div>
                    </div>
                </div>

                <div class="main-content col-9">
                    <div class="container" style="padding-left: 24px;">
                        <h1>Latest products</h1>
                        <select name="" id="">
                            <option value="" selected>Newest</option>
                            <option value="">Oldest</option>
                        </select>
                    </div>
                    <div class="row product-row">
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row product-row">
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-3">
                            <div class="card">
                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                    <h3 class="card-title card-price">$49.50</h3>
                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                    <p class="card-text">Star: 4/5</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="container">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination">
                              <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                              <li class="page-item"><a class="page-link" href="#">1</a></li>
                              <li class="page-item"><a class="page-link" href="#">2</a></li>
                              <li class="page-item"><a class="page-link" href="#">3</a></li>
                              <li class="page-item"><a class="page-link" href="#">Next</a></li>
                            </ul>
                          </nav>
                    </div>
                </div>
            </div>
        </main>
        
        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
