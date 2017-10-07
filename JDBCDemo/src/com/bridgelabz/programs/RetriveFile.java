package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveFile {

	public static void main(String[] args) {
		System.out.println("Enter directory to save file");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.next();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyDb", "root", "root");
			Statement statement = con.createStatement();
			ResultSet resultset = statement.executeQuery("select * from image");

			while (resultset.next()) {
				File file = new File(filePath + "/" + resultset.getString("name"));
				if (file.createNewFile()) {

					FileOutputStream fout = new FileOutputStream(file);
					Blob data = resultset.getBlob("imagecol");
					byte byteData[] = data.getBytes(1, (int) data.length());
					fout.write(byteData, 0, byteData.length - 1);
				}
			}
			con.close();
		} catch (SQLException sql) {
			sql.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
