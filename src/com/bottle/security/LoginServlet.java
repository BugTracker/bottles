package com.bottle.security;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
@DeclareRoles({"admin", "user", "manager"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username;
		String password;
		try{
			username = request.getParameter("username");
			password = request.getParameter("password");
			
			request.login(username, password);
			
			if (request.isUserInRole("admin"))
				response.sendRedirect("admin/index.xhtml");
			if (request.isUserInRole("manager"))
				response.sendRedirect("manager/index.xhtml");
			if (request.isUserInRole("user"))
				response.sendRedirect("user/index.xhtml");
		} catch(ServletException e) {
			HttpSession session= request.getSession();
	        session.invalidate();
			response.sendRedirect("loginerror.xhtml");
		}
	}

}
