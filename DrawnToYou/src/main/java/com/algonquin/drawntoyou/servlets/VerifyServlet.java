package com.algonquin.drawntoyou.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.dao.UserDAO;
import com.algonquin.drawntoyou.user.User;

import java.io.IOException;
import java.sql.*;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	    String verificationCode = request.getParameter("verificationCode");		 
		Connection connection = ConnectDB.getInstance().getConnectionToDB();
		 
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String code = request.getParameter("code");
         
		// Check the user's answer against the generated verification code.
		if (verificationCode.equals(code)) {
             
		    User user = new User(username, email, password);
         
		    // Save user in DB
		    UserDAO userDAO = new UserDAO();
		    userDAO.createUser(user);
         
		    // Create and save an initial profile for new user.
		    ProfileDAO profileDAO = new ProfileDAO();
		    profileDAO.createProfile(username);
         
		    response.sendRedirect("login.jsp");
		} else {
		    System.out.println("Failed");
		    response.sendRedirect("SignUp.jsp");
		}
	}
}	
    		
    
    
    
