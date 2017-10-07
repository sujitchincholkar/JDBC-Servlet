package com.bridgelabz.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo {
	static Scanner scanner=new Scanner(System.in);
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","root");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static int updateRecord() throws SQLException{
		displayTable();
		Connection connection=getConnection();
		System.out.println("Enter roll no of record which you want to update");
		int rollNo=scanner.nextInt();
		System.out.println("Enter name and branch");
		String name=scanner.next();
		String branch=scanner.next();
		String query="update StudentDetails set student_name=? ,branch=? where roll_no=? ";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setString(1,name);
		statement.setString(2, branch);
		statement.setInt(3, rollNo);
		int rowsAffected=statement.executeUpdate();
		connection.close();
		return rowsAffected;
		
	}
	public static void displayTable() throws SQLException{
		Connection connection =getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultset=statement.executeQuery("select * from StudentDetails");
		while(resultset.next()){
			System.out.println(resultset.getString(1));
			System.out.println(resultset.getInt(2));
			System.out.println(resultset.getString(3));
			System.out.println("==========");
		}
		connection.close();
	}
	public static int deleteRecord() throws SQLException{
		displayTable();
		Connection connection=getConnection();
		System.out.println("Enter roll_no of data you want to delete");
		int rollNo=scanner.nextInt();
		String query="delete from StudentDetails where roll_no=?";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setInt(1,rollNo);
	   	int rowsAffected=statement.executeUpdate();
	    connection.close();
	    return rowsAffected;
	}
	public static int addRecord() throws SQLException{
		Connection connection=getConnection();
		System.out.println("Enter roll no, name and branch");
		int rollNo=scanner.nextInt();
		String name=scanner.next();
		String branch=scanner.next();
		String query="insert into StudentDetails values(?,?,?)";
		PreparedStatement statement=connection.prepareStatement(query);
		statement.setInt(2, rollNo);
		statement.setString(1,name);
		statement.setString(3, branch);
		int rowsAffected=statement.executeUpdate();
		connection.close();
		return rowsAffected;
	}
	public static void main(String[] args) {
		
		System.out.println("Enter your choice 1.Update 2.Delete 3.New record");
		int choice=scanner.nextInt();
		try{
		switch(choice){
		case 1:
			if(updateRecord()>0){
				System.out.println("Record updated");
			};
			break;
		case 2:
			if(deleteRecord()>0){
				System.out.println("Record Deleted");
			};
			break;
		case 3:
			if(addRecord()>0){
				System.out.println("Record added");
			};
			break;
		}
		}catch(SQLException e){
			System.out.println(e);
		}

	}

}
