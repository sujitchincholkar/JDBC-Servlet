package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteBatch {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb", "root", "root");  
			
			  
			Statement stmt=con.createStatement();  
			stmt.addBatch("insert into StudentDetails values('Ashish',7,'IT')");  
			stmt.addBatch("insert into StudentDetails values('Jayesg',9,'Comp')");  
			  
			stmt.executeBatch();
			  
			  
			con.close();  

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}

}
