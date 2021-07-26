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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/pop-up.css">
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/userlist.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="css/staffpop-up.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="js/tbllist.js"></script>
        <script src="js/managerpopup.js"></script>
        <script src="js/upload.js"></script>
        <script src="js/statuschange.js"></script>
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
            .input-title{
                padding: 0;
                font-size: 19px;
                font-weight: 600;
                color: black;
            }
            #prod-dscrpt{
                width: 1080px;
                height: 170px;
                color: black;
                font-size: 22px;
            }
            #createpopup{
                overflow: auto;
                padding-bottom: 35px;
            }
            .info{
                margin-left: 4em;
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
                                <div class="col">Marketing <br> Dashboard</div>
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
                  <li class="nav-item naviitem row" id="active">
                      <a class="navbar-brand overview" href="mktProductList">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/products-chosen.png" alt=""/></div>
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
                <div class="maintitle row">
                    <div class="col-2" id="title"><span>Products</span></div>
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
                
                <!-- main list -->
                <div class="listwrapper">
                    <!-- list header -->
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center" id="listtitle">All products</div>
                        <div class="col-6 row">
                            <form action="" class="col-8 searchbar row">
                                <input type="text" placeholder="Search product" class="search-input col-10" name="txtSearchProduct" id="searchtable">
                                <button type="submit" id="search-button" class="col-2 button" name="btAction">
                                    <i class="fas fa-search" style="color: #C5C7CD"></i>
                                </button>
                            </form>
                        </div>
                        <div class="extended col-4 row d-flex">
                            <div class="col-6 d-flex align-items-center justify-content-end">
                                <div class="addbtn d-flex align-items-center justify-content-center" id="adduser" onclick="showCreatePopup()">Add Product</div>
                            </div>
                            <div class="col-3 d-flex align-items-center justify-content-end"><i class="fas fa-sort-amount-up"></i>Sort</div>
                            <div class="col-3 d-flex align-items-center justify-content-end"><i class="fas fa-filter"></i>Filter</div>
                        </div>
                    </div>
                    
                    <table class="table table-hover" id="tbllist">
                      <thead>
                        <tr>
                          <th scope="col" style="text-align: center">ID</th>
                          <th scope="col">Thumbnail</th>
                          <th scope="col">Title</th>
                          <th scope="col">Category</th>
                          <th scope="col">Price</th>
                          <th scope="col">Sale Price</th>
                          <th scope="col">Featured</th>
                          <th scope="col">Status</th>
                        </tr>
                      </thead>
                      <c:set var="products" value="${requestScope.PRODUCT_LIST}"/>
                      <tbody>
                            <c:forEach var="product" items="${products}">
                                <tr style="height: 92px;" onclick="location.href='mktProdDetails?productID=${product.id}'">
                                    <td class="align-middle" style="text-align: center">${product.id}</th>
                                    <td class="align-middle">
                                        <img src="img/${product.thumbnail}" alt="product thumbnail" style="height: 92px">
                                    </td>
                                    <td class="align-middle">${product.title}</td>
                                    <td class="align-middle">
                                        <c:choose>
                                            <c:when test="${product.categoryId == 1}">Phone</c:when>
                                            <c:when test="${product.categoryId == 2}">Laptop</c:when>
                                            <c:when test="${product.categoryId == 3}">Tablet</c:when>
                                            <c:when test="${product.categoryId == 4}">Smartwatch</c:when>
                                            <c:when test="${product.categoryId == 5}">Earphone</c:when>
                                        </c:choose>
                                    </td>
                                    <td class="align-middle">$${product.listPrice}</td>
                                    <td class="align-middle">
                                        <c:choose>
                                            <c:when test="${product.salePrice != 0}">$${product.salePrice}</c:when>
                                            <c:otherwise>None</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="align-middle">
                                        <c:choose>
                                            <c:when test="${product.featured == 1}">On</c:when>
                                            <c:otherwise>Off</c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="align-middle" style="width:150px;">
                                        <c:choose>
                                            <c:when test="${product.status == 1}">
                                                <div class="d-flex align-items-center justify-content-center status enable">SELLING</div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="d-flex align-items-center justify-content-center status disable">NOT SELLING</div>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                </tr>
                            </c:forEach>
                      </tbody>
                    </table> 
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
            <div class="signout row popupitem" onclick="location.href='homepage.jsp';">
                <div class="col-3 d-flex align-items-center justify-content-center" id="signout">
                    <div class="menuitemicon" style="background-image: url(img/signout.png);"></div>
                </div>
                <div class="col-9 d-flex align-items-center description menu-itemtitle">Sign Out</div>
            </div>
        </div>
        
        <div class="popupwrapperadd" id="createpopup">
            <div class="title row">Add Product</div>
            <div class="info row">
                <div class="col">
                    Title<br>
                    <input class="inputbox" type="text" name="productTitle" value="" form="createform" required/>
                </div>
                <div class="col">
                    Category<br>
                    <select id="gender" class="inputbox" form="createform" name="productCategory" required>
                        <option value="" selected disabled hidden>Select category</option>
                        <option value="1">Phone</option>
                        <option value="2">Laptop</option>
                        <option value="3">Tablet</option>
                        <option value="4">Smartwatch</option>
                        <option value="5">Earphone</option>
                    </select>
                </div>
            </div>
            <div class="info row">
                <div class="col">
                    Thumbnail<br>
                    <div class="avawrapper row">
                        <img id="avapreview" class="col-3" src="http://placehold.it/180" onchange="showPreview();">
                        <input type="file" id="upload" hidden="hidden" onchange="readURLThumb(this);" form="createform" name="productThumbnail"/>
                        <div class="col-4 d-flex align-items-end" style="padding-top: 117px;">
                            <label for="upload" class="d-flex align-items-center justify-content-center uplbtn">
                                <i class="fas fa-upload" style="margin-right:10px;"></i>Upload file
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col">
                    Quantity<br>
                    <input class="inputbox" type="number" name="productQuantity" value="" form="createform" required/>
                    <br>
                    <div style="margin-top:12px;">Price</div>
                    <input class="inputbox" type="number" name="productBasePrice" value="" form="createform" required/>
                </div>
            </div>
            <div class="info row">
                <div class="col">
                    Brief Info<br>
                    <textarea class="inputbox" id="address" type="text" name="productBriefInfo" value="" form="createform" required></textarea>
                </div>
                <div class="col">
                    Sale Price<br>
                    <input class="inputbox" type="number" name="productSalePrice" value="" form="createform"/>
                    <br>
                    <div style="margin-top:12px;">Featured</div>
                    <input type="checkbox" name="productFeatured" value="ON" checked="checked" id="" class="col-1"  form="createform" style="zoom: 2; margin-top: 1em"/>
                </div>
            </div>
            <div class="info">
                <p class="input-title">Description</p>
                <textarea class="inputbox" id="prod-dscrpt" form="createform" name="productDescription" required></textarea>
                <p class="input-title" style="margin-top: 1em">Attached Images</p>
                <div class="avawrapper" style="margin-top: 20px; margin-bottom: 1.5em">
                    <input type="file" id="upload-attached" form="createform" multiple name="productAttachedImage">
                    <div class="col-4 d-flex align-items-end">
                        <!--<label for="upload-attached" class="d-flex align-items-center justify-content-center uplbtn">
                            <i class="fas fa-upload" style="margin-right:10px;"></i>Upload file
                        </label>-->
                    </div>
                </div>
            </div>
            <div class="info row">
                <div class="col-6">
                    Status<br>
                    <div class="statuswrapper row d-flex align-items-end">
                        <div class="status enable col-3 d-flex align-items-center justify-content-center newstatus" id="createstatus">ENABLED</div>
                        <input type="checkbox" name="productStatus" value="1" checked="checked" id="statuschkbox" class="col-1"  form="createform"/>
                    </div>
                </div>
                <div class="col-2"></div>
                <div class="col-4">
                    <div class="savewrapper row d-flex align-items-end">
                        <div class="col" id="cancelbtn" onclick="closeCreatePopup();">Cancel</div>
                        <div class="col" style="padding-right: 56px;">
                            <input type="submit" value="Create" name="btAction" id="createbtn" form="createform"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        

        
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
        
        <form action="addProduct" id="createform" method="POST" enctype="multipart/form-data"></form>
        <script>
                $('#createform').submit(function() {
                    var form = document.getElementById('createform');
                    var fi = document.getElementById('upload-attached');
                    for (var i = 0; i <= fi.files.length -1; i++){
                        var fname = fi.files.item(i).name;
                        var input = document.createElement('input');
                        input.setAttribute('name', 'fileNameList');
                        input.setAttribute('value', fname);
                        input.setAttribute('type', 'hidden');
                        form.appendChild(input);
                    }

                    return true; // return false to cancel form action
                });
        </script>
    </body>
</html>
