package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {
		Connection con=null; 
		Statement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","root");
			statement=con.createStatement();
			int rowsAffected=statement.executeUpdate("insert into StudentDetails values"
					+ "('Ajay',2,'IT')");
			System.out.println(rowsAffected);
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
