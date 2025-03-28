package operationsImp;

import java.util.List;


import dao.BookDAO;

import model.BookPojo;
import model.CategoryPojo;
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

	@Override
	public BookPojo getBookById(int id) {
		// TODO Auto-generated method stub
		return new BookDAO().getBookById(id);
	}

	@Override
	public boolean updateBooks(BookPojo bookPojo) {
		// TODO Auto-generated method stub
		return new BookDAO().updateBooks(bookPojo);
	}

	@Override
	public boolean deleteBooks(int id) {
		// TODO Auto-generated method stub
		return new BookDAO().deleteBooks(id);
	}

	@Override
	public List<BookPojo> getNewBook() {
		// TODO Auto-generated method stub
		return new BookDAO().getNewBook();
	}

	@Override
	public List<BookPojo> getRecentBooks() {
		// TODO Auto-generated method stub
		return new BookDAO().getRecentBooks();
	}

	@Override
	public List<BookPojo> getOldBooks() {
		// TODO Auto-generated method stub
		return new BookDAO().getOldBooks();
	}

	@Override
	public List<BookPojo> getAllRecentBook() {
		// TODO Auto-generated method stub
		return new BookDAO().getAllRecentBook();
	}

	@Override
	public List<BookPojo> getAllNewBook() {
		// TODO Auto-generated method stub
		return new BookDAO().getAllNewBook();
	}

	@Override
	public List<BookPojo> getAllOldBook() {
		// TODO Auto-generated method stub
		return new BookDAO().getAllOldBook();
	}

	@Override
	public List<BookPojo> getBookByOld(String email, String category) {
		// TODO Auto-generated method stub
		return new BookDAO().getBookByOld(email, category);
	}

	@Override
	public List<BookPojo> oldBookDelete(String email, String category, int id) {
		// TODO Auto-generated method stub
		return new  BookDAO().oldBookDelete(email, category, id);
	}

	@Override
	public List<BookPojo> getBookBySearch(String ch) {
		// TODO Auto-generated method stub
		return new BookDAO().getBookBySearch(ch);
	}

	@Override
	public boolean createCategory(String category) {
		// TODO Auto-generated method stub
		return new BookDAO().createCategory(category);
	}

	@Override
	public List<CategoryPojo> getAllCategory() {
		// TODO Auto-generated method stub
		return new BookDAO().getAllCategory();
	}

}
