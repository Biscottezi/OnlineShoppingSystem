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
        <title>Order List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/userlist.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/salelist.css"/>
        <link rel="stylesheet" href="css/staffpop-up.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statuschange.js"></script>
        <script src="js/salemanager.js"></script>
        <script src="js/homepage.js"></script>
        <style>
            .status{
                width:100px;
                height:24px;
                border-radius: 24px;
                color: white;
                font-weight: 400;
            }
            .shipped{
                background: #29cc97;
            }
            .confirmed{
                background: #53D6FF;
            }
            .submitted{
                background: #FFCB15;
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
            .select-wrapper{
                width: 400px;
            }
            .select-wrapper::after{
                top: 0px;
            }
        </style>
    </head>
    <body style="width: 100%; height:100%; margin: 0; padding: 0; background-color: #F7F8FC">
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:set var="SaleList" value="${sessionScope.SALELIST}"/>
        <c:set var="orderList" value="${requestScope.ORDERLIST}"/>
        <div class="wrapper row" style="margin:0;padding:0; max-width: 100%;">
            <div class="wrapper col-2" style="background-color: #363740; min-height:937px; padding-right: 0;">
              <ul class="nav flex-column col">
                  
                  <!-- header -->
                  <li class="nav-item" id="header" onclick="location.href='SaleManagerDashboard';">
                    <div class="navbar-brand" href="#">
                        <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col"><img src="img/logo.png" alt=""/></div>
                                <div class="col">Sale <br> Dashboard</div>
                            </div>
                        </div>
                    </div>
                  </li>
                  
                  <!-- item 1 -->
                  <li class="nav-item naviitem row" onclick="location.href='SaleManagerDashboard';">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/dashboard.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Overview</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 2 -->
                  <li class="nav-item naviitem row" id="active" onclick="location.href='SaleManagerViewOrderList';">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/order-chosen.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Orders</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <li class="nav-item naviitem row divider"></li>
              </ul>
            </div>

            <div class="wrapper col-10" style="background-color: #F7F8FC; padding: 30px 33px 30px 45px;" id="maincontent">
                <!-- main title -->
                <div class="maintitle row" style="margin-bottom: 15px;">
                    <div class="col-2" id="title"><span>Orders</span></div>
                    <div class="col-7"></div>
                    <div class="col row">
                        <div class="d-flex justify-content-end col-10 align-items-center" id="user">
                            ${user.name}
                        </div>
                        <div class="profile col-2">
                            <div id="avatar" class="ava" style="background-image: url(img/${user.avatar});" onclick="showPopup()"></div>
                        </div>
                    </div>
                </div>
                <!-- session -->
                <div class="session-user row">
                    <div class="col-3 sale-member" id="title"><span id="session-role">Sale member</span><br>
                        <div class="select-wrapper">
                            <select id="table-filter" class="d-flex align-items-center">
                                <option value="" selected>Select sale</option>
                                <c:forEach var="sale" items="${SaleList}">
                                    <option value="${sale.name}">${sale.id} - ${sale.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-7"></div>
                    <div class="col row"></div>
                </div>
                
                
                <!-- main list -->
                <div class="listwrapper">
                    <!-- list header -->
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center" id="listtitle">List orders</div>
                        <div class="col-6 row">
                            <form action="" class="col-8 searchbar row">
                                <input type="text" placeholder="Search order" class="search-input col-10" name="txtSearchProduct" id="searchtable">
                                <button type="submit" id="search-button" class="col-2 button" name="btAction">
                                    <i class="fas fa-search" style="color: #C5C7CD"></i>
                                </button>
                            </form>
                        </div>
                        <div class="extended col-4 row d-flex">
                            <div class="col-6 d-flex align-items-center justify-content-end"></div>
                            <div class="col-3 d-flex align-items-center justify-content-end"></div>
                            <div class="col-3 d-flex align-items-center justify-content-end"><i class="fas fa-filter"></i>Filter</div>
                        </div>
                    </div>
                    
                    <table class="table table-hover" id="tbllist">
                      <thead>
                        <tr>
                          <th scope="col" style="text-align: center">ID</th>
                          <th scope="col">Products</th>
                          <th scope="col">Customer's name</th>
                          <th scope="col">Total Cost</th>
                          <th scope="col">Ordered Date</th>
                          <th scope="col">Status</th>
                          <th scope="col">Sale Member</th>
                        </tr>
                      </thead>
                      <tbody>
                          <c:forEach var="order" items="${orderList}">
                            <tr style="height: 92px;" onclick="location.href='saleOrderDet?orderId=${order.orderId}';">
                              <td class="align-middle" style="text-align: center">${order.orderId}</td>
                              <td class="align-middle">${order.details[0].productName} <c:if test="${(order.noOfProd - 1)>0}">and ${order.noOfProd - 1} other product${(order.noOfProd-1)>0?'s':''}</c:if></td>
                              <td class="align-middle">${order.customerName}</td>
                              <td class="align-middle">$${order.total}</td>
                              <td class="align-middle">${order.orderedDate}</td>
                              <td class="align-middle" style="width:150px;">
                                  <div class="d-flex align-items-center justify-content-center status 
                                        <c:if test="${order.status==2}">shipped</c:if>
                                        <c:if test="${order.status==1}">confirmed</c:if>
                                        <c:if test="${order.status==0}">submitted</c:if>">
                                      <c:choose>
                                          <c:when test="${order.status == 2}">
                                              SHIPPED
                                          </c:when>
                                          <c:when test="${order.status == 1}">
                                              CONFIRMED
                                          </c:when>
                                          <c:otherwise>
                                              SUBMIITED
                                          </c:otherwise>
                                      </c:choose>
                                  </div>
                              </td>
                              <td class="align-middle">
                                <c:forEach var="sale" items="${SaleList}">
                                    <c:if test="${sale.id == order.saleMemberId}">${sale.name}</c:if>
                                </c:forEach>
                              </td>
                            </tr>
                            </c:forEach>
                      </tbody>
                    </table> 
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
        
        <form action="createUser" id="createform" method="POST"></form>
    </body>
</html>
