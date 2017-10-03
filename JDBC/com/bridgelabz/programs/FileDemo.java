package com.bridgelabz.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FileDemo {

	public static void main(String[] args) {
		Connection con=null; 
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb","root","root");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter file name");
			String filepath=scanner.nextLine();
			File file=new File(filepath);
			String name =file.getName();
			PreparedStatement ps=con.prepareStatement("insert into image(name,imagecol) "
					+ "values(?,?)");  
			ps.setString(1,file.getName());  
			FileInputStream fin=new FileInputStream(file);  
			ps.setBinaryStream(2,fin,fin.available());  
			int i=ps.executeUpdate();  
			System.out.println(i+" records affected");  
			con.close();
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
