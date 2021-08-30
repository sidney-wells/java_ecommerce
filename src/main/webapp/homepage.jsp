<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/29/21
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
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
    <%
        String firstName = (String) request.getAttribute("firstName");
    %>
    <h2>Welcome,   <%= firstName.toUpperCase() %>
    </h2>
    <h3>View our Vendor partners <a style="text-decoration: none; color: blue; font-size: 24px;"
                                    href="ViewVendorsServlet">here!</a></h3>
    <h3>You can explore our products <a style="text-decoration: none; color: blue; font-size: 24px;"
                                        href="ViewProductsServlet">here!</a></h3>
    <h3>View our product categories <a style="text-decoration: none; color: blue; font-size: 24px;"
                                       href="ViewProductsByCategoriesServlet">here!</a></h3>
    <div id="footer">
        <h5>Copyright 2021 Sidney Wells</h5>
    </div>
</div>
</body>
</html>
