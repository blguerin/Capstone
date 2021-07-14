package com.algonquin.drawntoyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: make Singleton

public class ConnectDB {
    
    public static Connection getConnectionToDB() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database connection info. Update with your own mySQL login info if needed.
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "";
            
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Missing driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        return connection;
    }

}
