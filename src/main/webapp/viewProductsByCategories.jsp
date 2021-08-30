<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/29/21
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="data.entity.Product" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Categories</title>
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
    <%
        String firstName = (String) request.getAttribute("firstName");
    %>
    <h3>Welcome, <%= firstName.toUpperCase() %>
        <h3>We're a family run business offering the most exclusive luxury goods at record low
            prices!</h3>
        <h3>All of our products have been verified by multiple third party services!</h3>
        <h3>See our product Page <a href="ViewProductsServlet">here!</a></h3>
        <h3>See our Vendors <a href="ViewVendorsServlet">here!</a></h3>
        <h1>Products By Categories</h1>
        <table>
            <%
                ArrayList<Product> products =
                        (ArrayList<Product>) request.getAttribute("products");
                ArrayList<String> categories = new ArrayList<>();
                for (Product p : products) {
                    if (!categories.contains(p.getCategory().getName())) {
                        categories.add(p.getCategory().getName());
                    }
                }
                for (String s : categories) {
            %>
            <tr>
                <th style="background-color: black; color: white;"><%=s.toUpperCase()%>
                </th>
            </tr>
            <%
                for (Product p : products) {
                    if (s == p.getCategory().getName()) {
            %>
            <tr>
                <td><%=p.getName()%>
                </td>
            </tr>
            <%
                    }
                }%>

            <%}%>
        </table>
        <div id="footer">
            <h5>Copyright 2021 Sidney Wells</h5>
        </div>
</div>
</body>
</html>
