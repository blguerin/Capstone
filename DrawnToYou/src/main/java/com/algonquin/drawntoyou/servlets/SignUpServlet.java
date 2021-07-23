package com.algonquin.drawntoyou.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.user.SignUpDatabase;

import java.io.IOException;
import java.sql.*;
import java.util.Random;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public String verificationCode() {
		Random randomInt = new Random();
		String verificationCodeNumber = "0000";
		
		return verificationCodeNumber;
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String emailAddress = request.getParameter("emailAddress");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    SignUpServlet getInfo = new SignUpServlet();
	    String verificationCode = getInfo.verificationCode();

	    request.setAttribute("firstName", firstName);
	    request.setAttribute("lastName", lastName);
	    request.setAttribute("emailAddress",emailAddress);
	    request.setAttribute("username", username);
	    request.setAttribute("password",password);
	    request.setAttribute("verificationCode", verificationCode);
	    	   	    
	    SignUpDatabase sendInfo = new SignUpDatabase();
	    sendInfo.setUsername(username);
	    sendInfo.setUsername(password);
	    sendInfo.setUsername(verificationCode);
	    
		Connection connection = ConnectDB.getInstance().getConnectionToDB();
    	      		try {		      
	    	    	  String query = " INSERT INTO drawntoyou.user (username, firstName, lastName, email, password, verificationCode)"+ 
	    	    			  			" values (?, ?, ?, ?, ?, ?)";
	    	    	   PreparedStatement preparedStmt = connection.prepareStatement(query);
	    	    	      preparedStmt.setString (1, username);
	    	    	      preparedStmt.setString (2, firstName);
	    	    	      preparedStmt.setString (3, lastName);
	    	    	      preparedStmt.setString (4, emailAddress);
	    	    	      preparedStmt.setString (5, password);
	    	    	      preparedStmt.setString (6, verificationCode);
	    	    	      preparedStmt.execute();
	    	  	         System.out.println("Values have been added to the table...."); 
	    	  	         
	    	  	      } catch (SQLException e) {
	    	  	    	  System.out.println("The user has either been created,\nor there was an error.");
	    	  	         e.printStackTrace();
	    	  	      }	    	      	    	      	    	      	    	     	    	      
	    	      response.sendRedirect("http://localhost:8080/DrawnToYou/verify.jsp");  	
		}
}

