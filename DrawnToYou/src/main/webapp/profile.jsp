<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile | DrawnToYou</title>
<link rel="stylesheet" href="css/profile.css">

<ul>
  <a href="http://localhost:8080/DrawnToYou/login.jsp">
  <img src="images/logo.png" style="width:100px;height:100px;border-radius:7px;"/>
  </a>
</ul>

<a style="text-decoration:none;" href="http://localhost:8080/DrawnToYou/profile_settings.jsp">
  <div class="profile_picture">
  	<img class="profile_picture_image" src="images/user.png"/>
  </div>
    	<h1 class="your_profile_text">Your profile</h1>
</a>

</head>
    
    <%-- These reels will be populated by their respective image objects ProfilePic and Artwork --%>
    <%-- ArrayLists of these objects will be drawn from the DB that will be used to populate these reels --%>
    <%-- Probably sorted by order in DB at first, but can different sorting methods can be implemented later --%>
    <div  class="reel">
    <center>
    	<h1 style="color: white; font-family:'Helvetica'; font-size:30px;">ARTWORK CURATED FOR YOU:</h1>
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png">
        <img   class="images-in-reel" alt="X" src="images/logo.png"></center>
    </div>
    
    <div class="biography">
    	<center><h1 style="font-family:'Helvetica';font-size:60px;">About You</h1></center>
    </div>

</body>
</html>
