<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sidney's Ecommerce Web</title>
    <style>
      body {
        margin: 0
      }

      #pageWrapper {
        width: 800px;
        margin: 0 auto;
      }

      #linkWrapper {
        display: flex;
        margin-top: 80px;
        margin-bottom: 80px;
      }

      a {
        text-decoration: none;
      }

      #signup {
        margin-right: 80px;
      }


      #signLink {
        color: white;
        background-color: black;
        border-radius: 10%;
        padding: 15px;
      }

      #loginLink {
        border: 2px solid black;
        border-radius: 10%;
        padding: 10px;
        color: black;
      }

    </style>
</head>
<body>
</h1>
<div id="pageWrapper">
    <div id="header">
        <h1>Sidney's Java Ecommerce Web</h1>
    </div>
    <div id="linkWrapper">

        <div id="signup">
            <a id="signLink" href="signUp.jsp">Sign Up</a><br/><br/>
        </div>
        <div id="login">
            <a id="loginLink" href="login.jsp">Login</a>
        </div>
    </div>
    <div id="footer">
        <h5>Copyright 2021 Sidney Wells</h5>
    </div>
</div>
</body>
</html>