<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery | DrawnToYou</title>
<link rel="stylesheet" href="css/login.css">

<ul>
  <a href="http://localhost:8080/DrawnToYou/login.jsp">
  <img src="images/logo.png" style="width:100px;height:100px;border-radius:7px;"/>
  </a>
</ul>

</head>

<body>
<img src="images/login2.gif" style="width:105%;height:90%;position:absolute; top:140px;left:-10px;z-index:1;">
<center><div class="sign-up-box">
	<div class="sign-up-text">
		<center><h1 style="font-size:xxx-large; background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;position: relative; top:60px;">Recover Password</h1></center>
		<form action="PasswordServlet" method="post">
			<input type="text" name="email" id="email" placeholder="Enter your email address..." style="height:30px;width:300px;background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;border:solid grey 1px; border-radius:50px;position: relative; top:100px;"><br>
			<input type="Submit" value="RECOVER PASSWORD" style="color:white;height:30px;width:300px;border:none;border-radius:50px;background: linear-gradient(#3e8bff, #ff5e84);position: relative; top:100px;">
		</form>
</a></div>
</div></center>
</body>
</html>