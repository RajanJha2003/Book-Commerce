package dao;

import java.sql.PreparedStatement;

import database.GetConnection;
import model.BookPojo;
import operations.BookOperations;

public class BookDAO implements BookOperations {

	@Override
	public boolean addBooks(BookPojo bookPojo) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="insert into books(bookName,author,price,bookCategory,status,photoName,email,isbn) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, bookPojo.getBookName());
			preparedStatement.setString(2, bookPojo.getAuthor());
			preparedStatement.setInt(3, bookPojo.getPrice());
			preparedStatement.setString(4, bookPojo.getBookCategory());
			preparedStatement.setString(5, bookPojo.getStatus());
			preparedStatement.setString(6, bookPojo.getPhotoName());
			preparedStatement.setString(7, bookPojo.getEmail());
			preparedStatement.setString(8, bookPojo.getIsbn());
			
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

}
