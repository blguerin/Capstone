package com.algonquin.drawntoyou.user;

import java.sql.*;

public class UserDAO {
	
	public User checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		
		String jdbcURL = "jdbc:mysql://localhost:3306/DrawnToYou";
		String dbUser = "root";
		String dbPassword = "ninuni";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection( jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM user WHERE email = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, email);
		statement.setString(2, password);
		
		ResultSet result = statement.executeQuery();
		
		User user = null;
		
		if (result.next()) {
			user = new User(email, password);
		}
		
		connection.close();
		
		return user;
		
	}

}