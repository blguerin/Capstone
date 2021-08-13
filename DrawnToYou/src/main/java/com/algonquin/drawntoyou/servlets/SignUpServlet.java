package com.algonquin.drawntoyou.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.ConnectDB;
import com.algonquin.drawntoyou.dao.ProfileDAO;
import com.algonquin.drawntoyou.user.SendEmail;
import com.algonquin.drawntoyou.user.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public int verificationCode() {
		
		Random rand = new Random();
		int code = rand.nextInt(9999);
		return code;
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String email = request.getParameter("emailAddress");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    int code = verificationCode();
	    
	    response.setContentType("test/ html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("verify.jsp");
            SendEmail sendEmail = new SendEmail();
            boolean test = sendEmail.sendEmail(email, code);
            
            if(test) {
                
                request.setAttribute("username", username);
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("code", code);
                
                requestDispatcher.forward(request, response);
            } else {
                System.out.println("Verification email failed.");          
            }
        }   
	}
}
