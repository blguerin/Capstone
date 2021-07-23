<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up | DrawnToYou</title>
<link rel="stylesheet" href="css/signUp.css">

<ul>
  <a href="http://localhost:8080/DrawnToYou/login.jsp">
  <img src="images/logo.png" style="width:100px;height:100px;border-radius:7px;"/>
  </a>
</ul>

</head>

<body>
<center><div class="sign-up-box">
	<div class="sign-up-text">
		<center><h1 style=" background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;">Sign Up</h1></center>
		<center><p1 style="position: relative; top: -20px;font-size:medium;color:grey;">To access the gallery, commission artists, or create your own artist profile:</p1></center>
		<form action="SignUpServlet" method="post">
		<input type="text" name="emailAddress" id="emailAddress" placeholder="Enter your email address..." style="height:30px;width:300px;background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;border:solid grey 1px; border-radius:50px;""><br>
		<input type="text" name="username" id="username" placeholder="Enter your username..." style="height:30px;width:300px;background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;border:solid grey 1px; border-radius:50px;"><br>
		<input type="password" name="password" id="password" placeholder="Enter your password..." style="height:30px;width:300px;background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;border:solid grey 1px; border-radius:50px;"><br>
		<input type="Submit" value="SUBMIT" style="color:white;height:30px;width:300px;border:none;border-radius:50px;background: linear-gradient(#3e8bff, #ff5e84);">
</form>
</div></center>
</body>
</html>
