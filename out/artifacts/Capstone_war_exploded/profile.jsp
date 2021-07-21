<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
		<form action="LogoutServlet" method="post">
		<button type="submit">Logout</button>
		</form>
	</div>
	
	<%-- This is a JSP comment --%>
	<%--  --%>
	<%-- "<% %>" lets you include java code right in the JSP file. Uncomment the example below --%>
	<%-- <h2><% out.println("g'day"); %></h2> --%>
	
	
	<%-- Each user can have only one profile picture (perhaps tied to user object with a src URL or otherwise --%>
	<%-- drawn from the PROFILEPIC table where user column could have UNIQUE constraint. --%>
	
	<%-- TO DO: decide how to implement crud on profile pic, pinned portrait, bio, etc. Add buttons accordingly --%>
	
	<div id="personalizedSection">
        <img id="profilePicture" alt="Profile Picture">
        <div id="bio">
            <h3 align="center">Bio</h3>
            <p align="center">blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah <p>
        </div> 
        <img id="pinnedPortrait" alt="Pinned Portrait" src="" width="250" height="250">
    </div>
    
    
    <%-- These reels will be populated by their respective image objects ProfilePic and Artwork --%>
    <%-- ArrayLists of these objects will be drawn from the DB that will be used to populate these reels --%>
    <%-- Probably sorted by order in DB at first, but can different sorting methods can be implemented later --%>
    <div id="inReel" class="reel">
        <img id="inPic1" class="thumbnail" alt="X" src="">
        <img id="inPic2" class="thumbnail" alt="X" src="">
        <img id="inPic3" class="thumbnail" alt="X" src="">
        <img id="inPic4" class="thumbnail" alt="X" src="">
        <img id="inPic5" class="thumbnail" alt="X" src="">
    </div>
    <div id="outReel" class="reel">
        <img id="outPic1" class="thumbnail" alt="X" src="">
        <img id="outPic2" class="thumbnail" alt="X" src="">
        <img id="outPic3" class="thumbnail" alt="X" src="">
        <img id="outPic4" class="thumbnail" alt="X" src="">
        <img id="outPic5" class="thumbnail" alt="X" src="">
    </div>
</body>
</html>
