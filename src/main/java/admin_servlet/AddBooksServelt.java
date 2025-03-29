package admin_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.BookPojo;
import operationsImp.BookImp;

import java.io.File;
import java.io.IOException;
@MultipartConfig
@WebServlet("/add-books")
public class AddBooksServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   try {
		   String bookName=request.getParameter("bookName");
		   String author=request.getParameter("author");
		   int price=Integer.parseInt(request.getParameter("price"));
		   String bookCategory=request.getParameter("bookCategory");
		   String status=request.getParameter("status");
		   Part part=request.getPart("bookImage");
		   String fileName=part.getSubmittedFileName();
		   String isbn=request.getParameter("isbn");
		   
		   BookPojo bookPojo=new BookPojo();
		   bookPojo.setBookName(bookName);
		   bookPojo.setAuthor(author);
		   bookPojo.setPrice(price);
		   bookPojo.setBookCategory(bookCategory);
		   bookPojo.setStatus(status);
		   bookPojo.setPhotoName(fileName);
		   bookPojo.setEmail("admin");
		   bookPojo.setIsbn(isbn);
		   
		   BookImp imp=new BookImp();
		   boolean bookAdd=imp.addBooks(bookPojo);
		   
		   HttpSession session=request.getSession();
		   
		   if(bookAdd) {

				String path = getServletContext().getRealPath("") + "book";

				File file = new File(path);

				part.write(path + File.separator + fileName);
				
				session.setAttribute("succMsg", "Book added successfully");
				response.sendRedirect("admin/add_books.jsp");
		   }else {

				session.setAttribute("failedMsg", "Failed adding books");
				response.sendRedirect("admin/add_books.jsp");
			   
		   }
		   
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   
	   
	   
	   
	}

}
