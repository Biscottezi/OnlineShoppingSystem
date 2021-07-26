<%-- 
    Document   : userlistedit
    Created on : Jun 25, 2021, 11:53:09 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/userlist.css"/>
        <link rel="stylesheet" href="css/editinfo.css"/>
        <link rel="stylesheet" href="css/staffpop-up.css"/>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statusChangeFeedback.js"></script>
        <script src="js/homepage.js"></script>
        <script src="js/staffpop-up.js"></script>
        <style>
            .status{
                width:100px;
                height:24px;
                border-radius: 24px;
                color: white;
                font-weight: 400;
            }
            .enable{
                background: #29cc97;
            }
            .disable{
                background: #CC2929;
            }
            #active {
            background: rgba(159, 162, 180, 0.08);
            color: #DDE2FF;
            border-left: 5px #DDE2FF solid;
            padding-left: 5px;
            }
            .show {
                display:block;
            }
            .select-wrapper {
              position: relative;
              width: 690px;
            }
            .select-wrapper::after {
              top: 30px;
            }
            #prod-dscrpt{
                background-color: #F9F9F9;
                width: 1433px;
                border: 1px solid #9FA2B4;
                border-radius: 11px;
                height: 500px;
                font-weight: 400;
            }
            #fb-title{
                padding: 0;
                font-size: 19px;
                font-weight: 600;
                color: black;
            }
            #post-title{
                height: 145px;
            }
            #post-info{
                height: 152px;
            }
            .fb-img img{
                height: 250px;
                margin-top: 2em;
            }
        </style>
    </head>
    <body style="width: 100%; height:100%; margin: 0; padding: 0; background-color: #F7F8FC">
        <c:set var="user" value="${sessionScope.USER}"/>
        <div class="wrapper row" style="margin:0;padding:0; max-width: 100%;">
            <div class="wrapper col-2" style="background-color: #363740; min-height:937px; padding-right: 0;">
              <ul class="nav flex-column col">
                  
                  <!-- header -->
                  <li class="nav-item" id="header">
                    <div class="navbar-brand" href="#">
                        <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col"><img src="img/logo.png" alt=""/></div>
                                <div class="col">Marketing<br> Dashboard</div>
                            </div>
                        </div>
                    </div>
                  </li>
                  
                  <!-- item 1 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktDashboard">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/dashboard.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Overview</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 2 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktCustomerList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/users.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Customers</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 3 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktProductList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/products.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Products</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 4 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktPostList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/posts.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Posts</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 5 -->
                  <li class="nav-item naviitem row" id="active">
                      <a class="navbar-brand overview" href="mktFeedbackList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/mkt-feedbacks-chosen.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Feedbacks</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 6 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktSliderList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/sliders.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Sliders  </div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <li class="nav-item naviitem row divider"></li>
              </ul>
            </div>

            <div class="wrapper col" style="background-color: #F7F8FC; padding: 30px 33px 30px 45px;" id="maincontent">
                <!-- main title -->
                <div class="maintitle row">
                    <div class="col-2" id="title" onclick="location.href='mktFeedbackList';">
                        <span class="back"><i class="fas fa-angle-left"></i>&nbsp; Back to feedbacks</span>
                    </div>
                    <div class="col-7"></div>
                    <div class="col row">
                        <div class="d-flex justify-content-end col-10 align-items-center" id="user">
                            ${user.name} <!-- input jstl session user here! -->
                        </div>
                        <div class="profile col-2">
                            <div id="avatar" class="ava" style="background-image: url(img/${user.avatar});" onclick="showPopup()"></div> <!-- get session's avatar -->
                        </div>
                    </div>
                </div>
                <c:set var="feedback" value="${requestScope.FEEDBACK_DETAILS}"/>
                <!-- main list -->
                <div class="listwrapper">
                    <!-- list header -->
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center" id="userid">Feedback ID: ${feedback.id} <!--${param.id} --></div>
                        <div class="col-6 row"></div>
                        <div class="extended col-4 row d-flex"></div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Feedbacker<br>
                            <div class="userinfo">${feedback.name}</div>
                        </div>
                        <div class="col">
                            Mobile<br>
                            <div class="userinfo">${feedback.phone}</div>
                        </div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Product<br>
                            <div class="userinfo">
                                <c:choose>
                                    <c:when test="${not empty feedback.productTitle}">${feedback.productTitle}</c:when>
                                    <c:otherwise>None (General Feedback)</c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="col">
                            <div style="margin-top:18px;">Email</div>
                            <div class="userinfo">${feedback.email}</div>
                        </div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Description<br>
                            <div class="userinfo">${feedback.content}</div>
                        </div>
                        <div class="col">
                            <div style="margin-top:18px;">Rated</div>
                            <div class="userinfo">${feedback.ratedStar} / 5 stars</div>
                        </div>
                    </div>
                        <br><br><br><br><br><br>
                    <div class="infor row" id="lastrow">
                        <div class="col-6">
                            Status<br>
                            <div class="statuswrapper row d-flex align-items-end" style="margin:0;">
                                <c:choose>
                                    <c:when test="${feedback.status == 0}">
                                        <div class="status disable col-3 d-flex align-items-center justify-content-center newstatus" id="createstatus">UNRESOLVED</div>
                                        <input type="checkbox" name="feedbackStatus" value="ON" id="statuschkbox" class="col-1"  form="updateform"/>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="status enable col-3 d-flex align-items-center justify-content-center newstatus" id="createstatus">RESOLVED</div>
                                        <input type="checkbox" name="feedbackStatus" value="ON" checked="checked" id="statuschkbox" class="col-1"  form="updateform"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                        <div class="col-2">
                            <input type="hidden" name="feedbackID" form="updateform" value="${feedback.id}"/>
                        </div>
                        <div class="col-4">
                            <div class="savewrapper row d-flex align-items-end justify-content-end">
                                <div class="col d-flex justify-content-end" id="cancelbtn" onclick="location.href='mktFeedbackDetails?feedbackID=${feedback.id}'">Discard change</div>
                                <div class="col d-flex justify-content-end" style="padding:0;">
                                    <input type="submit" value="Save" name="btAction" id="createbtn" form="updateform"/>
                                </div>
                            </div>
                        </div>
                    </div>
                        <hr>
                    <div class="infor row">
                        <div class="col">
                            <h6 id="fb-title">Attached Images</h6>    
                            <div class="row">
                                <div class="fb-img col-3">
                                    <img src="img/product-thumbnail.jpg" alt="feedback images"/>
                                </div>
                                <div class="fb-img col-3">
                                    <img src="img/product-thumbnail.jpg" alt="feedback images"/>
                                </div>
                                <div class="fb-img col-3">
                                    <img src="img/product-thumbnail.jpg" alt="feedback images"/>
                                </div>
                                <div class="fb-img col-3">
                                    <img src="img/product-thumbnail.jpg" alt="feedback images"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        <div class="popupwrapper" id="usermenu" style="padding:0;margin:0;">
            <div class="pro5 row popupitem" onclick="openProfile()">
                <div class="col-3 d-flex align-items-center justify-content-center" style="padding:0;">
                    <div id="menuavatar" style="background-image: url(img/${user.avatar});"></div>
                </div>
                <div class="col-9 d-flex align-items-center description">
                    <div class="descwrapper">
                        <p class="menu-itemtitle">${user.name}</p>
                        <p>See your profile</p>
                    </div>
                </div>
            </div>
            <div class="menu-divider"></div>
            <div class="chgpsw row popupitem" onclick="openChangePwd()">
                <div class="col-3 d-flex align-items-center justify-content-center" id="chgpsw">
                    <div class="menuitemicon" style="background-image: url(img/chgpsw.png);"></div>
                </div>
                <div class="col-9 d-flex align-items-center description menu-itemtitle">Change Your Password</div>
            </div>
            <div class="menu-divider"></div>
            <div class="signout row popupitem" onclick="location.href='logout';">
                <div class="col-3 d-flex align-items-center justify-content-center" id="signout">
                    <div class="menuitemicon" style="background-image: url(img/signout.png);"></div>
                </div>
                <div class="col-9 d-flex align-items-center description menu-itemtitle">Sign Out</div>
            </div>
        </div>
        
        <form action="updateFeedback" id="updateform"></form>
        
        <!--Change password-->
                <c:set var="error" value="${requestScope.CHANGE_PASS_ERR}"/>
                <div id="change-pwd" class="container pop-up form-col" <c:if test="${not empty error}">style="display: block"</c:if> >
                    <div class="close-btn" onclick="closePopUp('change-pwd')">
                        <i class="far fa-times-circle"></i>
                    </div>
                    <div class="container">
                        <div class="col-12">
                            <h1>Change Password</h1>
                            <form action="changePass" method="POST" class="form">
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Current Password" name="txtOldPassword">
                                    <p style="color: red">${error.oldPassErr}</p>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="New Password" name="txtNewPassword">
                                    <p style="color: red">${error.newPassErr}</p>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" type="password" placeholder="Confirm New Password" name="txtConfirmPassword">
                                    <p style="color: red">${error.confirmPassErr}</p>
                                </div>
                                <button type="submit" class="form-col-btn forgot-btn">Change Password</button>
                                <input type="hidden" name="userID" value="${user.id}"/>
                                <input type="hidden" name="password" value="${user.password}"/>
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
                    <form id="user-avatar" action="updateAvatar" method="POST" enctype="multipart/form-data"></form>
                    <form id="user-info" method="GET" action="updateProfile"></form>
                </div>
    </body>
</html>
