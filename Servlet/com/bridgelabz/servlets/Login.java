package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String query="select * from Login where username=?";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			PreparedStatement ps=DB.getConnection().prepareStatement(query);
			ps.setString(1, request.getParameter("username"));
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next()){
				
				if(resultset.getString("password").equals(password)){
					HttpSession session=request.getSession();
					session.setAttribute("id", resultset.getString("id"));
					request.getRequestDispatcher("Profile").forward(request, response);
				}
			}
				PrintWriter out=response.getWriter();
				out.print("Username or password is incorrect");
				request.getRequestDispatcher("Login.html")
				.include(request,response);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
