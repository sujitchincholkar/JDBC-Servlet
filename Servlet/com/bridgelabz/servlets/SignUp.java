package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String repass=request.getParameter("repassword");
		response.setContentType("text/html");
		if(password.equals(repass)){
			
			try {
				
				Connection con=DB.getConnection();
				String sql="insert into Login(username,password,email) "
						+ "values(?,?,?)";
				PreparedStatement statement=con.prepareStatement(sql);
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, email);
				statement.executeUpdate();
				out.println("Record Added");
				Mailer.send(username,email);
				out.print("<a href='Login.html'>Login</a>");
				out.close();
				con.close();
				
			} catch (Exception   e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.print("Password not matching");
			request.getRequestDispatcher("signup.html")
			.include(request,response);
			
		}
	}

}
