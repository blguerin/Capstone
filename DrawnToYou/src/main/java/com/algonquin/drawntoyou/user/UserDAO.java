/** Refactor this code, the DAO is not needed for user authentication. */

package com.algonquin.drawntoyou.user;

import java.sql.*;



public class UserDAO {
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DB_URL_WITH_TABLE = "jdbc:mysql://localhost:3306/DTY_USERS";
	static final String USER = "administrator";
	static final String PASS = "rootPasswordDrawn2You";
	static final String DB = "DTY_USERS";
	
	public boolean checkLogin(User user) throws SQLException, ClassNotFoundException {
		boolean status = false;
		
		//String jdbcURL = "jdbc:mysql://localhost:3306";
		//String dbUser = "root";
		//String dbPassword = "password";
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
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
	    	         String sql = "SELECT * FROM DTY_USERS.USER_INFO WHERE email = ? AND password = ?";
	    	         PreparedStatement statement = conn.prepareStatement(sql);
	    	         statement.setString(1, user.getEmail());
	    	 		 statement.setString(2, user.getPassword());
	    	         ResultSet result = statement.executeQuery();
	    	         System.out.println(result);   	  
	    	      } catch (SQLException e) {
	    	    	  System.out.println("The user does not exist, or there was an error.");
	    	         e.printStackTrace();
	    	      } 
	      return status;

}
}
