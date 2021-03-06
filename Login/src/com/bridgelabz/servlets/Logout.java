package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false);
		if(session!=null){
		session.removeAttribute("id");
		
		session.invalidate();
		Cookie cookies[]=request.getCookies();
	
		for (Cookie cookie : cookies) {
			cookie.setMaxAge(0);
			cookie.setValue(null);

            cookie.setPath("/");
			response.addCookie(cookie);
			}
		response.sendRedirect("Login.html");
		System.out.println(session);
		}else{
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			out.print("You are already logged out");
			out.println("<a href='Login.html'>Login Again</a>");
			
		}
		
		
		
	}

}
