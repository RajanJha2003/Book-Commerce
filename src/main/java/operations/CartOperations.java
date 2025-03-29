package operations;

import java.util.List;

import model.CartPojo;

public interface CartOperations {
	
	public boolean addCart(CartPojo cartPojo);
	
	public List<CartPojo> getBookByUser(int userId);
	
	public boolean deleteBook(int bookId,int userId,int cartId);

}
