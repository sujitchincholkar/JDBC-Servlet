package com.bridgelabz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.model.User;

public class UserDao {
	private static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/Keep";
			String username="root";
			String password="root";
			connection=DriverManager.getConnection(URL,username,password);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
	}

	public static User getUser(String email,String password) {
		User user=null;
		try {
			Connection connection=getConnection();
			String query="SELECT * FROM userinfo where email=? and password=?";
			PreparedStatement prepareStatement=connection.prepareStatement(query);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2,password);
			ResultSet resultSet=prepareStatement.executeQuery();
			if(resultSet.next()){
				user=new User();
				user.setEmail(resultSet.getString("email"));
				user.setId(resultSet.getString("id"));
				user.setMobileno(resultSet.getString("mobileNo"));
				user.setName(resultSet.getString("name"));
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return user;
	}
	public static int insertUser(User user){
		int rowsAffected=0;
		Connection connection=getConnection();
		String query="insert into userinfo(name,password,email,mobileNo)"
				+ " values(?,?,?,?)";
		try {
			PreparedStatement prepareStatement=connection.prepareStatement(query);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getMobileno());
			rowsAffected=prepareStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected;
	}
	/*public static int updateUser(User user){
		int status=0;
		Connection connection=getConnection();
		String query="update userinfo set name=?,email=?,password=?,mobileNo=? where id=?";
		try {
			PreparedStatement prepareStatment=connection.prepareStatement(query);
			prepareStatment.setString(1, user.getEmail());
			prepareStatment.setString(1, user.getName());
			prepareStatment.setString(1, user.getPassword());
			prepareStatment.setString(1, user.getMobileno());
			status=prepareStatment.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}*/

}
