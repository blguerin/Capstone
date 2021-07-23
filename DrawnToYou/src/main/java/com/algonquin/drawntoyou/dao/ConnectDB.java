package com.algonquin.drawntoyou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
    
    private static final ConnectDB connectDB = new ConnectDB();
    private static boolean initialized = false;
    
    // Singleton pattern applied to ConnectDB
    public static synchronized ConnectDB getInstance() {
        if (initialized) return connectDB;
        initialized = true;
        return connectDB;
    }
    
    public static Connection getConnectionToDB() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database credentials
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "password";
            
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
