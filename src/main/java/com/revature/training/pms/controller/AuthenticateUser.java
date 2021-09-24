package com.revature.training.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthenticateUser
 */
public class AuthenticateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();
		
		//authenticate user from a DB??
		out.println("<html><body>");
		out.println("<h2>Hi, you have logged in at : "+ new java.util.Date());
		out.println("Your username is : "+username);
		
		if(allCookies == null) {
			
		} else {
			for (Cookie c : allCookies) {
				if(c.getName().equals(username)) {
					alreadyVisited = true;
					break;
				}
			}
		}
		
		if(alreadyVisited) {
			out.println("<h1>You have already visited my website : "+username);
		} else {
			out.println("<h1>You are first time visitor "+username);
			Cookie c = new Cookie(username, username);
			c.setMaxAge(1000*60*60*24);
			response.addCookie(c);
		}
		out.println("Your password is : "+password);
		out.println("<br/><a href=productForm.html>Add Product</a>");
		out.println("</body></html>");
	}

}
