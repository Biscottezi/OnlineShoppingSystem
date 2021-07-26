<%-- 
    Document   : userlist
    Created on : Jun 15, 2021, 10:19:46 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
        <link rel="stylesheet" href="css/pop-up.css">
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/userlist.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/salelist.css"/>
        <link rel="stylesheet" href="css/dashboard.css"/>
        <link rel="stylesheet" href="css/admindashboard.css"/>
        <link rel="stylesheet" href="css/staffpop-up.css"/>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statuschange.js"></script>
        <script src="js/datepicker.js"></script>
        <script src="js/homepage.js"></script>
        <script src="js/staffpop-up.js"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
            #tbllist_info {
                padding: 8px;
            }
            #tbllist_paginate{
                padding:8px;
            }
            #tbllist_paginate > a{
                margin: 10px;
            }
            #tbllist{
                border-bottom: 1px #DFE0EB solid;
            }
            .bottom{
                padding: 12px 0px 20px 0px;
            }
            #active {
            background: rgba(159, 162, 180, 0.08);
            color: #DDE2FF;
            border-left: 5px #DDE2FF solid;
            padding-left: 5px;
            }
            .paginate_button {
              cursor: pointer;
              *cursor: hand;
            }
            .show {
                display:block;
            }
            .picker-wrapper{
                margin-bottom: 50px;
            }
            .select-wrapper{
                width: 354px;
            }
            .select-wrapper::after{
                top: 0px;
            }
            #saleselect::after{
                top: -2px;
            }
            #saleselect{
                 width: 400px;
            }
            .admin-stats:hover{
                border: 1px solid #3751FF;
                box-shadow: 0 0 0 2px #DDE2FF;
                transition: all .2s ease;
                -webkit-transition: all .2s ease;
            }
            .admin-stats:hover .details-header, .admin-stats:hover .details{
                color: #3751FF;
                transition: all .2s ease;
                -webkit-transition: all .2s ease;
            }
        </style>
    </head>
    <body style="width: 100%; height:100%; margin: 0; padding: 0; background-color: #F7F8FC">
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:set var="posts" value="${sessionScope.POSTS}"/>
        <c:set var="products" value="${sessionScope.PRODUCTS}"/>
        <c:set var="feedbacks" value="${sessionScope.FEEDBACKS}"/>
        <c:set var="customers" value="${sessionScope.CUSTOMERS}"/>
        <c:set var="start" value="${sessionScope.DATESTART}"/>
        <c:set var="end" value="${sessionScope.DATEEND}"/>
        <c:set var="graph" value="${sessionScope.GRAPH}"/>
        
        <div class="wrapper row" style="margin:0;padding:0; max-width: 100%;">
            <div class="wrapper col-2" style="background-color: #363740; min-height:937px; padding-right: 0;">
              <ul class="nav flex-column col">
                  
                  <!-- header -->
                  <li class="nav-item" id="header">
                    <div class="navbar-brand" href="#">
                        <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col"><img src="img/logo.png" alt=""/></div>
                                <div class="col">Marketing <br> Dashboard</div>
                            </div>
                        </div>
                    </div>
                  </li>
                  
                  <!-- item 1 -->
                  <li class="nav-item naviitem row" id="active">
                      <a class="navbar-brand overview" href="mktDashboard">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/dashboard-chosen.png" alt=""/></div>
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
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="mktFeedbackList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/mkt-feedbacks.png" alt=""/></div>
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
                <div class="maintitle row" style="margin-bottom: 30px;">
                    <div class="col-2" id="title"><span>Overview</span></div>
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
                <!-- session -->
                <div class="input-group col-3 row" style="margin-right: 10px; margin-bottom: 30px;">
                    <div class="input-group-prepend" style="height: 38px;">
                        <span class="input-group-text" id="basic-addon1" style="background-color:white; border: 1px #e3e3e3 solid; border-right-style: none;">
                            <i class="far fa-calendar-alt" style="font-size:22px;"></i>
                        </span>
                        <input type="text" name="daterange" id="datepicker" class="datepicker" style="height: 38px; width: 310px;" form="changeGraph"/>
                        <input type="submit" value="View" name="btAction" form="changeGraph"/>
                    </div>
                </div>
                
                <div class="picker row" style="margin-bottom: 40px;">
                    <div class="col-3 sale-member picker-title">
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Posts<br>
                                <span class="details">${posts}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title">
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Products<br>
                                <span class="details">${products}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title">
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Customers<br>
                                <span class="details">${customers}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title">
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Feedbacks<br>
                                <span class="details">${feedbacks}</span>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- main graph -->
                <div class="graphwrapper">
                    <!-- graph header -->
                    <div class="graph-header row">
                        <div class="col-12 d-flex justify-content-start align-items-center graphtitle">New customers trends</div>
                    </div>
                    <div class="graph-desc">
                        From ${start} to ${end}
                    </div>
                    <div id="curve_chart"></div>
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
                        
        <form action="changeMktGraph" id="changeGraph" method="POST"></form>
        
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
                        
        <script>
            $('#datepicker').daterangepicker({
                "showDropdowns": true,
                "startDate": '${start}',
                "endDate": '${end}',
                locale:{
                    format: 'YYYY/MM/DD'
                }
            }, function(start, end, label) {
              console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')');
            },);
            
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Date', 'Orders'],
                    <c:if test="${empty graph}">
                        ['', 0]
                    </c:if>
                    <c:if test="${not empty graph}">
                        <c:forEach var="order" items="${graph}">
                            ['${order.date}',  ${order.total}],
                        </c:forEach>
                    </c:if>
                ]);
                var options = {
                curveType: 'function',
                legend: { position: 'bottom' },
                width: 1450,
                height: 500,
                chartArea:{
                    left:24,top:8,width:'95%',height:'80%'
                }
                };
                var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                chart.draw(data, options);
            }
        </script>
        
    </body>
</html>
