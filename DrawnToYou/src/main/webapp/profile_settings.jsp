 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Settings | DrawnToYou</title>
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
		<center><h1 style="font-size:xx-large; background: -webkit-linear-gradient(#3e8bff, #ff5e84);-webkit-background-clip: text;-webkit-text-fill-color: transparent;position: relative; top:60px; position: relative; top: 10px;">Your Profile</h1></center>
		<form action="http://localhost:8080/DrawnToYou/change_profile_picture.jsp">
    		<input type="Submit" value="Change profile picture" style="color:white;height:30px;width:300px;border:none;border-radius:50px;background: linear-gradient(#3e8bff, #ff5e84); position: relative; top:130px;">
        </form>
        <form action="http://localhost:8080/DrawnToYou/change_bio.jsp">
    		<input type="Submit" value="Change biography" style="color:white;height:30px;width:300px;border:none;border-radius:50px;background: linear-gradient(#3e8bff, #ff5e84); position: relative; top:130px;">
        </form>
		
</div></center>

</body>
</html>