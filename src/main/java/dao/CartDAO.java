package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.GetConnection;
import model.CartPojo;
import operations.CartOperations;

public class CartDAO implements CartOperations {

	@Override
	public boolean addCart(CartPojo cartPojo) {
		// TODO Auto-generated method stub
		boolean f=true;
		try {
			String sql="insert into cart(bookId,cartId,bookName,author,price,totalPrice) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatemet=GetConnection.getConnection().prepareStatement(sql);
			preparedStatemet.setInt(1,cartPojo.getBookId());
			preparedStatemet.setInt(2, cartPojo.getUserId());
			preparedStatemet.setString(3, cartPojo.getBookName());
			preparedStatemet.setString(4, cartPojo.getAuthor());
			preparedStatemet.setDouble(5, cartPojo.getPrice());
			preparedStatemet.setDouble(6, cartPojo.getTotalPrice());
			int i=preparedStatemet.executeUpdate();
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
	public List<CartPojo> getBookByUser(int userId) {
		// TODO Auto-generated method stub
		List<CartPojo> list=new ArrayList<CartPojo>();
		double totalPrice=0;
		try {
			String sql="select * from cart where userId=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				CartPojo cartPojo=new CartPojo();
				cartPojo.setCartId(resultSet.getInt(1));
				cartPojo.setBookId(resultSet.getInt(2));
				cartPojo.setUserId(resultSet.getInt(3));
				cartPojo.setBookName(resultSet.getString(4));
				cartPojo.setAuthor(resultSet.getString(5));
				cartPojo.setPrice(resultSet.getDouble(6));
				totalPrice=totalPrice+resultSet.getDouble(7);
				cartPojo.setTotalPrice(totalPrice);
				list.add(cartPojo);
				
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteBook(int bookId, int userId, int cartId) {
		// TODO Auto-generated method stub
		return false;
	}

}
