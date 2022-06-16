<%-- 
    Document   : login
    Created on : Jun 15, 2022, 5:29:06 PM
    Author     : maged
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="password" name="password" value="${password}">
            <br>
            <input type="submit" name="login" value="Log in">
        </form>
        <br>
        <p>${message}</p>
    </body>
</html>
