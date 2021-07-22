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
	
	<%-- TODO: decide how to implement crud on profile pic, pinned portrait, bio, etc. Add buttons accordingly --%>
	
	<div id="personalizedSection">
	    <form action="XXXXXXXXXchoose profile picXXXXXXXXXX" method="post">
            <input type="image" id="profilePicture" src="https://picsum.photos/250" alt="Profile Picture">
        </form>
        <div id="bio">
            <h3 align="center">Bio</h3>
            <p align="center">blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah <p>
            <form action="XXXXXXXXXXedit bio servletXXXXXXXXXXXXXXXXXX" method="post">
                <button type="submit" id="editBioButton">Edit</button>
            </form>
        </div>
        <form action="XXXXXXXXXXedit bio servletXXXXXXXXXXXXXXXXXX" method="post">
                <button type="submit" id="editBioButton">Edit</button>
            </form>
        <form action="XXXXXXXXXXXXchoose pinned portraitXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="pinnedPortrait" src="https://picsum.photos/250" alt="Pinned Portrait">
        </form>    
    </div>
    
    
        <%-- Change all these forms so that they open up a new Profile based on the username tied to the image --%>
    <div id="inReel" class="reel">
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="inPic1" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="inPic2" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="inPic3" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="inPic4" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="inPic5" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
    </div>
    <div id="outReel" class="reel">
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="outPic1" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="outPic2" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="outPic3" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="outPic4" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
        <form action="XXXXXXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="outPic5" class="thumbnail" src="https://picsum.photos/100" alt="X" src="">
        </form>
    </div>
</body>
</html>
