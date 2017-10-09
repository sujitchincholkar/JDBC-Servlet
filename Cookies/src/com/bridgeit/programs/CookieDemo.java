package com.bridgeit.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieDemo
 */

public class CookieDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo() {
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
		Cookie username=new Cookie("name",request.getParameter("name"));
		Cookie password=new Cookie("password",request.getParameter("password"));
		username.setMaxAge(60*60*48);
		password.setMaxAge(60*60*48);
		response.addCookie(username);
		response.addCookie(password);
		PrintWriter out=response.getWriter();
		out.println("cookies added");
		Cookie cookies[]=request.getCookies();
		out.println("Previous Cookies");
		for(int i=0;i<cookies.length;i++){
		out.println(cookies[i].getName());
		out.println(cookies[i].getValue());
		}
	}

}
