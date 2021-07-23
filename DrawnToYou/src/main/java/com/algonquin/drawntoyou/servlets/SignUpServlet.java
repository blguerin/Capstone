package com.algonquin.drawntoyou.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.user.SendEmail;
import com.algonquin.drawntoyou.user.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

//	public int verificationCode() {
//		
//		Random rand = new Random();
//		int verificationCode = rand.nextInt(9999);
//		return verificationCode;
//	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    SignUpServlet getInfo = new SignUpServlet();
	    String emailAddress = request.getParameter("emailAddress");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
//	    int verificationCode = getInfo.verificationCode();

		Connection connection = ConnectDB.getInstance().getConnectionToDB();
    	      		try {		      
    	      		    String query = " INSERT INTO drawntoyou.USER (Username, Email, Password)"+ 
	    	    			  			" values (?, ?, ?)";
    	      		    PreparedStatement preparedStmt = connection.prepareStatement(query);
    	      		    preparedStmt.setString (1, username);
    	      		    preparedStmt.setString (2, emailAddress);
    	      		    preparedStmt.setString (3, password);
    	      		    preparedStmt.execute();
	    	  	        System.out.println("Values have been added to the table...."); 
	    	  	         
	    	  	        // Create initial profile
	    	  	        ProfileDAO profileDAO = new ProfileDAO();
	    	  	        profileDAO.createProfile(username);
	    	  	         
    	      		} catch (SQLException e) {
    	      		    System.out.println("The user has either been created,\nor there was an error.");
	    	  	        e.printStackTrace();
	    	  	    }
    	      		processRequest(request, response);	    
		}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("test/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			
			String email = request.getParameter("emailAddress");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			SendEmail sendEmail = new SendEmail();
			String code = sendEmail.verificationCode();
			
			User user = new User(username, email, password, code);
			boolean test = sendEmail.sendEmail(user);
			
			if(test) {
				response.sendRedirect("verify.jsp");
				System.out.println("Email successful");
			}
			else {
				System.out.println("Verification email failed.");
			}
		}
	}
	
}
