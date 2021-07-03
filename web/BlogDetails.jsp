<%-- 
    Document   : BlogDetails
    Created on : Jun 19, 2021, 11:34:38 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Blog Details</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link rel="stylesheet" href="css/sider.css">
        <link rel="stylesheet" href="css/BlogDetails.css">
    </head>
    <body>
        
        <!--Header-->
        <%@include file="header.jsp" %>
        
        <main class="container">
            <div class="row">
                <!--Sider-->
                <div class="sider col-2">
                    <div class="col">
                        <form action="" class="col-12 searchbar">
                            <input type="text" placeholder="Search" class="search-input col-9" name="txtSearchProduct">
                            <button type="submit" id="search-button" class="col-3">
                                <i class="fas fa-search"></i>
                            </button>
                        </form>
                        <br>
                        <h4>Categories</h4>
                        <c:set var="postCategoryList" value="${requestScope.POST_CATEGORY}"/>
                        <c:forEach var="category" items="${postCategoryList}">
                            <div class="category">
                                <a href="">${category.name}</a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <!--Main content-->
                <div class="main-content container col-10">
                    <c:choose>
                        <c:when test="${not empty requestScope.POST_DETAILS}">
                            <c:set var="post" value="${requestScope.POST_DETAILS}"/>
                                <div class="col">
                                    <h3>${post.title}</h3>
                                    <p>${post.author} - ${post.createdDate}</p>
                                    <img src="img/${post.thumbnail}" alt="" class="post-img">
                                    <p class="post-body">${post.description}</p>
                                </div>
                        </c:when>
                        <c:otherwise>
                            <h3>Nothing</h3>
                        </c:otherwise>
                    </c:choose>
                    
                </div>
            </div>
        </main>
        
        <!--Footer-->
        <%@include file="footer.html" %>
        
    </body>
</html>
