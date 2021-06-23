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
        <title>Post List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/managersider.css">
        <link rel="stylesheet" href="css/userlist.css">
        <link rel="stylesheet" href="css/managerprofile.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.css"/>
        <script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.25/datatables.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
        <script src="js/tbllist.js"></script>
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
        </style>
    </head>
    <body style="width: 100%; height:100%; margin: 0; padding: 0; background-color: #F7F8FC">
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
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/users-chosen.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Customers</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 3 -->
                  <li class="nav-item naviitem row">
                      <a class="navbar-brand overview" href="#">
                          <div class="container">
                            <div class="row justify-content-md-center">
                                <div class="col align-self-baseline"><img src="img/products-chosen.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Products</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 4 -->
                  <li class="nav-item naviitem row" id="active">
                      <a class="navbar-brand overview" href="#">
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
                      <a class="navbar-brand overview" href="#">
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
                      <a class="navbar-brand overview" href="#">
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
                    <div class="col-2" id="title"><span>Posts</span></div>
                    <div class="col-7"></div>
                    <div class="col row">
                        <div class="d-flex justify-content-end col-10 align-items-center" id="user">
                            Trần Tân Long <!-- input jstl session user here! -->
                        </div>
                        <div class="profile col-2">
                            <div id="avatar" class="ava" style="background-image: url(img/tanlong.png);" onclick="showPopup()"></div> <!-- get session's avatar -->
                        </div>
                    </div>
                </div>
                
                <!-- main list -->
                <div class="listwrapper">
                    <!-- list header -->
                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center" id="listtitle">All Posts</div>
                        <div class="col-6 row">
                            <form action="" class="col-8 searchbar row">
                                <input type="text" placeholder="Search post" class="search-input col-10" name="txtSearchProduct" id="searchtable">
                                <button type="submit" id="search-button" class="col-2 button" name="btAction">
                                    <i class="fas fa-search" style="color: #C5C7CD"></i>
                                </button>
                            </form>
                        </div>
                        <div class="extended col-4 row d-flex">
                            <div class="col-6 d-flex align-items-center justify-content-end">
                                <div class="addbtn d-flex align-items-center justify-content-center" id="adduser" onclick="showCreatePopup()">Add Post</div>
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
                          <th scope="col">Author</th>
                          <th scope="col">Featured</th>
                          <th scope="col">Status</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">Dù LG đã ngừng sản xuất smartphone, dòng Velvet 2 Pro vẫn bị rò rỉ với cụm 3 camera sau, không phím vật lý.</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">Off</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status disable">
                                  DISABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                        <tr style="height: 92px;">
                          <td class="align-middle" style="text-align: center">00001</th>
                          <td class="align-middle">
                              <img src="img/post-thumbnail.jpg" alt="post thumbnail" style="height: 92px">
                          </td>
                          <td class="align-middle">TOP 5 chiếc laptop có cấu hình tốt nhất tầm giá dưới 15 triệu, rất phù hợp để học tập, làm việc tại nhà mùa Covid</td>
                          <td class="align-middle">Tu van</td>
                          <td class="align-middle">Tan Long</td>
                          <td class="align-middle">On</td>
                          <td class="align-middle" style="width:150px;">
                              <div class="d-flex align-items-center justify-content-center status enable">
                                  ENABLED
                              </div>
                          </td>
                        </tr>
                      </tbody>
                    </table> 
                </div>
                
            </div>
        </div>
        
        <div class="popupwrapper" id="usermenu" style="padding:0;margin:0;">
            <div class="pro5 row popupitem">
                <div class="col-3 d-flex align-items-center justify-content-center" style="padding:0;">
                    <div id="menuavatar" style="background-image: url(img/tanlong.png);"></div>
                </div>
                <div class="col-9 d-flex align-items-center description">
                    <div class="descwrapper">
                        <p class="menu-itemtitle">Trần Tân Long</p>
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
            <div class="signout row popupitem" onclick="location.href='homepage.jsp';">
                <div class="col-3 d-flex align-items-center justify-content-center" id="signout">
                    <div class="menuitemicon" style="background-image: url(img/signout.png);"></div>
                </div>
                <div class="col-9 d-flex align-items-center description menu-itemtitle">Sign Out</div>
            </div>
        </div>
        
        
    </body>
</html>
