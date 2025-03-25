package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.GetConnection;
import model.UserPojo;
import operations.UserOperations;

public class UserDAO implements UserOperations {

	@Override
	public boolean userRegister(UserPojo us) {
		boolean f = false;

		try {
			String sql = "Insert into users(name,email,phno,password) values(?,?,?,?)";
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, us.getName());
			preparedStatement.setString(2, us.getEmail());
			preparedStatement.setString(3, us.getPhno());
			preparedStatement.setString(4, us.getPassword());

			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public boolean checkUser(String email) {
		boolean f = false;
		try {
			String sql = "Select * from users where email=?";
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public UserPojo login(String email, String password) {
		// TODO Auto-generated method stub
		UserPojo us = null;

		try {
			String sql = "select * from users where email=? and password=?";
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				us = new UserPojo();
				us.setId(resultSet.getInt(1));
				us.setName(resultSet.getString(2));
				us.setEmail(resultSet.getString(3));
				us.setPhno(resultSet.getString(4));
				us.setPassword(resultSet.getString(5));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return us;
	}

	@Override
	public boolean updateProfile(UserPojo us) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String sql = "Update users set name=?,email=?,phno=? where id=?";
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, us.getName());
			preparedStatement.setString(2, us.getEmail());
			preparedStatement.setString(3, us.getPhno());
			preparedStatement.setInt(4, us.getId());

			int i = preparedStatement.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;

	}

	@Override
	public boolean checkPassword(int id, String password) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="select * from users where id=? and password=?";
			PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				f=true;
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

}
