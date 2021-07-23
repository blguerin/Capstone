package com.algonquin.drawntoyou.servlets;

import com.algonquin.drawntoyou.dao.UserDAO;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;

	public void init() {
		userDao = new UserDAO();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);
		
		try {
            if (userDao.checkLogin(user)) {
                user = userDao.readUser(email);
                
                // This is my debugging tool
//                PrintWriter writer = response.getWriter();
//                writer.write("<!DOCTYPE html><html lang=\"en\"><body><h1>" + blah + "</h1></body></html>");
                
                Profile profile = new Profile(user.getUsername());
                
                String username = profile.getUsername();
                String profilePicSource = profile.getProfilePicSource();
                String pinnedPicSource = profile.getPinnedPicSource();
                String bio = profile.getBio();
//                InReel inReel = profile.getInReel();
//                OutReel outReel = profile.getOutReel();
//                
//                String inReel1 = inReel.getArtwork1().getSource();
//                String inReel2 = inReel.getArtwork2().getSource();
//                String inReel3 = inReel.getArtwork3().getSource();
//                String inReel4 = inReel.getArtwork4().getSource();
//                String inReel5 = inReel.getArtwork5().getSource();
//                
//                String outReel1 = outReel.getArtwork1().getSource();
//                String outReel2 = outReel.getArtwork2().getSource();
//                String outReel3 = outReel.getArtwork3().getSource();
//                String outReel4 = outReel.getArtwork4().getSource();
//                String outReel5 = outReel.getArtwork5().getSource();
//                
//                
//                
//                // Send profile to profile.jsp
                String destination = "profile.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
                
                request.setAttribute("username", username);
                request.setAttribute("profilePicSource", profilePicSource);
                request.setAttribute("pinnedPicSource", pinnedPicSource);
                request.setAttribute("bio", bio);
//                
//                request.setAttribute("inReel1", inReel1);
//                request.setAttribute("inReel2", inReel2);
//                request.setAttribute("inReel3", inReel3);
//                request.setAttribute("inReel4", inReel4);
//                request.setAttribute("inReel5", inReel5);
//                
//                request.setAttribute("outReel1", outReel1);
//                request.setAttribute("outReel2", outReel2);
//                request.setAttribute("outReel3", outReel3);
//                request.setAttribute("outReel4", outReel4);
//                request.setAttribute("outReel5", outReel5);
//               response.sendRedirect("profile.jsp"); 
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


