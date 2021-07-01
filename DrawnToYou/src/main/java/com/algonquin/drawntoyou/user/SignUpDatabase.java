package com.algonquin.drawntoyou.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDatabase {
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "guest";
   static final String PASS = "guest123";
   private String username;
   private String password;
   private String verificationCode;
   
   public SignUpDatabase() {
	   username = "";
	   password = "";
	   verificationCode = "";
   }
   
   public String getUsername() {
	   return username;
   }
   
   public void setUsername(String username) {
	   this.username = username;
	   
	}
   
   public String getPassword() {
	   return password;
   }
   
   public void setPassword() {
	   this.password = password;
	   
	}
   
   public String getVerificationCode() {
	   return verificationCode;
   }
   
   public void setVerificationCode() {
	   this.verificationCode = verificationCode;
	   
	}
   

   
   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "CREATE DATABASE SIGN_UP_DATABASE";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
    	  System.out.println("The database has either been created,\nor there was an error.");
         e.printStackTrace();
      } 
      
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	         Statement stmt = conn.createStatement();
    	      ) {		      
    	         String sql = "CREATE TABLE SIGN_UP_INFO("
    	         		+ "USERNAME VARCHAR(20),PASSWORD VARCHAR(20),VERIFICATION_CODE VARCHAR(4);";
    	         stmt.executeUpdate(sql);
    	         System.out.println("Table created successfully....");   	  
    	      } catch (SQLException e) {
    	    	  System.out.println("The table has either been created,\nor there was an error.");
    	         e.printStackTrace();
    	      } 
      
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
 	         Statement stmt = conn.createStatement();
 	      ) {		      
 	         String sql = "CREATE TABLE SIGN_UP_INFO("
 	         		+ "USERNAME VARCHAR(20),PASSWORD VARCHAR(20),VERIFICATION_CODE VARCHAR(4);";
 	         stmt.executeUpdate(sql);
 	         System.out.println("Table created successfully....");   	  
 	      } catch (SQLException e) {
 	    	  System.out.println("The table has either been created,\nor there was an error.");
 	         e.printStackTrace();
 	      }
}





}
