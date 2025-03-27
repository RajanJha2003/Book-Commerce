package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<BookPojo> getAllBooks() {
		// TODO Auto-generated method stub
		List<BookPojo> list=new ArrayList<BookPojo>();
		BookPojo bookPojo=new BookPojo();
		
		try {
			String sql="select * from books";
			
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getInt(4));
				bookPojo.setBookCategory(resultSet.getString(5));
				bookPojo.setStatus(resultSet.getString(6));
				bookPojo.setPhotoName(resultSet.getString(7));
				bookPojo.setEmail(resultSet.getString(8));
				bookPojo.setIsbn(resultSet.getString(9));
				
				list.add(bookPojo);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	@Override
	public BookPojo getBookById(int id) {
		// TODO Auto-generated method stub
		BookPojo bookPojo=null;
		try {
			String sql="Select * from books where id=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getInt(4));
				bookPojo.setBookCategory(resultSet.getString(5));
				bookPojo.setStatus(resultSet.getString(6));
				bookPojo.setPhotoName(resultSet.getString(7));
				bookPojo.setEmail(resultSet.getString(8));
				bookPojo.setIsbn(resultSet.getString(9));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return bookPojo;
	}

	@Override
	public boolean updateBooks(BookPojo bookPojo) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="update books set bookName=?,author=?,price=?,bookCategory=?,status=?,isbn=? where bookId=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, bookPojo.getBookName());
			preparedStatement.setString(2, bookPojo.getAuthor());
			preparedStatement.setInt(3,bookPojo.getPrice());
			preparedStatement.setString(4, bookPojo.getBookCategory());
			preparedStatement.setString(5,bookPojo.getStatus());
			preparedStatement.setString(6,bookPojo.getIsbn());
			preparedStatement.setInt(7, bookPojo.getBookId());
			
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
	public boolean deleteBooks(int id) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="delete from books where bookId=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
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
