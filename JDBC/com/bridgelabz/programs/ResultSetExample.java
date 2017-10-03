package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ResultSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null; 
		Statement statement=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","root");
			statement=con.createStatement();
			ResultSet resultset=statement.executeQuery("select * from StudentDetails");
			while(resultset.next()){
				System.out.println(resultset.getString(1));
				System.out.println(resultset.getInt(2));
				System.out.println(resultset.getString(3));
				System.out.println("==========");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
