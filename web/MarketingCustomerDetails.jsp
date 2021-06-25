<%-- 
    Document   : userlistedit
    Created on : Jun 25, 2021, 11:53:09 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                  <li class="nav-item naviitem row" id="active">
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
                                <div class="col align-self-baseline"><img src="img/products.png" alt=""/></div>
                                <div class="col align-self-baseline" style="font-size: 19px;">Products</div>
                            </div>
                          </div>
                      </a>
                  </li>
                  
                  <!-- item 4 -->
                  <li class="nav-item naviitem row">
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
                    <div class="col-2" id="title" onclick="location.href='userlist.jsp';">
                        <span class="back"><i class="fas fa-angle-left"></i>&nbsp; Back to customers</span>
                    </div>
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
                        <div class="col-2 d-flex justify-content-start align-items-center" id="userid">Customer ID: 00001 <!--${param.id} --></div>
                        <div class="col-6 row"></div>
                        <div class="extended col-4 row d-flex"></div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Fullname<br>
                            <input class="editbox" form="updateform" value="Tran Tan Long">
                        </div>
                        <div class="col">
                            Gender<br>
                            <div class="select-wrapper">
                                <select id="role" class="editbox" form="updateform" name="slRole">
                                    <option value="0" selected="">Male</option>
                                    <option value="1">Female</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="infor row">
                        <div class="col">
                            Address<br>
                            <textarea class="editbox" form="updateform" style="height: 160px">228 Đường Man Thiện, Phường Tân Phú, Quận 9, Thành phố Hồ Chí Minh</textarea>
                        </div>
                        <div class="col">
                            Email<br>
                            <div class="userinfo" style="padding-left: 10px">longttse150883@fpt.edu.vn</div>
                            <div style="margin-top:18px;">Mobile</div>
                            <input class="editbox" form="updateform" value="0975926021"/>
                        </div>
                    </div>
                    <div class="infor row" id="lastrow">
                        <div class="col-6">
                            Status<br>
                            <div class="statuswrapper row d-flex align-items-end" style="margin:0;">
                                <div class="status enable col-3 d-flex align-items-center justify-content-center newstatus" id="createstatus">CUSTOMER</div>
                            </div>
                        </div>
                        <div class="col-2">
                            <input type="hidden" form="updateform" value=""/>
                        </div>
                        <div class="col-4">
                            <div class="savewrapper row d-flex align-items-end justify-content-end">
                                <div class="col d-flex justify-content-end" id="cancelbtn" onclick="location.href='';">Discard change</div>
                                <div class="col d-flex justify-content-end" style="padding:0;">
                                    <input type="submit" value="Save" name="btAction" id="createbtn" form="updateform"/>
                                </div>
                            </div>
                        </div>
                    </div>
                        
                        <hr>

                    <div class="listheader row">
                        <div class="col-2 d-flex justify-content-start align-items-center" id="userid">Changes History</div>
                    </div>
                    <table class="table table-hover" id="tbllist">
                      <thead>
                        <tr>
                          <th scope="col">Full Name</th>
                          <th scope="col">Gender</th>
                          <th scope="col">Address</th>
                          <th scope="col">Mobile</th>
                          <th scope="col">Updated Date</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr style="height: 100px;">
                          <td class="align-middle">Tran Tan Long</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">123, Binh Tien, phuong 4, quan 6, TPHCM</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
                        </tr> 
                        <tr style="height: 100px;">
                          <td class="align-middle">Nguyen Pham Minh Quan</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">25C4, khu pho 11, phuong Tan Phong, thanh pho Bien Hoa, tinh Dong Nai</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
                        </tr> 
                        <tr style="height: 100px;">
                          <td class="align-middle">Tran Tan Long</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">123, Binh Tien, phuong 4, quan 6, TPHCM</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
                        </tr> 
                        <tr style="height: 100px;">
                          <td class="align-middle">Tran Tan Long</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">123, Binh Tien, phuong 4, quan 6, TPHCM</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
                        </tr> 
                        <tr style="height: 100px;">
                          <td class="align-middle">Tran Tan Long</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">123, Binh Tien, phuong 4, quan 6, TPHCM</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
                        </tr> 
                        <tr style="height: 100px;">
                          <td class="align-middle">Tran Tan Long</td>
                          <td class="align-middle">Male</td>
                          <td class="align-middle">123, Binh Tien, phuong 4, quan 6, TPHCM</td>
                          <td class="align-middle">0987654321</td>
                          <td class="align-middle" style="width:150px;">26/05/2021</td>
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
        
        <form action="" id="updateform"></form>
    </body>
</html>
