package operations;

import java.util.List;

import model.BookPojo;
import model.CategoryPojo;

public interface BookOperations {
	public boolean addBooks(BookPojo bookPojo);
	public List<BookPojo> getAllBooks();
	public BookPojo getBookById(int id);
	public boolean updateBooks(BookPojo bookPojo);
	public boolean deleteBooks(int id);
	public List<BookPojo> getNewBook();
	public List<BookPojo> getRecentBooks();
	public List<BookPojo> getAllRecentBook();
	public List<BookPojo> getOldBooks();
	public List<BookPojo> getAllNewBook();
	public List<BookPojo> getAllOldBook();
	public List<BookPojo> getBookByOld(String email,String category);
	public List<BookPojo> oldBookDelete(String email,String category,int id);
	public List<BookPojo> getBookBySearch(String ch);
	public boolean createCategory(String category);
	public List<CategoryPojo> getAllCategory();
	
	

}
