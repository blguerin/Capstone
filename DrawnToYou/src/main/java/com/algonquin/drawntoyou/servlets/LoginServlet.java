package com.algonquin.drawntoyou.servlets;

import com.algonquin.drawntoyou.dao.UserDAO;
import com.algonquin.drawntoyou.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
    /**
     * Default constructor. 
     */
   // public LoginServlet() {
    //    super();
    //}
	public void init() {
		userDao = new UserDAO();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(email, password);
		
		try {
			
			if (userDao.checkLogin(user)) {
				response.sendRedirect("profile.jsp");
				// TODO
				// Create or change user object with these credentials. pull the rest of the user's data from DB. This way all 
				// actions will be by the logged in user. Perhaps User should be singleton as well?
				
				// Also create a Profile object that will pull data from DB to load profilepic, pinned pic, and both reels.
			}
			else {
				response.sendRedirect("login.jsp");
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}


