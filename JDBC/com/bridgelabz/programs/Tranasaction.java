package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Tranasaction {

	public static void main(String[] args) {
		Connection con=null; 
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","root");
			con.setAutoCommit(false);
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name,roll no and branch");
			String name=scanner.next();
			int rollNo=scanner.nextInt();
			String branch=scanner.next();
			String query="insert into StudentDetails values(?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, name);
			statement.setInt(2, rollNo);
			statement.setString(3, branch);
			int rowsAffected=statement.executeUpdate();
			System.out.println(rowsAffected+" rows affected");
			System.out.println("commit/rollback  ?");
			scanner.nextLine();
			String choice=scanner.nextLine();
			if(choice.equals("commit")){
				con.commit();
			}else{
				con.rollback();
			}
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
