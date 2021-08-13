package com.algonquin.drawntoyou.servlets;

import com.algonquin.drawntoyou.dao.UserDAO;
import com.algonquin.drawntoyou.images.Artwork;
import com.algonquin.drawntoyou.images.Profile;
import com.algonquin.drawntoyou.reels.InReel;
import com.algonquin.drawntoyou.reels.OutReel;
import com.algonquin.drawntoyou.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;

	public void init() {
		userDao = new UserDAO();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);
		
		try {
            if (userDao.checkLogin(user)) {
                user = userDao.readUser(email);
                
                Profile profile = new Profile(user.getUsername());
                
                String username = profile.getUsername();
                String profilePicSource = profile.getProfilePicSource();
                String pinnedPicSource = profile.getPinnedPicSource();
                String bio = profile.getBio();
                
                InReel inReel = profile.getInReel();
                OutReel outReel = profile.getOutReel();
                           
                String inReel1 = inReel.getReelList().get(0).getSource();
                String inReel2 = inReel.getReelList().get(1).getSource();
                String inReel3 = inReel.getReelList().get(2).getSource();
                String inReel4 = inReel.getReelList().get(3).getSource();
                String inReel5 = inReel.getReelList().get(4).getSource();
                
                String inReelID1 = inReel.getReelList().get(0).getImageID().toString();
                String inReelID2 = inReel.getReelList().get(1).getImageID().toString();
                String inReelID3 = inReel.getReelList().get(2).getImageID().toString();
                String inReelID4 = inReel.getReelList().get(3).getImageID().toString();
                String inReelID5 = inReel.getReelList().get(4).getImageID().toString();
                
                String outReel1 = outReel.getReelList().get(0).getSource();
                String outReel2 = outReel.getReelList().get(1).getSource();
                String outReel3 = outReel.getReelList().get(2).getSource();
                String outReel4 = outReel.getReelList().get(3).getSource();
                String outReel5 = outReel.getReelList().get(4).getSource();
                
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
                
                request.setAttribute("username", username);
                request.setAttribute("profilePicSource", profilePicSource);
                request.setAttribute("pinnedPicSource", pinnedPicSource);
                request.setAttribute("bio", bio);
                
                request.setAttribute("inReel1", inReel1);
                request.setAttribute("inReel2", inReel2);
                request.setAttribute("inReel3", inReel3);
                request.setAttribute("inReel4", inReel4);
                request.setAttribute("inReel5", inReel5);
                
                request.setAttribute("inReelID1", inReelID1);
                request.setAttribute("inReelID2", inReelID2);
                request.setAttribute("inReelID3", inReelID3);
                request.setAttribute("inReelID4", inReelID4);
                request.setAttribute("inReelID5", inReelID5);
                
                request.setAttribute("outReel1", outReel1);
                request.setAttribute("outReel2", outReel2);
                request.setAttribute("outReel3", outReel3);
                request.setAttribute("outReel4", outReel4);
                request.setAttribute("outReel5", outReel5);

                requestDispatcher.forward(request, response);
                
                
			}
			else {
				response.sendRedirect("login.jsp");
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}


