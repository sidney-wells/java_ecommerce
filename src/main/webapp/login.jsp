<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/28/21
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
      body {
        margin: 0
      }

      #pageWrapper {
        width: 800px;
        margin: 0 auto;
        padding-top: 20px;
      }
    </style>
</head>
<body>
<div id="pageWrapper">
    <div id="header">
        <h1>Sidney's Java Ecommerce Web</h1>
    </div>
    <form action="LoginCustomerServlet" method="get">
        Email:<br>
        <input type="email" name="email" style="width:250px"
        /><br><br>
        Password:<br> <input type="text" name="password" style="width:150px"/><br><br>
        <input type="submit" value="Login">
    </form>
    <div id="footer">
        <h5>Copyright 2021 Sidney Wells</h5>
    </div>
</div>
</body>
</html>
