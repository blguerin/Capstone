<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up | DrawnToYou</title>
</head>

<body>
	<form action="SignUpServlet" method="get">
		Enter your first name:<input type="text" name="firstName" id="firstName"><br>
		Enter your last name:<input type="text" name="lastName" id="lastName"><br>
		Enter your email address:<input type="text" name="emailAddress" id="emailAddress"><br>
		Enter your username:<input type="text" name="username" id="username"><br>
		Enter your password:<input type="text" name="password" id="password"><br>
		<input type="Submit" value="Submit">
	</form>
</body>
</html>