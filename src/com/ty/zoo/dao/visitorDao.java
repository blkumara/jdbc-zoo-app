package com.ty.zoo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;


import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.ConnectionObject;

public class visitorDao {

	public int saveVisitor(Visitor visitor) {
		int resultCount = 0;
		String sql = "insert into visitor values(?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, visitor.getId());
			preparedStatement.setString(2, visitor.getName());
			preparedStatement.setString(3, visitor.getEmail());
			preparedStatement.setString(4, visitor.getPhone());
			preparedStatement.setString(5, visitor.getGender());
			preparedStatement.setInt(6, visitor.getAge());

			resultCount = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCount;
	}
	
	
	public Visitor getById(int id)
	{
		Connection connection=ConnectionObject.getConnection();
		String sql="Select * From visitor where id=?";
		Visitor visitor= new Visitor();
		
		try {
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				Visitor visitor2=new Visitor();
			visitor.setId(resultSet.getInt("id"));
			visitor.setName(resultSet.getString("name"));
			visitor.setEmail(resultSet.getString("email"));
			visitor.setPhone(resultSet.getString("phone"));
			visitor.setGender(resultSet.getString("gender"));
			visitor.setAge(resultSet.getInt("age"));
			
			
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return visitor;
		
		
	}
}
