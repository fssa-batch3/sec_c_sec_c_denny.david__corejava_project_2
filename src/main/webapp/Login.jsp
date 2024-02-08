<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/css/Login.css">
    <title>Document</title>
</head>
<body>
   
    <div class ="login">
        <img src="https://iili.io/JH93z0l.png" alt="error">
    <div class="login-detail">
    <h2> Login Here</h2>
    <p>Enter your credentials to access your account</p>
    <form action=Login method="get"> 
    <div class="inputs">
    <input type="email" placeholder="Enter your email" id="email"></input><br><br>
    <input type="password" placeholder="Enter your password" id="password"></input><br><br>
    </div>
    <a href="home.jsp"><button type="submit"> Log in </button></a>
    </form>
</div>
</div>
</body>
</html>