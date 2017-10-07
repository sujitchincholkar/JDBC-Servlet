package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int hits;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(){
    	hits=0;
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
		hits++;
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		HttpSession session=request.getSession(false);
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies.
		if(session!=null){
			out.print("<h3>Hello "+username+"....</h3>"
					+ "<a href='Logout'>Logout</a><br>"
					+ "<form action='UploadFile' enctype='multipart/form-data' method='post' >"
					+ "<input type='file' Value='file' name='file' id='file'><br>"
					+ "<input type='submit' Value='Upload'></form><br>"
					+ "number of hit="+hits);
				request.getRequestDispatcher("/UploadFile").include(request,response);	
			out.close();
		}else{
			response.sendRedirect("/Login.html");
		}
	}

}
