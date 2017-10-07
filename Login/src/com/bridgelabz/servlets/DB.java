package com.bridgelabz.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
	Class.forName("com.mysql.jdbc.Driver");
	String URL="jdbc:mysql://localhost:3306/MyDb";
	String username="root";
	String password="root";
	Connection con=DriverManager.getConnection(URL,username,password);
	return con;
	}
}
