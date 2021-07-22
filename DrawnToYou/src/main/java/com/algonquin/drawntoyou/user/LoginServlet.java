package com.algonquin.drawntoyou.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
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

		

	    String emailAddress = request.getParameter("email");
	    String password = request.getParameter("password");
	    SignUpServlet getInfo = new SignUpServlet();
	    String verificationCode = getInfo.verificationCode();
	    boolean doesExist = false;


	    request.setAttribute("emailAddress",emailAddress);
	    request.setAttribute("password",password);
	    request.setAttribute("verificationCode", verificationCode);
	    
	    
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
	    	  	 String sql = "SELECT * FROM DTY_USERS.USER_INFO WHERE (EMAIL,PASSWORD)"+ " values (?, ?)";
				 PreparedStatement preparedStmt = conn.prepareStatement(sql);
	   	         preparedStmt.setString   (1, emailAddress);
	   	         preparedStmt.setString   (2, password);
	   	         boolean Result = preparedStmt.execute();
	    	         System.out.println("Searching for user....");
	    	         
	    	         if(Result == true) {
	    	        	  System.out.println("User has been found....");
	    		    	  response.sendRedirect("http://localhost:8080/DrawnToYou/profile.jsp");
	    		      }
	    	         
	    	         else {
	    	        	 System.out.println("hello");
	    	         }
	    	      } catch (SQLException e) {
	    	    	  System.out.println("User not found...");
	    	         e.printStackTrace();
	    	      } 
	    	      
	      
	

}
}

