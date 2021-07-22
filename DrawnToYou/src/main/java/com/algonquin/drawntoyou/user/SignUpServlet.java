package com.algonquin.drawntoyou.user;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;








@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet
{

	
	private static final long serialVersionUID = 1L;
	  static final String DB_URL = "jdbc:mysql://localhost:3306/";
	  static final String DB_URL_WITH_TABLE = "jdbc:mysql://localhost:3306/DTY_USERS";
	  static final String USER = "administrator";
	  static final String PASS = "rootPasswordDrawn2You";
	  static final String DB = "DTY_USERS";





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
	    sendInfo.setEmail(emailAddress);
	    sendInfo.setEmail(password);
	    sendInfo.setEmail(verificationCode);
	    
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	     } 
		 catch (ClassNotFoundException e) {
	         System.out.println("Missing driver");
	         e.printStackTrace();
	     }
	    
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	         Statement stmt = conn.createStatement();
	    	      ) {		      
	    	         String sql = "CREATE DATABASE DTY_USERS;";
	    	         stmt.executeUpdate(sql);
	    	         System.out.println("Database created successfully...");   	  
	    	      } catch (SQLException e) {
	    	    	  System.out.println("The database has either been created,\nor there was an error.");
	    	         e.printStackTrace();
	    	      } 
	    	      
	    	      try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
	    	    	         Statement stmt = conn.createStatement();
	    	    	      ) {		      
	    	    	         String sql = "CREATE TABLE USER_INFO(EMAIL VARCHAR(20),PASSWORD VARCHAR(20),VERIFICATION_CODE VARCHAR(4));";
	    	    	         stmt.executeUpdate(sql);
	    	    	         System.out.println("Table created successfully....");   	  
	    	    	      } catch (SQLException e) {
	    	    	    	  System.out.println("The table has either been created,\nor there was an error.");
	    	    	         e.printStackTrace();
	    	    	      } 
	    	      
	    	      try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
	    	    		  
	    	  	      ) {		      
	    	    	  String query = " INSERT INTO USER_INFO (EMAIL,PASSWORD,VERIFICATION_CODE)"+ " values (?, ?, ?)";
	    	    	   PreparedStatement preparedStmt = conn.prepareStatement(query);
	    	    	      preparedStmt.setString (1, emailAddress);
	    	    	      preparedStmt.setString (2, password);
	    	    	      preparedStmt.setString   (3, verificationCode);
	    	    	      preparedStmt.execute();
	    	  	         System.out.println("Values have been added to the table....");   	  
	    	  	      } catch (SQLException e) {
	    	  	    	  System.out.println("The user has either been created,\nor there was an error.");
	    	  	         e.printStackTrace();
	    	  	      }
	    	      
	    	      
	    	      

	    	      
	    	      
	    	      response.sendRedirect("http://localhost:8080/DrawnToYou/verify.jsp");  
	


}
}
