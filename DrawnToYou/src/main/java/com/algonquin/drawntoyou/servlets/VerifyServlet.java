package com.algonquin.drawntoyou.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;

import java.io.IOException;
import java.sql.*;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String verificationCode = request.getParameter("verificationCode");
		 
		 Connection connection = ConnectDB.getInstance().getConnectionToDB();
		      
		 try {
			String sql = "SELECT * drawntoyou.user WHERE verificationCode = ?";
			PreparedStatement preparedStmt = connection.prepareStatement(sql);
   	         	preparedStmt.setString   (1, verificationCode);
   	         	boolean Result = preparedStmt.execute();
   	         if(Result == true) {
   	        	response.sendRedirect("http://localhost:8080/DrawnToYou/");
   	         }
   	         else {
   	        	 System.out.println("User has not been verified.");
   	         }
   	         
    	  } catch (SQLException e) {
    	    	  System.out.println("The table has either been created,\nor there was an error.");
    	         e.printStackTrace();
    	    } 
	}
}	
		



