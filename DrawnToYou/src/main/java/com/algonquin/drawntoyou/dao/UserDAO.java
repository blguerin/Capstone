package com.algonquin.drawntoyou.dao;

import com.algonquin.drawntoyou.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	public boolean checkLogin(User user) throws SQLException, ClassNotFoundException {
		boolean status = false;
		
		try {
		
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
