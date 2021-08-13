package com.algonquin.drawntoyou.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.dao.UserDAO;
import com.algonquin.drawntoyou.user.User;
import com.algonquin.drawntoyou.user.UserBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
    
    private String username;
    private String email;
    private String password;
    private String code;
    
	
    private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String verificationCode = request.getParameter("verificationCode");		 
		 
		username = request.getParameter("username");
		email = request.getParameter("email");
		password = request.getParameter("password");
		code = request.getParameter("code");
		
		// Check the user's answer against the generated verification code.
		if (verificationCode.equals(code)) {
		    
		    // Encrypt password with MD5
		    try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(password.getBytes(StandardCharsets.UTF_8));
	            byte[] hashBytes = md.digest();
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hashBytes) {
	                sb.append(String.format("%02x", b));
	            }
	            password = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }              
		    
		    // Create user via UserBuilder and save in DB.
		    UserDAO userDAO = new UserDAO();
		    userDAO.createUser(
		            new UserBuilder()
		            .setUsername(username)
		            .setEmail(email)
		            .setPassword(password)
		            .createUser()
		            );
         
		    // Create and save an initial profile for new user.
		    ProfileDAO profileDAO = new ProfileDAO();
		    profileDAO.createProfile(username);
         
		    response.sendRedirect("login.jsp");
		} else {
		    System.out.println("Failed");
		    response.sendRedirect("SignUp.jsp");
		}
	}
}	
    		
    
    
    
