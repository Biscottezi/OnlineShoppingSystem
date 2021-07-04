<%-- 
    Document   : CustomerFeedback
    Created on : Jul 4, 2021, 2:27:08 PM
    Author     : nguye
--%>
<!--Header-->
        <%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Feedback</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CustomerFeedback.css">
        <style>
            .main-content{
                padding-left: 2em;
            }
        </style>
    </head>
    <body>
        
        
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
                        <c:forEach var="category" items="${productCategoryList}">
                            <div class="category">
                                <a href="">${category.name}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <!--Main content-->
                <div class="main-content container col-10">
                    <h1>Feedback</h1><br>
                    <div class="row">
                        <div class="col container" style="border-right: 1px solid #E3E3E3">
                            <h4>Help us get better!</h4>
                            <c:if test="${not empty param.productID}">
                                <c:set var="product" value="${requestScope.PRODUCT_DETAILS}"/>
                                <h6>Product: ${product.id}</h6>
                                <input type="text" name="txtProductID" value="${product.id}" form="feedback-form">
                            </c:if>
                            <h6>Rating</h6>
                            <input type="number" name="txtRating" min="1" max="5" value="" form="feedback-form" id="input-rating" class="contact-input">
                            <h6>Description</h6>
                            <textarea name="txtFeedbackContent" form="feedback-form" required class="contact-input" id="contact-dscrpt"></textarea>
                            <h6>Images</h6>
                            <input type="file" name="txtFeedbackImages" form="feedback-form"><br>
                            <button type="submit" name="btAction" form="feedback-form" id="sbm-btn">SUBMIT</button>
                        </div>
                        
                        <div class="col container" style="padding-left: 3em">
                            <h4>Contact Information</h4>
                            <h6>Full Name</h6>
                            <input type="text" name="txtName" value="" form="feedback-form" required class="contact-input">
                            <h6>Gender</h6>
                            <select name="txtGender" form="feedback-form" required class="contact-input" id="contact-gender">
                                <option selected disabled>Gender</option>
                                <option value="0">Male</option>
                                <option value="1">Female</option>
                            </select>
                            <h6>Email</h6>
                            <input type="text" name="txtEmail" value="" form="feedback-form" required class="contact-input">
                            <h6>Mobile</h6>
                            <input type="text" name="txtMobile" value="" form="feedback-form" required class="contact-input">
                        </div>
                        
                        <form action="" method="POST" id="feedback-form"></form>
                    </div>
                </div>
            </div>
    </body>
</html>
