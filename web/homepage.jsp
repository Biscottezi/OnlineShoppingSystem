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
        <header class="container wrapper">
            <nav class="navbar navbar-expand">
                <div class="navbar-branch col-2">
                    <a href="" id="logo">
                        <img src="" alt="Logo">
                    </a>
                </div>
                <form action="" class="col-3 searchbar">
                    <input type="text" placeholder="Search" class="search-input col-10" name="txtSearchProduct">
                    <button type="submit" id="search-button" class="col-2" name="btAction">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
                <ul class="navbar-nav col-4">
                    <li class="nav-item">
                        <a href="viewAllProduct">Products</a>
                    </li>
                    <li class="nav-item">
                        <a href="">Blogs</a>
                    </li>
                </ul>
                <i class="fas fa-shopping-cart col-1"></i>
                <button class="col-1 header-sign-in" onclick="openLogin()">Sign in</button>
            </nav>
        </header>

        <!--Login form-->
        <div id="login" class="container pop-up">
            <div class="row">
                <div class="col-4 welcome">
                    <div class="container">
                        <h1>Welcome!</h1>
                        <h3>Become a member and connect with us</h3>
                        <button class="welcome-btn" onclick="openRegister()">Sign up</button>
                    </div>
                </div>
                <div class="col-8 form-col">
                    <div class="close-btn" onclick="closePopUp('login')">
                        <i class="far fa-times-circle"></i>
                    </div>
                    <div class="container">
                        <div class="col-12">
                            <h1>Sign in</h1>
                            <form action="login" method="POST" class="form">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Email" name="txtEmail">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Password" name="txtPassword">
                                </div>
                                <button type="submit" class="form-col-btn" name="btAction">Sign in</button>
                            </form>
                            <span onclick="openForgotPassword()">Forgot your password?</span>
                            <img src="img/Frame.png" alt="frame" id="frame-hand-1">
                        </div>                
                    </div>
                </div>
            </div>
        </div>

        <!--User register form-->
        <div id="register" class="container pop-up">
            <div class="row">
                <div class="col-4 welcome" id="register-welcome">
                    <div class="container">
                        <h1>Welcome!</h1>
                        <h3>Already a member?<br>Sign in to keep up with us.</h3>
                        <button class="welcome-btn" onclick="openLogin()">Sign in</button>
                        <img src="img/Frame.png" alt="frame" id="frame-hand-2">
                    </div>
                </div>
                <div class="col-8 form-col">
                    <div class="close-btn" onclick="closePopUp('register')">
                        <i class="far fa-times-circle"></i>
                    </div>
                    <div class="container">
                        <div class="col-12">
                            <h1>Create Account</h1>
                            <form action="registration" method="POST" class="form">
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Email" name="txtEmail">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Password" name="txtPassword">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Confirm password" name="txtConfirm">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Fullname" name="txtFullName">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="text" placeholder="Mobile" name="txtMobile">
                                </div>
                                <div class="form-group">
                                    <select class="form-control" name="txtGender">
                                        <option disabled selected>Gender</option>
                                        <option value="0">Male</option>
                                        <option value="1">Female</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Address" name="txtAddress"></textarea>
                                </div>
                                <button type="submit" class="form-col-btn" name="btAction">Sign up</button>
                            </form>
                        </div>                
                    </div>
                </div>
            </div>
        </div>

        <!--Forgot password-->
        <div id="forgot-password" class="container pop-up form-col">
            <div class="close-btn" onclick="closePopUp('forgot-password')">
                <i class="far fa-times-circle"></i>
            </div>
            <div class="container">
                <div class="col-12">
                    <h1>Forgot Password</h1>
                    <form action="resetPassword" method="POST" class="form">
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="Email" name="txtEmail">
                        </div>
                        <button type="submit" class="form-col-btn forgot-btn" onclick="resetNoti()" name="btAction">Request Reset Link</button>
                    </form>
                    <button class="welcome-btn forgot-btn" id="forgot-btn" onclick="openLogin()">Sign in</button>
                </div>
            </div>
        </div>

        <!--Change password-->
        

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
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-3">
                                            <div class="card" style="min-height: 530px; margin: auto;">
                                                <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                                <div class="card-body">
                                                    <h5 class="card-title">Vintage Typewriter to post awesome stories about UI design and webdev.</h5>
                                                    <h3 class="card-title">$49.50</h3>
                                                    <p class="card-text">Eligible for Shipping To Mars or somewhere else</p>
                                                    <p class="card-text">Star: 4/5</p>
                                                </div>
                                            </div>
                                        </div>
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
                            <a href="">View more</a>
                        </div>
                    </div>
                    <div class="col-12">       
                        <div class="row">
                            <c:set var="featured-products" value="${requestScope.FEATURED_PRODUCT}"/>
                            <c:forEach var="product" items="featured-products">
                                <div class="col-3">
                                    <div class="card" style="min-height: 530px; margin: auto;">
                                        <img src="img/product-thumbnail.jpg" alt="product-thumbnail" class="card-img-top">
                                        <div class="card-body">
                                            <h5 class="card-title">${product.title}</h5>
                                            <h3 class="card-title">${product.salePrice} USD</h3>
                                            <p class="card-text">${briefInfo}</p>
                                            <p class="card-text">Star: 4/5</p>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>

            <!--Blogs-->
            <div class="container blog-wrapper">
                <div class="container">
                    <div class="row">
                        <h2 class="slider-title col-8">Blogs</h2>
                        <div class="view-more col-4">
                            <a href="">View more</a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-5">
                            <div class="card" style="height: 500px;">
                                <img src="img/post-thumbnail.jpg" alt="post0thumbnail" class="card-img-top">
                                <div class="card-body">
                                    <h3 class="card-title">Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm</h3>
                                    <p class="card-text">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Nobis nihil dolor ullam ea repellat ex porro! Incidunt fugit provident sit?</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-7 container">
                            <div class="row" style="height: 120px; margin-bottom: 5px;">
                                <img src="img/post-thumbnail.jpg" alt="post-thumbnail" class="col-3">
                                <h5 class="col-9" style="overflow: hidden;">
                                    Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm
                                </h5>
                            </div>
                            <div class="row" style="height: 120px; margin-bottom: 5px;">
                                <img src="img/post-thumbnail.jpg" alt="post-thumbnail" class="col-3">
                                <h5 class="col-9" style="overflow: hidden;">
                                    Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm
                                </h5>
                            </div>
                            <div class="row" style="height: 120px; margin-bottom: 5px;">
                                <img src="img/post-thumbnail.jpg" alt="post-thumbnail" class="col-3">
                                <h5 class="col-9" style="overflow: hidden;">
                                    Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm
                                </h5>
                            </div>
                            <div class="row" style="height: 120px; margin-bottom: 5px;">
                                <img src="img/post-thumbnail.jpg" alt="post-thumbnail" class="col-3">
                                <h5 class="col-9" style="overflow: hidden;">
                                    Đã có giá bán dự kiến iPad Pro M1 2021 tại Thế Giới Di Động, giá khởi điểm vẫn tốt như thế hệ tiền nhiệm
                                </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </main>

        <!--Footer-->
        <footer class="container footer-wrapper">
            <div class="row footer-row-1">
                <div class="col-3 footer-column">
                    <h3>Customer Center</h3>
                    <p>070-2707-1234<br/>
                        Weekdays 09:30 - 18:00<br>
                        Weekends 12:00 - 13:00<br/>
                        Sat, Sun, National holidays</p>
                </div>
                <div class="col-3 footer-column">
                    <h3>Shipment info</h3>
                    <p>Track Shipping Location<br>
                        Refund/exchange address<br>
                        Incheon Gaeyanggu Gesangdong<br>
                        GeyangBG #1117<br>
                        (Please make sure to use<br> 
                        Post Office Parcel service)</p>
                </div>
                <div class="col-3 footer-column">
                    <h3>Company</h3>
                    <p>Company<br>
                        Notice/Event</p>
                </div>
                <div class="col-3 footer-column">
                    <h3>Social media</h3>
                    <i class="fab fa-facebook-square"></i>
                    <i class="fab fa-youtube"></i>
                    <i class="fab fa-instagram"></i>
                    <i class="fab fa-pinterest-p"></i>
                </div>
            </div>
            <div class="row  footer-row-2">
                <p class="col-12">CEO: TaiNT&emsp;Company Name: FPTEdu&emsp;Tel: 070-123-1234&emsp;Fax: 02-123-4567&emsp;E-mail: hcmuni@fpt.edu.vn</p>
                <p class="col-12">Address: Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</p>
                <p class="col-12">License Number: 123-45-78910&emsp;Technical Manager: TaiNT</p>
                <p class="col-12">ⓒ 2021 FPTEdu All rights reserved.&emsp;Privacy Policy&emsp;Terms of Service</p>
            </div>
        </footer>
    </body>
</html>
