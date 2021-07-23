package com.algonquin.drawntoyou.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.dao.UserDAO;
import com.algonquin.drawntoyou.user.PasswordEmail;
import com.algonquin.drawntoyou.user.SendEmail;
import com.algonquin.drawntoyou.user.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/PasswordServlet")
public class PasswordServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	    String email = request.getParameter("emailAddress");
//	    UserDAO user = new UserDAO();
//	    String password = user.readUser(email).getPassword();

	    processRequest(request, response);	    
		}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("test/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			String email = request.getParameter("email");
			UserDAO user = new UserDAO();
			String password = user.readUser(email).getPassword();
			
			PasswordEmail pass = new PasswordEmail();
			
			User user2 = new User(email, password);
			boolean test = pass.sendEmail(user2);
			
			if(test) {
				response.sendRedirect("login.jsp");
				System.out.println("Email successful");
			}
			else {
				System.out.println("Verification email failed.");
			}
		}
	}
	
}
