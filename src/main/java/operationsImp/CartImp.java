package operationsImp;


import java.util.List;

import dao.CartDAO;

import model.CartPojo;
import operations.CartOperations;

public class CartImp implements CartOperations {

	@Override
	public boolean addCart(CartPojo cartPojo) {
		// TODO Auto-generated method stub
		return new CartDAO().addCart(cartPojo);
	}

	@Override
	public List<CartPojo> getBookByUser(int userId) {
		// TODO Auto-generated method stub
		return new CartDAO().getBookByUser(userId);
	}

	@Override
	public boolean deleteBook(int bookId, int userId, int cartId) {
		// TODO Auto-generated method stub
		return new CartDAO().deleteBook(bookId, userId, cartId);
	}
	public int countCart(int userId) {
		return new CartDAO().countCart(userId);
	}

}
