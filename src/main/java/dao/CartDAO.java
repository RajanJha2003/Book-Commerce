package dao;

import java.sql.PreparedStatement;
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
		return false;
	}

	@Override
	public List<CartPojo> getBookByUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBook(int bookId, int userId, int cartId) {
		// TODO Auto-generated method stub
		return false;
	}

}
