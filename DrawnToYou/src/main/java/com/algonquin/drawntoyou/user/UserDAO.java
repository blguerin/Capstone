package com.algonquin.drawntoyou.user;

import java.sql.*;

import com.algonquin.drawntoyou.dao.ConnectDB;

public class UserDAO {
	
	public boolean checkLogin(User user) throws SQLException, ClassNotFoundException {
		boolean status = false;
		
		//String jdbcURL = "jdbc:mysql://localhost:3306";
		//String dbUser = "root";
		//String dbPassword = "password";
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			//Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		
	   	// Use this line for all DAO connections.
	   	Connection connection = ConnectDB.getConnectionToDB();

		String sql = "SELECT * FROM db.users WHERE email = ? AND password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getPassword());
		
		ResultSet result = statement.executeQuery();
		status = result.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
			
	}

}
