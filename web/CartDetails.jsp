<%-- 
    Document   : CartDetails
    Created on : Jun 16, 2021, 1:22:58 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cart Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CartDetails.css">
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

                <!--Main content-->
                <div class="main-content container col-10" style="min-height: 700px;">
                    <h1>Your Cart</h1>
                    <div class="row">
                        <div class="product-in-cart col-8">
                            <div class="product row container">
                                <img src="img/product-thumbnail.jpg" alt="product" class="col-3">
                                <div class="product-info container col-9">
                                    <form action="removeFromCart">
                                        <div class="d-flex justify-content-between">
                                            <h4>Vintage Typewriter</h4>
                                            <h5>$49.50</h5>
                                        </div>
                                        <input type="hidden" value="product-id-here" name="txtProductId">
                                        <label for="txtQuantity">Quantity</label><br>
                                        <div class="d-flex justify-content-between">
                                            <input type="number" name="txtQuantity" value="1">
                                            <button type="submit" name="btAction" class="btn-remove">Remove</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="product row container">
                                <img src="img/product-thumbnail.jpg" alt="product" class="col-3">
                                <div class="product-info container col-9">
                                    <form action="">
                                        <div class="d-flex justify-content-between">
                                            <h4>Plastic Plugs</h4>
                                            <h5>$24.96</h5>
                                        </div>
                                        <input type="hidden" value="product-id-here" name="txtProductId">
                                        <label for="txtQuantity">Quantity</label><br>
                                        <div class="d-flex justify-content-between">
                                            <input type="number" name="txtQuantity" value="2">
                                            <button type="submit" name="btAction" class="btn-remove">Remove</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="summary col-4 d-flex flex-column">
                            <h3 class="mb-auto">SUMMARY</h3>
                            <div class="d-flex justify-content-between">
                                <span>Total:</span>
                                <span>$81.91</span>
                            </div>
                            <br>
                            <div class="d-flex justify-content-between">
                                <button class="btn-buy-more">BUY MORE</button>
                                <button class="btn-checkout" name="btAction">CHECKOUT</button>
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
