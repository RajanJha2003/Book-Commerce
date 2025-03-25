package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.GetConnection;
import model.UserPojo;
import operations.UserOperations;

public class UserDAO implements UserOperations {

	@Override
	public boolean userRegister(UserPojo us) {
       boolean f=false;
       
      try {
    	  String sql="Insert into users(name,email,phno,password) values(?,?,?,?)";
    	  PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
    	  preparedStatement.setString(1, us.getName());
    	  preparedStatement.setString(2, us.getEmail());
    	  preparedStatement.setString(3, us.getPhno());
    	  preparedStatement.setString(4, us.getPassword());
    	  
    	  int i=preparedStatement.executeUpdate();
    	  if(i==1) {
    		  f=true;
    	  }
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
       
       
		return f;
	}

	@Override
	public boolean checkUser(String email) {
	     boolean f=false;
	     try {
	    	 String sql="Select * from users where email=?";
	    	 PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
	    	 preparedStatement.setString(1, email);
	    	
	    	 
	    	ResultSet rs=preparedStatement.executeQuery();
	    	
	    	while(rs.next()) {
	    		f=true;
	    	}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

}
