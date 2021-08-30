<%--
  Created by IntelliJ IDEA.
  User: sidneywells
  Date: 8/29/21
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="data.entity.Vendor" %>
<%@page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Vendors</title>
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
        <h3>See our product Categories <a href="ViewProductsByCategoriesServlet">here!</a></h3>
        <h3>See our Products <a href="ViewProductsServlet">here!</a></h3>
        <h1>Our Vendor Partners</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>City</th>
                <th>State</th>
                <th>Products</th>
            </tr>
            <%
                ArrayList<Vendor> vendors =
                        (ArrayList<Vendor>) request.getAttribute("vendors");
                for (Vendor v : vendors) {
            %>
            <tr>
                <td><%=v.getName()%>
                </td>
                <td><%=v.getDescription()%>
                </td>
                <td><%=v.getCity()%>
                </td>
                <td><%=v.getState()%>
                </td>
                <%--            TODO if have time to complete - viewProductsByVendor --%>
                <td style="width: 500px"><a style="cursor: pointer;">Vendor Products</a></td>
            </tr>
            <%}%>
        </table>
        <div id="footer">
            <h5>Copyright 2021 Sidney Wells</h5>
        </div>
</div>
</body>
</html>
