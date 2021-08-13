package com.algonquin.drawntoyou.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.algonquin.drawntoyou.dao.UserDAO;

@WebServlet("/EditBioServlet")
public class EditBioServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private String username;
    private String bio;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    username = request.getParameter("username");
	    bio = request.getParameter("bio");
	    
	    RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_bio.jsp");
	    
	    request.setAttribute("username", username);	    
	    request.setAttribute("bio", bio);        
	    
	    requestDispatcher.forward(request, response);	    
	}

}
