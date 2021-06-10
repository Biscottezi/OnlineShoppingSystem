<%-- 
    Document   : ProductList
    Created on : May 26, 2021, 8:04:23 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="header-footer.css">
        <link rel="stylesheet" href="sider.css">
    </head>
    <body class="container">
        <div class="container wrapper">
            <header>
                <nav class="navbar navbar-expand-md">
                    <div class="navbar-branch col-sm-2">
                        <a href="" id="logo">
                            <img src="" alt="Logo">
                        </a>
                    </div>
                    <form action="" class="col-sm-4 searchbar">
                        <input type="text" placeholder="Search" class="search-input col-sm-10">
                        <button type="submit" id="search-button" class="col-sm-2">
                            <i class="fas fa-search"></i>
                        </button>
                    </form>
                    <ul class="navbar-nav col-sm-4">
                        <li class="nav-item">
                            <a href="">Products</a>
                        </li>
                        <li class="nav-item">
                            <a href="">Blogs</a>
                        </li>
                    </ul>
                    <i class="fas fa-shopping-cart col-sm-1"></i>
                    <button class="col-sm-1" id="sign-in">Sign in</button>
                </nav>
            </header>
        </div>
        <main class="container">
            <div class="row">
                <div class="sider">
                    <div class="col">
                        <form action="" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10">
                            <button type="submit" id="search-button" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                    </div>
                </div>
                <div class="main-content"> Main content goes here</div>
            </div>
        </main>
        <div class="container footer-wrapper">
            <footer>
                <div class="row footer-row-1">
                    <div class="col-sm-3 footer-column">
                        <h3>Customer Center</h3>
                        <p>070-2707-1234<br/>
                            Weekdays 09:30 - 18:00<br>
                            Weekends 12:00 - 13:00<br/>
                            Sat, Sun, National holidays</p>
                    </div>
                    <div class="col-sm-3 footer-column">
                        <h3>Shipment info</h3>
                        <p>Track Shipping Location<br>
                            Refund/exchange address<br>
                            Incheon Gaeyanggu Gesangdong<br>
                            GeyangBG #1117<br>
                            (Please make sure to use<br> 
                            Post Office Parcel service)</p>
                    </div>
                    <div class="col-sm-3 footer-column">
                        <h3>Company</h3>
                        <p>Company<br>
                            Notice/Event</p>
                    </div>
                    <div class="col-sm-3 footer-column">
                        <h3>Social media</h3>
                        <i class="fab fa-facebook-square"></i>
                        <i class="fab fa-youtube"></i>
                        <i class="fab fa-instagram"></i>
                        <i class="fab fa-pinterest-p"></i>
                    </div>
                </div>
                <div class="row  footer-row-2">
                    <p class="col-sm-12">CEO: TaiNT&emsp;Company Name: FPTEdu&emsp;Tel: 070-123-1234&emsp;Fax: 02-123-4567&emsp;E-mail: hcmuni@fpt.edu.vn</p>
                    <p class="col-sm-12">Address: Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.</p>
                    <p class="col-sm-12">License Number: 123-45-78910&emsp;Technical Manager : TaiNT</p>
                    <p class="col-sm-12">ⓒ 2021 FPTEdu All rights reserved.&emsp;Privacy Policy&emsp;Terms of Service</p>
                </div>
            </footer>
        </div>
    </body>
</html>
