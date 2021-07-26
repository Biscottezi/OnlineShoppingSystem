<%-- 
    Document   : CartContactUpdate
    Created on : Jul 26, 2021, 12:15:14 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Cart Contact</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CartContact.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <script src="js/homepage.js"></script>
        <style>
            #sidercontent{
                padding:0px;
            }
            #sider-search{
                padding-left: 0px;
            }
            .btn-change, .btn-submit{
                cursor: pointer;
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
                    <div class="col" id="sidercontent">
                        <form action="searchProduct" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchProduct" id="sider-search">
                            <button type="submit" id="search-button" style="padding:0px; padding-left:10px;" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <c:set var="productCategoryList" value="${sessionScope.PRODUCT_CATEGORY}"/>
                        <c:forEach var="productCategory" items="${productCategoryList}">
                        <div class="category">
                            <a href="viewProdByCate?categoryID=${productCategory.id}">${productCategory.name}</a>
                        </div>
                        </c:forEach>
                    </div>
                </div>

                <!--Main content-->
                <div class="main-content container col-10">
                    <h1>Your Cart</h1>
                    <c:set var="order" value="${sessionScope.ORDER}"/>
                    <h3>Order ID: ${order.id}</h3>
                    <div class="row">
                        <div class="product-in-cart col-8">
                            <c:set var="cart" value="${sessionScope.CART}"/>
                            <c:set var="products" value="${cart.items}"/>
                            <c:set var="sum" value="${0}"/>
                            <c:if test="${not empty products}">
                                <c:forEach var="product" items="${products}">
                                    <div class="product row container">
                                        <img src="img/${product.value.thumbnail}" alt="product" class="col-3">
                                        <div class="product-info container col-9">
                                            <div class="d-flex justify-content-between">
                                                <h4>${product.value.title}</h4>
                                                <h5>
                                                    <c:choose>
                                                        <c:when test="${product.value.salePrice != 0}">
                                                            $${product.value.salePrice * product.value.quantity}
                                                            <c:set var="sum" value="${sum + product.value.salePrice * product.value.quantity}"/>
                                                        </c:when>
                                                        <c:otherwise>
                                                            $${product.value.listPrice * product.value.quantity}
                                                            <c:set var="sum" value="${sum + product.value.listPrice * product.value.quantity}"/>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </h5>
                                            </div>
                                            <span>Quantity: ${product.value.quantity}</span>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            
                            <br>
                            <!--Contact form-->
                            <div class="contact-form container col-12">
                                <h6>Contact Info</h6>
                                <form action="checkoutUpdate" method="POST" id="contact-info">
                                    <input type="hidden" name="orderID" value="${order.id}"/>
                                    <div class="row frm-ctrl">
                                        <label for="txtReceiverName" class="col-3">Full Name:</label>
                                        <input type="text" name="txtReceiverName" value="${order.receiverName}" required>
                                    </div>
                                    <div class="row frm-ctrl">
                                        <label for="txtReceiverGender" class="col-3">Gender:</label>
                                        <select name="txtReceiverGender" required>
                                            <option value="0" <c:if test="${order.receiverGender == 0}">selected</c:if> >Male</option>
                                            <option value="1" <c:if test="${order.receiverGender == 1}">selected</c:if> >Female</option>
                                        </select>
                                    </div>
                                    <div class="row frm-ctrl">
                                        <label for="txtReceiverEmail" class="col-3">Email:</label>
                                        <input type="text" name="txtReceiverEmail" required value="${order.receiverEmail}">
                                    </div>
                                    <div class="row frm-ctrl">
                                        <label for="txtReceiverMobile" class="col-3">Mobile:</label>
                                        <input type="text" name="txtReceiverMobile" value="${order.receiverPhone}" required>
                                    </div>
                                    <div class="row frm-ctrl">
                                        <label for="txtReceiverAddress" class="col-3">Address:</label>
                                        <textarea name="txtReceiverAddress" cols="33" rows="4" required>${order.receiverAddress}</textarea>
                                    </div>
                                    <div class="row frm-ctrl">
                                        <label for="txtNote" class="col-3">Note:</label>
                                        <textarea name="txtNote" cols="33" rows="4">${order.note}</textarea>
                                    </div>
                                </form>
                            </div>

                        </div>

                        <div class="summary col-4 d-flex flex-column">
                            <h3 class="mb-auto">SUMMARY</h3>
                            <div class="d-flex justify-content-between">
                                <span>Total:</span>
                                <span>$${sum}</span>
                            </div>
                            <br>
                            <div class="d-flex justify-content-between">
                                <button class="btn-change" onclick="location.href='viewCartUpdate'">CHANGE</button>
                                <button class="btn-submit" name="btAction" form="contact-info" type="submit">SUBMIT</button>
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
