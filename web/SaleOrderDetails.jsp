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
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/userlist.css"/>
        <link rel="stylesheet" href="css/editinfo.css"/>
        <link rel="stylesheet" href="css/saleorderdetails.css"/>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statuschange.js"></script>
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
        </style>
    </head>
    <body style="width: 100%; height:100%; margin: 0; padding: 0; background-color: #F7F8FC">
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:set var="SaleList" value="${sessionScope.SALELIST}"/>
        <c:set var="order" value="${requestScope.ORDER}"/>
        <c:set var="proCategory" value="${requestScope.PRODUCT_CATEGORY}"/>
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
            <c:set var="userdet" value="${requestScope.USER_DETAILS}"/>
            <div class="wrapper col-10" style="background-color: #F7F8FC; padding: 30px 33px 30px 45px;" id="maincontent">
                <!-- main title -->
                <div class="maintitle row">
                    <div class="col-2" id="title" onclick="location.href='<c:if test="${user.role==2}">SaleManagerViewOrderList</c:if>';">
                        <span class="back"><i class="fas fa-angle-left"></i>&nbsp; Back to orders</span>
                    </div>
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
                
                <!-- main list -->
                <div class="listwrapper">
                    <!-- list header -->
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center orderdet-header">Order ID: ${order.orderId}
                            <input type="hidden" value="${order.orderId}" name="selectedOrderID" form="updateform"/>
                        </div>
                        <div class="col-6 row"></div>
                        <div class="extended col-4 row d-flex"></div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Customer's fullname<br>
                            <div class="userinfo">${order.customer.name}</div>
                        </div>
                        <div class="col">
                            Email<br>
                            <div class="userinfo">${order.customer.email}</div>
                        </div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Ordered date<br>
                            <div class="userinfo">${order.orderedDate}</div>
                        </div>
                        <div class="col">
                            Mobile<br>
                            <div class="userinfo">${order.customer.phone}</div>
                        </div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Total cost<br>
                            <div class="userinfo">$${order.total}</div>
                        </div>
                        <div class="col">
                            Sale name<br>
                            <c:choose>
                                <c:when test="${user.role==2}">
                                    <div class="select-wrapper">
                                        <select id="salemem" class="editbox" form="updateform" name="slSaleMem">
                                            <c:forEach var="sale" items="${SaleList}">
                                                <option value="${sale.id}">${sale.id} - ${sale.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="userinfo">
                                        <c:forEach var="sale" items="${SaleList}">
                                            <c:if test="${sale.id == order.saleMemberId}">
                                                ${sale.id} - ${sale.name}
                                                <input type="hidden" name="txtSaleMemberID" value="${sale.id}" form="updateform"/>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="infor row lastrow">
                        <div class="col-6">
                            Status<br>
                            <div class="select-wrapper">
                                <select id="salemem" class="editbox" form="updateform" name="slStatus"  form="updateform">
                                        <option value="0">Submitted</option>
                                        <option value="1">Confirmed</option>
                                        <option value="2">Shipped</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-2"></div>
                        <div class="col-4">
                            <div class="savewrapper row d-flex align-items-end justify-content-end">
                                <div class="col d-flex justify-content-end" id="cancelbtn" onclick="location.href='<c:if test="${user.role==2}">SaleManagerViewOrderList</c:if>';">Discard change</div>
                                <div class="col d-flex justify-content-end" style="padding:0;">
                                    <button type="submit" style="margin-right:5px;" value="SMUpdate" name="btAction" id="createbtn" form="updateform">Save</button>
                                </div>
                            </div>
                        </div>
                    </div>
                                
                    <div class="separator col-12"></div>
                                
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center orderdet-header">Receiver</div>
                        <div class="col-6 row"></div>
                        <div class="extended col-4 row d-flex"></div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Fullname<br>
                            <div class="userinfo">${order.receiverName}</div>
                        </div>
                        <div class="col">
                            Gender<br>
                            <div class="userinfo">
                                <c:if test="${order.receiverGender==1}">Female</c:if>
                                <c:if test="${order.receiverGender==0}">Male</c:if>
                            </div>
                        </div>
                    </div>
                    <div class="infor row" style="margin-bottom:40px;">
                        <div class="col">
                            Address<br>
                            <div class="userinfo" id="addressinfo">${order.receiverAddress}</div>
                        </div>
                        <div class="col">
                            Email<br>
                            <div class="userinfo">${order.receiverEmail}</div>
                            <div style="margin-top:18px;">Mobile</div>
                            <div class="userinfo">${order.receiverPhone}</div>
                        </div>
                    </div>
                                
                    <div class="separator col-12"></div>
                    
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center orderdet-header">Ordered Products</div>
                        <div class="col-6 row"></div>
                        <div class="extended col-4 row d-flex"></div>
                    </div>
                    <table class="table table-hover" id="tbllist">
                      <thead>
                        <tr>
                          <th scope="col" style="text-align: center">Thumbnail</th>
                          <th scope="col">Title</th>
                          <th scope="col">Category</th>
                          <th scope="col">Unit Price</th>
                          <th scope="col">Quantity</th>
                          <th scope="col">Total cost</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="detail" items="${order.details}">
                        <tr style="height: 92px;">
                          <td class="align-middle d-flex align-items-center justify-content-center" style="text-align: center">
                              <div class="productthumb" style="background-image: url(img/${detail.thumbnail});"></div>
                          </td>
                          <td class="align-middle">${detail.productName}</td>
                          <td class="align-middle">
                              <c:forEach var="cate" items="${proCategory}">
                                  <c:if test="${cate.id == detail.proCategoryId}">
                                      ${cate.name}
                                  </c:if>
                              </c:forEach>
                          </td>
                          <td class="align-middle">
                              <c:choose>
                                            <c:when test="${detail.salePrice != 0}">$${detail.salePrice}</c:when>
                                            <c:otherwise>$${detail.listPrice}</c:otherwise>
                              </c:choose>
                          </td>
                          <td class="align-middle">${detail.quantity}</td>
                          <td class="align-middle">$${detail.detailTotal}</td>
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
        
        <form action="updateUserDetails" id="updateform" method="POST"></form>
    </body>
</html>
