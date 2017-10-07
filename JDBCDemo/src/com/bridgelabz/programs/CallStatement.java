package com.bridgelabz.programs;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallStatement {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb", "root", "root");  
		  
		CallableStatement stmt=con.prepareCall("{call insertinto(?, ?,?)}");  
		stmt.setString(1,"hemant");  
		stmt.setInt(2,13);  
		stmt.setString(3,"Extc");
		stmt.execute();   
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}

	}

}
