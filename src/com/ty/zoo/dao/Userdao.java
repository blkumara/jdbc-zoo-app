package com.ty.zoo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ty.zoo.dto.User;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.ConnectionObject;

public class Userdao {

	public int saveUser(User user) {
		int resultCount = 0;
		String sql = "Insert into user values(?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setString(6, user.getPhone());

			resultCount = preparedStatement.executeUpdate();
System.out.println("Data saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCount;

	}

	public User getById(int id) {
		User user = new User();

		String sql = "Select * from user where id=?";
		Connection connection = ConnectionObject.getConnection();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Visitor visitor=new Visitor();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setPhone(resultSet.getString("phone"));
			}
			else {
				return null;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;

	}

	{

	}

}
