package operations;

import java.util.List;

import model.BookPojo;

public interface BookOperations {
	public boolean addBooks(BookPojo bookPojo);
	public List<BookPojo> getAllBooks();
	public BookPojo getBookById(int id);
	public boolean updateBooks(BookPojo bookPojo);

}
