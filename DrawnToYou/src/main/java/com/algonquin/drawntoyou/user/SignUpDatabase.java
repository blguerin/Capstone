package com.algonquin.drawntoyou.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDatabase {
   static final String DB_URL = "jdbc:mysql://localhost:3306/";
   static final String DB_URL_WITH_TABLE = "jdbc:mysql://localhost:3306/SIGN_UP_DATABASE";
   static final String USER = "administrator";
   static final String PASS = "rootPasswordDrawn2You";
   static final String DB = "SIGN_UP_DATABASE";
   private static String username;
   private static String password;
   private static String verificationCode;
   
   public SignUpDatabase() {
	   username = "100";
	   password = "1000";
	   verificationCode = "10000";
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
         String sql = "CREATE DATABASE SIGN_UP_DATABASE;";
         stmt.executeUpdate(sql);
         System.out.println("Database created successfully...");   	  
      } catch (SQLException e) {
    	  System.out.println("The database has either been created,\nor there was an error.");
         e.printStackTrace();
      } 
      
      try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
    	         Statement stmt = conn.createStatement();
    	      ) {		      
    	         String sql = "CREATE TABLE SIGN_UP_INFO( USERNAME VARCHAR(20),PASSWORD VARCHAR(20),VERIFICATION_CODE VARCHAR(4));";
    	         stmt.executeUpdate(sql);
    	         System.out.println("Table created successfully....");   	  
    	      } catch (SQLException e) {
    	    	  System.out.println("The table has either been created,\nor there was an error.");
    	         e.printStackTrace();
    	      } 
      
      try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
    		  
  	      ) {		      
    	  String query = " INSERT INTO SIGN_UP_INFO (USERNAME,PASSWORD,VERIFICATION_CODE)"+ " values (?, ?, ?)";
    	   PreparedStatement preparedStmt = conn.prepareStatement(query);
    	      preparedStmt.setString (1, username);
    	      preparedStmt.setString (2, password);
    	      preparedStmt.setString   (3, verificationCode);
    	      preparedStmt.execute();
  	         System.out.println("Values have been added to the table....");   	  
  	      } catch (SQLException e) {
  	    	  System.out.println("The user has either been created,\nor there was an error.");
  	         e.printStackTrace();
  	      }
      
      
      try(Connection conn = DriverManager.getConnection(DB_URL_WITH_TABLE, USER, PASS);
   	         Statement stmt = conn.createStatement();
   	      ) {		      
   	         String sql = "SELECT * FROM SIGN_UP_INFO;";
   	         stmt.executeUpdate(sql);
   	         System.out.println(stmt);   	  
   	      } catch (SQLException e) {
   	    	  System.out.println("The user has either been created,\nor there was an error.");
   	         e.printStackTrace();
   	      }
      
}





}
