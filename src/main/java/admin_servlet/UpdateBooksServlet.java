package admin_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BookPojo;

import java.io.IOException;

import dao.BookDAO;

@WebServlet("/edit-books")
public class UpdateBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		try {
			int bookId = Integer.parseInt(req.getParameter("bookId"));
			String bookName = req.getParameter("bookName");
			String author = req.getParameter("author");
			Double price = Double.parseDouble(req.getParameter("price"));
			String status = req.getParameter("status");
			String bookCategory = req.getParameter("bookCategory");
			String isbn = req.getParameter("isbn");
			
			BookPojo bookPojo=new BookPojo();
			bookPojo.setBookId(bookId);
			bookPojo.setBookName(bookName);
			bookPojo.setAuthor(author);
			bookPojo.setPrice(price);
			bookPojo.setStatus(status);
			bookPojo.setBookCategory(bookCategory);
			bookPojo.setIsbn(isbn);
			
			BookDAO bookDAO=new BookDAO();
			boolean updated=bookDAO.updateBooks(bookPojo);
			
			HttpSession session=req.getSession();
			
			
			if(updated) {
				session.setAttribute("succMsg", "Book Updated Successfully");
				response.sendRedirect("admin/all_books.jsp");
				
			}else {
				session.setAttribute("failedMsg", "Book Updated failed");
				response.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
