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
		
	   	Connection connection = ConnectDB.getInstance().getConnectionToDB();

		String sql = "SELECT * FROM drawntoyou.USER WHERE email=? AND password=?";
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
	
	public User readUser(String email) {
        User user = null;
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "SELECT * FROM drawntoyou.USER WHERE Email=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new User();
                user.setUsername(set.getString("Username"));
                user.setEmail(set.getString("Email"));       
                user.setPassword(set.getString("Password"));
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return user;
    }
    
    public void createUser(User user) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "INSERT INTO drawntoyou.USER (Username, Email, Password) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            
            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void updatePassword(User user) {
        try {
            
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "UPDATE drawntoyou.USER SET Password=? WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getUsername());

            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public void deleteUser(String username) {
        try {
  
            Connection connection = ConnectDB.getInstance().getConnectionToDB();

            String sql = "DELETE FROM drawntoyou.USER WHERE Username=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            statement.execute();

        } catch (SQLException exception) {
            exception.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }     
}
