<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/29/21
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="data.entity.Product" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
    <style>
      body {
        margin: 0
      }

      #pageWrapper {
        width: 800px;
        margin: 0 auto;
        padding-top: 20px;
      }

      table, td, th {
        border: 2px solid black;
        align: center;
        width: 500px;
        padding: 5px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
      }

      th {
        padding: 10px;
      }

      td {
        text-align: center;
        vertical-align: middle;
      }

      a {
        text-decoration: none;
        color: blue;
        cursor: pointer;
      }
    </style>
</head>
<body>
<div id="pageWrapper">
    <div id="header">
        <h1>Sidney's Java Ecommerce Web</h1>
    </div>
    <p>We're a family run business offering the most exclusive luxury goods at record low
        prices!</p>
    <p>All of our products have been verified by multiple third party services!</p>
    <h3>See our Vendor partners <a href="ViewVendorsServlet">here!</a></h3>
    <h3>See our product Categories <a href="ViewVendorsServlet">here!</a></h3>
    <h1>Products</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Vendor</th>
            <th>Category</th>
            <th>Select Product</th>
        </tr>
        <%
            ArrayList<Product> products =
                    (ArrayList<Product>) request.getAttribute("products");
            for (Product p : products) {
        %>
        <tr>
            <td><%=p.getName()%>
            </td>
            <td><%=p.getDescription()%>
            </td>
            <td>$<%=p.getPrice()%>
            </td>
            <td><%=p.getVendor().getName()%>
            </td>
            <td><%=p.getCategory().getName()%>
            </td>
            <%--            TODO if have time to complete - ViewProductServlet --%>
            <td style="width: 500px"><a style="cursor: pointer;">Add to Cart</a></td>
        </tr>
        <%}%>
    </table>
    <div id="footer">
        <h5>Copyright 2021 Sidney Wells</h5>
    </div>
</div>
</body>
</html>
