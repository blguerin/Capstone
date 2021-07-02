package com.algonquin.drawntoyou.user;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	
	  private static final long serialVersionUID = 1L;
	  static final String DB_URL = "jdbc:mysql://localhost:3306/";
	  static final String DB_URL_WITH_TABLE = "jdbc:mysql://localhost:3306/SIGN_UP_DATABASE";
	  static final String USER = "administrator";
	  static final String PASS = "rootPasswordDrawn2You";
	  static final String DB = "SIGN_UP_DATABASE";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String verificationCode = request.getParameter("verificationCode");
		 
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	         
	     } 
		 catch (ClassNotFoundException e) {
	         System.out.println("Missing driver");
	         e.printStackTrace();
	     }
		 
		 try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
    	         Statement stmt = conn.createStatement();
    	      ) {		      
			 
			 String sql = "SELECT * FROM SIGN_UP_INFO WHERE VERIFICATION_CODE = ?";
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
   	         preparedStmt.setString   (1, verificationCode);
   	         boolean Result = preparedStmt.execute();
   	         if(Result == true) {
   	        	/*Connection connection = ConnectDB.getConnectionToDB();
   	        	String insert = "INSERT INTO user VALUES(?,?)";
   	        	String email = "SELECT EMAIL FROM SIGN_UP_INFO WHERE VERIFICATION_CODE = '0000';";
   	        	String password = "SELECT PASSWORD FROM SIGN_UP_INFO WHERE VERIFICATION_CODE = '0000';";
   	        	PreparedStatement statement = connection.prepareStatement(insert);
   	        	statement.setString(1, email);
   	        	statement.setString(2, password);
   	        	statement.executeQuery();*/
   	        	response.sendRedirect("http://localhost:8080/DrawnToYou/");
   	         }
   	         else {
   	        	 System.out.println("User has not been verified.");
   	         }
   	         
    	      } catch (SQLException e) {
    	    	  System.out.println("The table has either been created,\nor there was an error.");
    	         e.printStackTrace();
    	      } 
	}}
		
	


