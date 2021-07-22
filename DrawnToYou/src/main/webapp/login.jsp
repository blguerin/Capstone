<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Drawn To You</title>
</head>
<body>
	<div style="text-align: center">
		<h1>Drawn To You</h1>
		<h2>Please Login</h2>
		<form action="LoginServlet" method="post">
		  <label for="email">Email address:</label>
		  <input name="email" size="30"/>
		  <br><br>
		  <label for="password">Password:</label>
		  <input type="password" name="password" size="30"/> 

		  <button type="submit">Login</button>
		</form>
	</div>
</body>

</html>
