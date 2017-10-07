package com.bridgelabz.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		if(password.equals("admin")){
			out.write("<h4>Hello "+userName+"</h4>");
			Cookie username=new Cookie("username",request.getParameter("username"));
			Cookie passWord=new Cookie("password",request.getParameter("password"));
			username.setMaxAge(60*60*48);
			passWord.setMaxAge(60*60*48);
			response.addCookie(username);
			response.addCookie(passWord);
			//request.getRequestDispatcher("/CookiesDemo")
			//.include(request, response);
		}else {
			out.print("Password is incorrect");
			request.getRequestDispatcher("Login1.html")
			.include(request, response);
			//response.sendRedirect("Login.html");
		}
	}

}
