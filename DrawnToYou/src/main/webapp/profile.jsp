<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<title>Drawn To You - Profile</title>
</head>
<body>
	<div style="text-align: center">
	<h1>Welcome to DrawnToYou, ${username}! </h1>
	    <form action="LogoutServlet" method="post">
	    <button type="submit">Logout</button>
	    </form>
	    <form action="EditBioServlet" method="post">
                <button type="submit" id="editBioButton">Edit Bio</button>
                <input type="hidden" name="username" value="${username}"/>
                <input type="hidden" name="bio" value="${bio}"/>
        </form>
	</div>
	
	<div id="personalizedSection">
	    <form action="XXXXXXXXXchoose profile picXXXXXXXXXX" method="post">
            <input type="image" id="profilePicture" src="${profilePicSource}" alt="Profile Picture">
        </form>
        <div id="bio">
            <h3 align="center">Bio</h3>
            <p align="center">${bio}<p>
        </div>
        <form action="XXXXXXXXXXXXchoose pinned portraitXXXXXXXXXXXXXXx" method="post">
            <input type="image" id="pinnedPortrait" src="${pinnedPicSource}" alt="Pinned Portrait">
        </form>    
    </div>
    
    
        <%-- Change all these forms so that they open up a new Profile based on the username tied to the image --%>
    <div id="inReel" class="reel">
        <form action="ArtworkOptionsServlet" method="post">
            <input type="image" id="inPic1" class="thumbnail" src="${inReel1}" alt="X">
            <input type="hidden" name="artID" value="${inReelID1}"/>
        </form>
        <form action="ArtworkOptionsServlet" method="post">
            <input type="image" id="inPic2" class="thumbnail" src="${inReel2}" alt="X">
            <input type="hidden" name="artID" value="${inReelID2}"/>
        </form>
        <form action="ArtworkOptionsServlet" method="post">
            <input type="image" id="inPic3" class="thumbnail" src="${inReel3}" alt="X">
            <input type="hidden" name="artID" value="${inReelID3}"/>
        </form>
        <form action="ArtworkOptionsServlet" method="post">
            <input type="image" id="inPic4" class="thumbnail" src="${inReel4}" alt="X">
            <input type="hidden" name="artID" value="${inReelID4}"/>
        </form>
        <form action="ArtworkOptionsServlet" method="post">
            <input type="image" id="inPic5" class="thumbnail" src="${inReel5}" alt="X">
            <input type="hidden" name="artID" value="${inReelID5}"/>
        </form>
    </div>
    <div id="outReel" class="reel">
            <img id="outPic1" class="thumbnail" src="${outReel1}" alt="X">
            <img id="outPic2" class="thumbnail" src="${outReel2}" alt="X">
            <img id="outPic3" class="thumbnail" src="${outReel3}" alt="X">
            <img id="outPic4" class="thumbnail" src="${outReel4}" alt="X">
            <img id="outPic5" class="thumbnail" src="${outReel5}" alt="X">
    </div>
</body>
</html>
