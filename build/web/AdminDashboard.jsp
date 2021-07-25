<%-- 
    Document   : userlist
    Created on : Jun 15, 2021, 10:19:46 PM
    Author     : Admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="https://use.fontawesome.com/releases/v5.0.1/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/userlist.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/salelist.css"/>
        <link rel="stylesheet" href="css/dashboard.css"/>
        <link rel="stylesheet" href="css/admindashboard.css"/>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statuschange.js"></script>
        <script src="js/datepicker.js"></script>
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
        <c:set var="subOrders" value="${sessionScope.SUBMITTED_ORDERS}"/>
        <c:set var="conOrders" value="${sessionScope.CONFIRMED_ORDERS}"/>
        <c:set var="shipOrders" value="${sessionScope.SHIPPED_ORDERS}"/>
        <c:set var="potCustomers" value="${sessionScope.POTENTIAL_CUSTOMERS}"/>
        <c:set var="Customers" value="${sessionScope.CUSTOMERS}"/>
        <c:set var="ratedStars" value="${sessionScope.RATED_STAR_LIST}"/>
        <c:set var="revenue" value="${sessionScope.REVENUE}"/>
        <c:set var="graph" value="${sessionScope.GRAPH}"/>
        <c:set var="start" value="${sessionScope.DATESTART}"/>
        <c:set var="end" value="${sessionScope.DATEEND}"/>
        <c:set var="status" value="${sessionScope.STATUS}"/>
        <c:set var="totalOrder" value="${subOrders+conOrders+shipOrders}"/>
        <c:set var="totalCustomer" value="${potCustomers+Customers}"/>
        <c:set var="totalRevenue" value="${0}"/>
        <c:forEach var="rev" items="${revenue}">
            <c:if test="${not empty rev.revenue}">
                <c:set var="totalRevenue" value="${totalRevenue+rev.revenue}"/>
            </c:if>
        </c:forEach>
        <c:set var="fmTotalRevenue"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${totalRevenue}"/></c:set>
        <div class="wrapper row" style="margin:0;padding:0; max-width: 100%;">
            <div class="wrapper col-2" style="background-color: #363740; min-height:937px; padding-right: 0;">
              <ul class="nav flex-column col">
                  
                  <!-- header -->
                  <li class="nav-item" id="header" onclick="location.href='AdminDashboard'">
                    <div class="navbar-brand" href="#">
                        <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col"><img src="img/logo.png" alt=""/></div>
                                <div class="col">Admin <br> Dashboard</div>
                            </div>
                        </div>
                    </div>
                  </li>
                  
                  <!-- item 1 -->
                  <li class="nav-item naviitem row" id="active" onclick="location.href='AdminDashboard'">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/dashboard-chosen.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Overview</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 2 -->
                  <li class="nav-item naviitem row" onclick="location.href='viewUserList'">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/users.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Users</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <li class="nav-item naviitem row divider"></li>
              </ul>
            </div>

            <div class="wrapper col-10" style="background-color: #F7F8FC; padding: 30px 33px 30px 45px;" id="maincontent">
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
                <div class="picker row">
                    <div class="col-3 sale-member picker-title"><span id="session-role">Orders</span><br>
                        <div class="select-wrapper">
                            <select class="d-flex align-items-center admin-filter" id="slOrder">
                                <option value="${totalOrder}" selected>Select status</option>
                                <option value="${subOrders}">Submitted</option>
                                <option value="${conOrders}">Confirmed</option>
                                <option value="${shipOrders}">Shipped</option>
                            </select>
                        </div><br>
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">New orders<br>
                                <span class="details" id="orderscount">
                                    ${totalOrder}
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title"><span id="session-role">Revenues</span><br>
                        <div class="select-wrapper">
                            <select class="d-flex align-items-center admin-filter" id="slRevenues">
                                <option value="${fmTotalRevenue}" selected>Select Category</option>
                                <option
                                    <c:set var="phoneRev" value="${0}"/>
                                    <c:forEach var="rev" items="${revenue}">
                                        <c:if test="${rev.categoryID==1}">
                                            <c:set var="phoneRev" value="${phoneRev+rev.revenue}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="phoneRev">
                                        <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${phoneRev}"/>
                                    </c:set>
                                    value="${phoneRev}">Phone</option>
                                
                                <option 
                                    <c:set var="laptopRev" value="${0}"/>
                                    <c:forEach var="rev" items="${revenue}">
                                        <c:if test="${rev.categoryID==2}">
                                            <c:set var="laptopRev" value="${laptopRev+rev.revenue}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="laptopRev">
                                        <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${laptopRev}"/>
                                    </c:set>
                                    value="${laptopRev}">Laptop</option>
                                
                                <option 
                                    <c:set var="tabletRev" value="${0}"/>
                                    <c:forEach var="rev" items="${revenue}">
                                        <c:if test="${rev.categoryID==3}">
                                            <c:set var="tabletRev" value="${tabletRev+rev.revenue}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="tabletRev">
                                        <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${tabletRev}"/>
                                    </c:set>
                                    value="${tabletRev}">Tablet</option>
                                
                                <option 
                                    <c:set var="smWatchRev" value="${0}"/>
                                    <c:forEach var="rev" items="${revenue}">
                                        <c:if test="${rev.categoryID==4}">
                                            <c:set var="smWatchRev" value="${smWatchRev+rev.revenue}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="smWatchRev">
                                        <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${smWatchRev}"/>
                                    </c:set>
                                    value="${smWatchRev}">Smartwatch</option>
                                
                                <option 
                                    <c:set var="earphoneRev" value="${0}"/>
                                    <c:forEach var="rev" items="${revenue}">
                                        <c:if test="${rev.categoryID==5}">
                                            <c:set var="earphoneRev" value="${earphoneRev+rev.revenue}"/>
                                        </c:if>
                                    </c:forEach>
                                    <c:set var="earphoneRev">
                                        <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${earphoneRev}"/>
                                    </c:set>
                                    value="${earphoneRev}">Earphone</option>
                            </select>
                        </div><br>
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">USD<br>
                                <span class="details" id="revenuescount">$${fmTotalRevenue}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title"><span id="session-role">Customers</span><br>
                        <div class="select-wrapper">
                            <select class="d-flex align-items-center admin-filter" id="slCustomers">
                                <option value="${totalCustomer}" selected>Select type</option>
                                <option value="${potCustomers}">Potential</option>
                                <option value="${Customers}">Customers</option>
                            </select>
                        </div><br>
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Customers<br>
                                <span class="details" id="customerscount">${totalCustomer}</span>
                            </div>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title"><span id="session-role">Feedbacks</span><br>
                        <div class="select-wrapper">
                            <select class="d-flex align-items-center admin-filter" id="slFeedbacks">
                                <option value="" selected>Select category</option>
                                <option
                                    <c:set var="fbPhone" value="${0}"/>
                                    <c:forEach var="fb" items="${ratedStars}">
                                        <c:if test="${fb.categoryID==1}">
                                            <c:set var="fbPhone" value="${fb.averageStar}"/>
                                        </c:if>
                                    </c:forEach>
                                    value="${fbPhone}">Phone</option>
                                <option
                                    <c:set var="fbLaptop" value="${0}"/>
                                    <c:forEach var="fb" items="${ratedStars}">
                                        <c:if test="${fb.categoryID==2}">
                                            <c:set var="fbLaptop" value="${fb.averageStar}"/>
                                        </c:if>
                                    </c:forEach>
                                    value="${fbLaptop}">Laptop</option>
                                <option
                                    <c:set var="fbTablet" value="${0}"/>
                                    <c:forEach var="fb" items="${ratedStars}">
                                        <c:if test="${fb.categoryID==3}">
                                            <c:set var="fbTablet" value="${fb.averageStar}"/>
                                        </c:if>
                                    </c:forEach>
                                    value="${fbTablet}">Tablet</option>
                                <option
                                    <c:set var="fbSmWatch" value="${0}"/>
                                    <c:forEach var="fb" items="${ratedStars}">
                                        <c:if test="${fb.categoryID==4}">
                                            <c:set var="fbSmWatch" value="${fb.averageStar}"/>
                                        </c:if>
                                    </c:forEach>
                                    value="${fbSmWatch}">Smartwatch</option>
                                <option
                                    <c:set var="fbEarphone" value="${0}"/>
                                    <c:forEach var="fb" items="${ratedStars}">
                                        <c:if test="${fb.categoryID==5}">
                                            <c:set var="fbEarphone" value="${fb.averageStar}"/>
                                        </c:if>
                                    </c:forEach>
                                    value="${fbEarphone}">Earphone</option>
                            </select>
                        </div><br>
                        <div class="admin-stats d-flex align-items-center justify-content-center">
                            <div class="details-header">Average stars<br>
                                <span class="details" id="feedbackscount">4.5</span>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="graph-filter row" style="padding:0; margin: 50px 0 0 0;">
                    <div class="input-group col-3 row" style="margin-right: 10px;">
                        <div class="input-group-prepend" style="height: 38px;">
                            <span class="input-group-text" id="basic-addon1" style="background-color:white; border: 1px #e3e3e3 solid; border-right-style: none;">
                                <i class="far fa-calendar-alt" style="font-size:22px;"></i>
                            </span>
                            <input type="text" value="" name="daterange" id="datepicker" class="datepicker" style="height: 38px; width: 310px;" form="changeGraph"/>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title">
                        <div class="select-wrapper">
                            <select class="d-flex align-items-center admin-filter" form="changeGraph" name="graphstatus">
                                <option value="" ${status == '2' ? '' : 'selected'}>Total</option>
                                <option value="2" ${status == '2' ? 'selected' : ''}>Shipped</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-3 sale-member picker-title">
                        <input type="submit" value="View" name="btAction" form="changeGraph"/>
                    </div>
                </div>
                
                <!-- main graph -->
                <div class="graphwrapper">
                    <!-- graph header -->
                    <div class="graph-header row">
                        <div class="col-12 d-flex justify-content-start align-items-center graphtitle" id="graph-title">Total order trends</div>
                    </div>
                    <div class="graph-desc" id="graph-description">
                        From ${start} to ${end}
                    </div>
                    <div id="curve_chart"></div>
                </div>
                
            </div>
        </div>
        
        <div class="popupwrapper" id="usermenu" style="padding:0;margin:0;">
            <div class="pro5 row popupitem">
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
            <div class="chgpsw row popupitem">
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
        <form id="changeGraph" action="changeAdminGraph" method="POST"></form>
                        
        <script>
            $('#datepicker').daterangepicker({
                "showDropdowns": true,
                "startDate":  moment().subtract('days', 7),
                "endDate": moment(),
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
                    left:35,top:8,width:'95%',height:'80%'
                }
                };
                var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
                chart.draw(data, options);
            }
        </script>
        <script>
        $(document).ready(function() {
            $('#slOrder').change(function(event) {
                $("#orderscount").text($(this).val());
            });
        });
        $(document).ready(function() {
            $('#slRevenues').change(function(event) {
                $("#revenuescount").text('$'+$(this).val());
            });
        });
        $(document).ready(function() {
            $('#slCustomers').change(function(event) {
                $("#customerscount").text($(this).val());
            });
        });
        $(document).ready(function() {
            $('#slFeedbacks').change(function(event) {
                $("#feedbackscount").text($(this).val());
            });
        });
        <c:if test="${not empty start || not empty end && status>=2}" >
            $(document).ready(function() {
                $('#graph-description').html('From ${start} to ${end}');
                $('#graph-title').html('Shipped order trends');
            });
        </c:if>
        <c:if test="${status < 2}" >
            $(document).ready(function() {
                $('#graph-description').html('From ${start} to ${end}');
                $('#graph-title').html('Total order trends');
            });
        </c:if>
        </script>
    </body>
</html>
