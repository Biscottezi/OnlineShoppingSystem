<%-- 
    Document   : CustomerOrderDetails
    Created on : Jun 22, 2021, 11:52:19 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="main-content container col-10">
                    <h1>Your Order</h1>
                    <div class="container order-details-wrapper col" style="padding: 1em 2em 2em 2em">
                        <div class="row d-flex justify-content-between" id="order-basic-info">
                            <div class="col-4">
                                <h2 style="font-weight: 600; line-height: 1em;">ID: 123456</h2>
                                <span style="font-weight: 500;">22/05/2021 - 20:13</span>
                            </div>
                            <div class="col-2 justify-content-center" id="order-status">Submitted</div>
                        </div>
                        <div class="item-wrapper row">
                            <img src="img/product-thumbnail.jpg" alt="" class="col-2 align-self-stretch">
                            <div class="col-5">
                                <h4>Vintage Typewriter</h4>
                                <h6>Unit Price: $49.50</h6>
                                <h6>Quantity: 1</h6>
                            </div>
                            <div class="col-5 d-flex flex-column justify-content-between align-items-end">
                                <h4>$49.50</h4>
                                <div>
                                    <button class="btn-feedback">FEEDBACK</button>
                                    <button class="btn-buy-again">BUY AGAIN</button>
                                </div>
                            </div>
                        </div>
                        <div class="item-wrapper row">
                            <img src="img/product-thumbnail.jpg" alt="" class="col-2 align-self-stretch">
                            <div class="col-5">
                                <h4>Plastic Plugs</h4>
                                <h6>Unit Price: $12.48</h6>
                                <h6>Quantity: 2</h6>
                            </div>
                            <div class="col-5 d-flex flex-column justify-content-between align-items-end">
                                <h4>$24.96</h4>
                                <div>
                                    <button class="btn-feedback">FEEDBACK</button>
                                    <button class="btn-buy-again">BUY AGAIN</button>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-row justify-content-between">
                            <div class="btn-cancel-update">
                                <button id="btn-cancel">CANCEL</button>
                                <button id="btn-update">UPDATE</button>
                            </div>
                            <h3 id="order-total-price">Total: $81.91</h3>
                        </div>
                        <div id="contact-info" class="col-9">
                            <h6 style="font-size: 20px;">Contact info</h6>
                            <div class="row">
                                <h6 class="col-3">Full Name</h6>
                                <p>Tran Tan Long</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Gender</h6>
                                <p>Male</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Email</h6>
                                <p>tanlong6121@gmail.com</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Mobile</h6>
                                <p>0975926021</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Address</h6>
                                <p>123, Bai Say, Phuong 4, Quan 6, TPHCM</p>
                            </div>
                            <div class="row">
                                <h6 class="col-3">Note</h6>
                                <p>Giao vao khoang 16h-20h</p>
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
