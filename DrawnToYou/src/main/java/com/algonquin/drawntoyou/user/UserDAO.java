package com.algonquin.drawntoyou.user;

import java.sql.*;

import com.algonquin.drawntoyou.dao.ConnectDB;

public class UserDAO {
	
	public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
//		String jdbcURL = "jdbc:mysql://localhost:3306/DrawnToYou";
//		String dbUser = "root";
//		String dbPassword = "";
//		
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection connection = DriverManager.getConnection( jdbcURL, dbUser, dbPassword);
	    
	    // Use this line for all DAO connections.
	    Connection connection = ConnectDB.getConnectionToDB();
	    
	    
	    // I don't think this query is legal. You could just "SELECT * FROM user;"
		String sql = "SELECT * FROM user WHERE email = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		User user = null;
		
		// Added a few more attributes to User so the constructor is hungry for more params.
		if (result.next()) {
			user = new User(email, password);
		}
		
		connection.close();
		
		return user;
		
	}

}