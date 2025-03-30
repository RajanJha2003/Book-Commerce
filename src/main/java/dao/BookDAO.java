package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import database.GetConnection;
import model.BookPojo;
import model.CategoryPojo;
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
			preparedStatement.setDouble(3, bookPojo.getPrice());
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
				bookPojo.setPrice(resultSet.getDouble(4));
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
				bookPojo.setPrice(resultSet.getDouble(4));
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
			preparedStatement.setDouble(3,bookPojo.getPrice());
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

	@Override
	public List<BookPojo> getNewBook() {
		// TODO Auto-generated method stub
		List<BookPojo> list=new ArrayList<BookPojo>();
		BookPojo bookPojo=null;
		try {
			String sql="select * from books where bookCategory=? and status=? order by bookId desc";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, "New");
			preparedStatement.setString(2, "Active");
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while(resultSet.next() && i<=4) {
				bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
				bookPojo.setBookCategory(resultSet.getString(5));
				bookPojo.setStatus(resultSet.getString(6));
				bookPojo.setPhotoName(resultSet.getString(7));
				bookPojo.setEmail(resultSet.getString(8));
				bookPojo.setIsbn(resultSet.getString(9));
				list.add(bookPojo);
				i++;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookPojo> getRecentBooks() {
		// TODO Auto-generated method stub
		List<BookPojo> list=new ArrayList<BookPojo>();
		BookPojo bookPojo=null;
		try {
			String sql="select * from books where status=? order by bookId desc";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1,"Active");
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			
			while(resultSet.next() && i<=4) {
				bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
				bookPojo.setBookCategory(resultSet.getString(5));
				bookPojo.setStatus(resultSet.getString(6));
				bookPojo.setPhotoName(resultSet.getString(7));
				bookPojo.setEmail(resultSet.getString(8));
				bookPojo.setIsbn(resultSet.getString(9));
				list.add(bookPojo);
				i++;
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BookPojo> getOldBooks() {
		// TODO Auto-generated method stub
		List<BookPojo> list=new ArrayList<BookPojo>();
	   try {
		String sql="select * from books where bookCategory=? and status=? order by booksId desc";
		PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
		preparedStatement.setString(1,"Old");
		preparedStatement.setString(2,"Active" );
		ResultSet resultSet=preparedStatement.executeQuery();
		int i=1;
		while(resultSet.next() && i<=4) {
			BookPojo bookPojo=new BookPojo();
			bookPojo.setBookId(resultSet.getInt(1));
			bookPojo.setBookName(resultSet.getString(2));
			bookPojo.setAuthor(resultSet.getString(3));
			bookPojo.setPrice(resultSet.getDouble(4));
			bookPojo.setBookCategory(resultSet.getString(5));
			bookPojo.setStatus(resultSet.getString(6));
			bookPojo.setPhotoName(resultSet.getString(7));
			bookPojo.setEmail(resultSet.getString(8));
			bookPojo.setIsbn(resultSet.getString(9));
			list.add(bookPojo);
			i++;
			
			
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<BookPojo> getAllRecentBook() {
		List<BookPojo> list=new ArrayList<BookPojo>();
		   try {
			String sql="select * from books where  status=? order by booksId desc";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			
			preparedStatement.setString(1,"Active" );
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while(resultSet.next()) {
				BookPojo bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
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
	public List<BookPojo> getAllNewBook() {
		List<BookPojo> list=new ArrayList<BookPojo>();
		   try {
			String sql="select * from books where bookCategory=?  status=? order by booksId desc";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, "New");
			preparedStatement.setString(2,"Active" );
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while(resultSet.next()) {
				BookPojo bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
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
	public List<BookPojo> getAllOldBook() {
		List<BookPojo> list=new ArrayList<BookPojo>();
		   try {
			String sql="select * from books where bookCategory=?  status=? order by booksId desc";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, "Old");
			preparedStatement.setString(2,"Active" );
			ResultSet resultSet=preparedStatement.executeQuery();
			int i=1;
			while(resultSet.next()) {
				BookPojo bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
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
	public List<BookPojo> getBookByOld(String email, String category) {
		List<BookPojo> list=new ArrayList<BookPojo>();
		   try {
			String sql="select * from books where bookCategory=? and email=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1,category);
			preparedStatement.setString(2,email);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				BookPojo bookPojo=new BookPojo();
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
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
	public boolean oldBookDelete(String email, String category, int id) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="delete from books where email=? and bookCategory=? and bookId=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, category);
		    preparedStatement.setInt(3,id);
		    
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
	public List<BookPojo> getBookBySearch(String ch) {
		// TODO Auto-generated method stub
		List<BookPojo> list=new ArrayList<BookPojo>();
		try {
			String sql="select * from books where bookName like ? and author like ? and bookCategory like ? and status=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1,"%"+ch+"%");
			preparedStatement.setString(2,"%"+ch+"%");
			preparedStatement.setString(3,"%"+ch+"%");
			preparedStatement.setString(4,"Active");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				BookPojo bookPojo=new BookPojo();
				
				bookPojo.setBookId(resultSet.getInt(1));
				bookPojo.setBookName(resultSet.getString(2));
				bookPojo.setAuthor(resultSet.getString(3));
				bookPojo.setPrice(resultSet.getDouble(4));
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
	public boolean createCategory(String category) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			String sql="insert into category(name) values(?)";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, category);
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
	public List<CategoryPojo> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryPojo> list=new ArrayList<CategoryPojo>();
		try {
			String sql="select * from category";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				CategoryPojo  categoryPojo=new CategoryPojo();
				categoryPojo.setId(resultSet.getInt(1));
				categoryPojo.setCategoryName(resultSet.getString(2));
				list.add(categoryPojo);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

}
