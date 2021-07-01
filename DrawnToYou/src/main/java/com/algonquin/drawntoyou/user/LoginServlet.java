package com.algonquin.drawntoyou.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	UserDAO userDAO = new UserDAO();
	
	try {
		User user = userDAO.checkLogin(email, password);
		String toPage = "login.jsp";
		
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			toPage = "profile.jsp";
		}
		else {
			String message = "Invalid login email/password";
			request.setAttribute("message", message);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(toPage);
		dispatcher.forward(request, response);
		
	} catch (SQLException | ClassNotFoundException e) {
		throw new ServletException(e);
	}
}

		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
