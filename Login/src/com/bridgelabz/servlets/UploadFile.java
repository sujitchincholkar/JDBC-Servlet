package com.bridgelabz.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */

public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		if (session.getAttribute("id") != null) {
			int id = Integer.parseInt(session.getAttribute("id") + "");
			Part filePart = request.getPart("file");
			InputStream is = filePart.getInputStream();
			try {
				String query = "insert into fileSave(uid,filename,filecol) values(?,?,?)";
				Connection connection = DB.getConnection();
				PreparedStatement stmt = connection.prepareStatement(query);
				stmt.setInt(1, Integer.parseInt(session.getAttribute("id") + ""));
				stmt.setString(2, filePart.getSubmittedFileName());
				stmt.setBinaryStream(3, is, is.available());
				stmt.executeUpdate();
				is.close();
				out.print("File uploaded");
				request.getRequestDispatcher("");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			response.sendRedirect("Login.html");
		}
	}
}
