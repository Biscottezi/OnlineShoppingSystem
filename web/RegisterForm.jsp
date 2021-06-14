<%-- 
    Document   : RegisterForm
    Created on : Jun 13, 2021, 7:42:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <c:set var="errObj" value="${requestScope.errObj}"/> 

        <h1>Register</h1> 
        <form action="register" method="POST">
            Email (*): <input type="text" name="email" value="${requestScope.wrongUsername}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.emailErr}">
                    <td>
                        <font color="red">${errObj.usernameErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            Password (*): <input type="password" name="password" value="${requestScope.wrongPassword}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.passErr}">
                    <td>
                        <font color="red">${errObj.passErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            Confirm Password (*): <input type="password" name="confirmPassword" value="${requestScope.wrongConfirmPassword}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.confirmpassErr}">
                    <td>
                        <font color="red">${errObj.confirmpassErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            Full name : <input type="text" name="fullname" value="${requestScope.wrongFullname}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.fullnameErr}">
                    <td>
                        <font color="red">${errObj.fullnameErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            Address : <input type="text" name="address" value="${requestScope.wrongAddress}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.addressErr}">
                    <td>
                        <font color="red">${errObj.addressErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            Phone : <input type="number" name="phone" value="${requestScope.wrongPhone}" />
            <c:if test="${not empty errObj}">
                <c:if test="${not empty errObj.phoneErr}">
                    <td>
                        <font color="red">${errObj.phoneErr}</font> 
                    </td>
                </c:if>
            </c:if><br/>
            <input type="hidden" name="changed" value="TRUE" />
            <input type="submit" value="Register" />
        </form>
        <a href="login">Go back to login page</a>
    </body>
</html>
