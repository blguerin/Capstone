" was<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Drawn To You - Profile</title>
</head>
<body>
	<div style="text-align: center">
	<h1>Welcome to Drawn to You Profile</h1>
	<b>${user.username} ($user.email})</b>
	<br><br>
	<a href="/LogoutServlet">Logout</a>
	</div>

</body>
</html>