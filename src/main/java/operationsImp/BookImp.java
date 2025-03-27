package operationsImp;

import java.util.List;

import dao.BookDAO;
import model.BookPojo;
import operations.BookOperations;

public class BookImp implements BookOperations {

	@Override
	public boolean addBooks(BookPojo bookPojo) {
		// TODO Auto-generated method stub
		return new BookDAO().addBooks(bookPojo);
	}

	@Override
	public List<BookPojo> getAllBooks() {
		// TODO Auto-generated method stub
		return new BookDAO().getAllBooks();
	}

}
