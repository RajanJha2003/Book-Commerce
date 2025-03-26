package operationsImp;

import dao.BookDAO;
import model.BookPojo;
import operations.BookOperations;

public class BookImp implements BookOperations {

	@Override
	public boolean addBooks(BookPojo bookPojo) {
		// TODO Auto-generated method stub
		return new BookDAO().addBooks(bookPojo);
	}

}
