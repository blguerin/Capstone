<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Edit Bio</title>
</head>
<body>
    <h1>Edit ${username}'s Bio</h1>
    <form action="UpdateBioServlet" method="post">
        <textarea id="newBio" name="newBio" rows="5" cols="33">${bio}</textarea>
        <input type="hidden" name="username" value="${username}"/>
        <button type="submit" id="editBioButton">Update</button>
    </form>
</body>
</html>