<%-- 
    Document   : header
    Created on : Jun 19, 2021, 3:14:03 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/header-footer.css">
        <link rel="stylesheet" href="css/homepage.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <script src="js/homepage.js"></script>
        <script src="js/managerpopup.js"></script>
        
        <style>
            #user-profile{
                display: block;
                margin-left: 3%;
            }
            .decor-div{
                background: linear-gradient(180deg, rgba(0, 133, 255, 0.58) 0%, rgba(0, 83, 158, 0.80738) 78.79%, #002A4B 141.2%);
                border-radius: 0 0 50px 50px;
                height: 120px;
            }
            #user-ava{
                width: 130px;
                height: 130px;
                border: 2px solid white;
                border-radius: 50%;
                position: absolute;
                left: 44%;
                top: 50px;
            }
            #ava-label{
                width: 2em;
                position: absolute;
                left: 54%;
                top: 9em;
            }
            .user-ava-btn{
                position: absolute;
                right: 13%;
            }
            .info-label{
                font-size: 20px;
                margin-top: 3px;
                font-weight: 500;
            }
            .profile-div{
                margin-top: 6em;
            }
        </style>
        
        <script>
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $('#user-ava').attr('src', e.target.result);
                    };
                    reader.readAsDataURL(input.files[0]);
                }
            }
        </script>
    </head>
    <body class="container">
        <!--Header-->
        <header class="container wrapper">
            <nav class="navbar navbar-expand">
                <div class="navbar-branch col-2">
                    <a href="viewHomePage" id="logo">LOGOS</a>
                </div>
                <form action="searchProduct" class="col-3 searchbar">
                    <input type="text" placeholder="Search" class="search-input col-10" name="txtSearchProduct" value="${param.txtSearchProduct}">
                    <button type="submit" id="search-button" class="col-2" name="btAction">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
                <ul class="navbar-nav col-4">
                    <li class="nav-item">
                        <a href="viewAllProduct">Products</a>
                    </li>
                    <li class="nav-item">
                        <a href="viewBlogList">Blogs</a>
                    </li>
                </ul>
                <i class="fas fa-shopping-cart col-1" onclick="location.href='viewCart'"></i>
                <c:choose>
                    <c:when test="${not empty sessionScope.USER}">
                        <c:set var="user" value="${sessionScope.USER}"/>
                        <!--Customer welcome-->
                        <div class="col-2 welcome-customer container">
                            <div class="d-flex flex-row align-items-center">
                                <p style="font-size: 20px; margin: auto 1em;">Welcome!</p>
                                <img src="img/${user.avatar}" alt="avatar" class="droplist-avatar ava" onclick="showPopup()">
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <button class="col-1 header-sign-in" onclick="openLogin()">Sign in</button>
                    </c:otherwise>
                </c:choose> 
            </nav>
        </header>

        <c:choose>
            <c:when test="${not empty sessionScope.USER}">
                <!--Customer dropdown menu-->
                <div class="droplist container float-right popupwrapper" id="usermenu">
                    <div class="col">
                        <div class="row droplist-btn" onclick="openProfile()">
                            <img src="img/${user.avatar}" alt="" class="droplist-avatar">
                            <div class="d-flex flex-column justify-content-center droplist-btn-txt">
                                <h6>${user.name}</h6>
                                <span>See your profile</span>
                            </div>
                        </div>
                        <hr>
                        <div class="row droplist-btn" onclick="location.href='custFeedback'">
                            <div class="icon-bg">
                                <img src="img/feedback.png" alt="">
                            </div>
                            <div class="d-flex flex-column justify-content-center droplist-btn-txt">
                                <h6>Give feedback</h6>
                                <span>Help us improve</span>
                            </div>
                        </div>
                        <hr>
                        <div class="row droplist-btn" onclick="location.href='custOrderList?customerID=${user.id}'">
                            <img src="img/view_orders.png" alt="" class="droplist-avatar">
                            <div class="d-flex flex-column justify-content-center droplist-btn-txt">
                                <h6>View Your Orders</h6>
                            </div>
                        </div>
                        <hr>
                        <div class="row droplist-btn" onclick="openChangePwd()">
                            <img src="img/change_passsword.png" alt="" class="droplist-avatar">
                            <div class="d-flex flex-column justify-content-center droplist-btn-txt">
                                <h6>Change Your Password</h6>
                            </div>
                        </div>
                        <hr>
                        <div class="row droplist-btn" onclick="location.href='logout'">
                            <img src="img/sign_out.png" alt="" class="droplist-avatar">
                            <div class="d-flex flex-column justify-content-center droplist-btn-txt">
                                <h6>Sign Out</h6>
                            </div>
                        </div>
                    </div>
                </div>
        
                <!--Change password-->
                <div id="change-pwd" class="container pop-up form-col">
                    <div class="close-btn" onclick="closePopUp('change-pwd')">
                        <i class="far fa-times-circle"></i>
                    </div>
                    <div class="container">
                        <div class="col-12">
                            <h1>Change Password</h1>
                            <form action="" method="POST" class="form">
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Current Password">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="New Password">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Confirm New Password">
                                </div>
                                <button type="submit" class="form-col-btn forgot-btn">Change Password</button>
                            </form>
                        </div>
                    </div>
                </div>
                
                <!--User profile-->
                <div id="user-profile" class="pop-up">
                    <div class="close-btn" onclick="closePopUp('user-profile')">
                        <i class="far fa-times-circle" style="color: white"></i>
                    </div>
                    <div class="decor-div"></div>
                    <img src="img/${user.avatar}" alt="user avatar" id="user-ava">
                    <label for="ava-user">
                        <img src="img/add-ava.png" id="ava-label">
                    </label>
                    <input type="file" id="ava-user" hidden name="avatar" form="user-avatar" onchange="readURL(this)">
                    <button type="submit" class="form-col-btn user-ava-btn" form="user-avatar" style="width: 170px;">Update avatar</button>
                    <div class="profile-div col">
                        <div class="d-flex justify-content-center" style="margin-bottom: 1em">
                            <span class="col-2 info-label">Full Name:</span>
                            <input type="text" name="txtName" class="col-6 form-control" value="${user.name}" style="margin-top: 0" form="user-info">
                        </div>
                        <div class="d-flex justify-content-center" style="margin-bottom: 1em">
                            <span class="col-2 info-label">Gender:</span>
                            <select class="form-control col-6" name="txtGender" style="margin-top: 0" form="user-info">
                                <option value="0" <c:if test="${user.gender == 0}">selected</c:if> >Male</option>
                                <option value="1" <c:if test="${user.gender == 1}">selected</c:if> >Female</option>
                            </select>
                        </div>
                        <div class="d-flex justify-content-center" style="margin-bottom: 1em">
                            <span class="col-2 info-label">Mobile:</span>
                            <input type="text" name="txtPhone" class="col-6 form-control" value="${user.phone}" style="margin-top: 0" form="user-info">
                        </div>
                        <div class="d-flex justify-content-center">
                            <span class="col-2 info-label">Address:</span>
                            <textarea class="form-control col-6" name="txtAddress" style="margin-top: 0" form="user-info">${user.address}</textarea>
                        </div>
                        <button type="submit" form="user-info" class="form-col-btn" style="width: 120px; margin-left: 44%; margin-bottom: 1em">Save</button>
                        <input type="hidden" name="userID" value="${user.id}" form="user-info">
                    </div>
                    <form id="user-avatar" action=""></form>
                    <form id="user-info" method="GET" action="updateProfile"></form>
                </div>
                
            </c:when>
            <c:otherwise>
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
                    <form action="reqResetLink" method="POST" class="form">
                        <div class="form-group">
                            <input class="form-control" type="text" placeholder="Email" name="txtEmail">
                        </div>
                        <button type="submit" class="form-col-btn forgot-btn" onclick="resetNoti()" name="btAction">Request Reset Link</button>
                    </form>
                    <button class="welcome-btn forgot-btn" id="forgot-btn" onclick="openLogin()">Sign in</button>
                </div>
            </div>
        </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
