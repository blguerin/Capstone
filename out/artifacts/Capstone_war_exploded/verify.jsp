<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify your account | DrawnToYou</title>
</head>
<body>
	<H1>Verify your account</H1><br>
	<p>A verification code was sent to your email, please check your inbox and enter the verification code found within the email.</p>
	<p><b>FOR MVP PURPOSES: </b>your verification code is <b>0000</b></p>
	<form action="VerifyServlet" method="get">
	Enter your verification code:<input type="text" name="verificationCode" id="verificationCode"><br>
	<input type="Submit" value="Submit">
	</form>
</body>
</html>