package com.algonquin.drawntoyou.user;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;






	public String verificationCode() {
		Random randomInt = new Random();
		String verificationCodeNumber = "0000";
		
		return verificationCodeNumber;
	}
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String emailAddress = request.getParameter("emailAddress");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    SignUpServlet getInfo = new SignUpServlet();
	    String verificationCode = getInfo.verificationCode();


	    request.setAttribute("firstName", firstName);
	    request.setAttribute("lastName", lastName);
	    request.setAttribute("emailAddress",emailAddress);
	    request.setAttribute("username", username);
	    request.setAttribute("password",password);
	    request.setAttribute("verificationCode", verificationCode);
	    
	    request.getRequestDispatcher("/jsp.jsp").forward(request, response);
	    
	    SignUpDatabase sendInfo = new SignUpDatabase();
	    sendInfo.setUsername(username);
	    sendInfo.setUsername(password);
	    sendInfo.setUsername(verificationCode);
	}
	


}
