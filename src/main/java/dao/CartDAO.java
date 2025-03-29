package dao;

import java.util.List;

import model.CartPojo;
import operations.CartOperations;

public class CartDAO implements CartOperations {

	@Override
	public boolean addCart(CartPojo cartPojo) {
		// TODO Auto-generated method stub
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
