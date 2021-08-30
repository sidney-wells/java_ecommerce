<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/28/21
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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
    <form action="createCustomer" method="get">
        First Name:<br> <input type="text" name="firstName" value="sidney" style="width:150px"/><br><br>
        Last Name:<br> <input type="text" name="lastName" value="wells"
                              style="width:150px"/><br><br>
        Email:<br> <input type="email" name="email" value="sidneywells101@gmail.com"
                          style="width:250px"/><br><br>
        Password:<br> <input type="text" name="password" value="password"
                             style="width:150px"/><br><br>
        <input type="submit" value="Sign Up">
    </form>
    <div id="footer">
        <h5>Copyright 2021 Sidney Wells</h5>
    </div>
</div>
</body>
</html>
