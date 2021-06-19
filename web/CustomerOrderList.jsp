<%-- 
    Document   : CustomerOrderList
    Created on : Jun 16, 2021, 1:19:47 AM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Customer Order List</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/CustomerOrderList.css">
    </head>

    <body>
        <!--header-->
        <%@include file="header.jsp" %>

        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-3">
                    <div class="col">
                        <form action="" class="col-sm-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-sm-10" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-sm-2">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <div class="category">
                            <a href="">Smartphone</a>
                        </div>
                        <div class="category">
                            <a href="">Laptop</a>
                        </div>
                        <div class="category">
                            <a href="">Smartwatch</a>
                        </div>
                        <div class="category">
                            <a href="">Earphone</a>
                        </div>
                    </div>
                </div>

                <!--Main content-->
                <div class="main-content container col-9" style="min-height: 700px;">
                    <h1>Your Orders</h1>
                    <div class="order-list container">
                        <table class="table">
                            <thead>
                                <tr class="d-flex">
                                    <th scope="col" class="col-1">ID</th>
                                    <th scope="col" class="col-2">Date</th>
                                    <th scope="col" class="col-5">Products</th>
                                    <th scope="col" class="col-2">Total</th>
                                    <th scope="col" class="col-2">Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="d-flex">
                                    <td class="col-1"><a href="">1234</a></td>
                                    <td class="col-2">22/5/2021</td>
                                    <td class="col-5">Vintage typewriter and 1 more product</td>
                                    <td class="col-2">$81.91</td>
                                    <td class="col-2">Submitted</td>
                                </tr>
                                <tr class="d-flex">
                                    <td class="col-1"><a href="">1234</a></td>
                                    <td class="col-2">22/5/2021</td>
                                    <td class="col-5">Vintage typewriter and 1 more product</td>
                                    <td class="col-2">$81.91</td>
                                    <td class="col-2">Submitted</td>
                                </tr>
                                <tr class="d-flex">
                                    <td class="col-1"><a href="">1234</a></td>
                                    <td class="col-2">22/5/2021</td>
                                    <td class="col-5">Vintage typewriter and 1 more product</td>
                                    <td class="col-2">$81.91</td>
                                    <td class="col-2">Submitted</td>
                                </tr>
                                <tr class="d-flex">
                                    <td class="col-1"><a href="">1234</a></td>
                                    <td class="col-2">22/5/2021</td>
                                    <td class="col-5">Vintage typewriter and 1 more product</td>
                                    <td class="col-2">$81.91</td>
                                    <td class="col-2">Submitted</td>
                                </tr>
                                <tr class="d-flex">
                                    <td class="col-1"><a href="">12341</a></td>
                                    <td class="col-2">22/5/2021</td>
                                    <td class="col-5">Vintage typewriter and 1 more product</td>
                                    <td class="col-2">$81.91</td>
                                    <td class="col-2">Submitted</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>

        <!--Footer-->
        <%@include file="footer.html" %>
    </body>
</html>
