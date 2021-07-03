<%-- 
    Document   : BlogList
    Created on : Jul 3, 2021, 3:09:10 PM
    Author     : nguye
--%>
<!--header-->
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blogs</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="js/blogTable.js"></script>
        <style>
            .post-thumb{
                height: 120px;
            }
            .post-title{
                font-size: 22px;
                font-weight: 600;
            }
        </style>
    </head>
    <body>
        
        
        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="searchProduct" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchPost" value="">
                            <button type="submit" id="search-button" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <c:set var="postCategoryList" value="${requestScope.POST_CATEGORY}"/>
                        <c:forEach var="postCategory" items="${postCategoryList}">
                        <div class="category">
                            <a href="">${postCategory.name}</a>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                        
                <div class="main-content col-10 container">
                    <div class="container">
                    <table class="table table-hover" id="custBlogTable">
                        <thead>
                            <tr>
                                <th><h1>Latest Posts</h1></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="postList" value="${requestScope.ALL_POST_LIST}"/>
                            <c:forEach var="post" items="${postList}">
                                <tr onclick="location.href='viewBlogDetails?selectedOrderID=${post.id}'">
                                    <td>
                                        <img src="img/${post.thumbnail}" alt="post thumbnail" class="post-thumb">
                                    </td>
                                    <td class="post-title">${post.title}</td>
                                </tr>
                            </c:forEach>
                            
                            
                        </tbody>
                    </table>
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
