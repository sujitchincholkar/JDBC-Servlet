package com.bridgelabz.programs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallStatement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb", "root", "root");  
		  
		CallableStatement stmt=con.prepareCall("{?=call sum(?,?)}");  
		
		stmt.setInt(3, 1);
		stmt.setInt(2, 2); 
	
	  
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.executeUpdate();
		System.out.println(stmt.getInt(1));
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}
