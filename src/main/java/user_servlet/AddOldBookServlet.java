package user_servlet;

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

@WebServlet("/add-old-book")
@MultipartConfig
public class AddOldBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String bookName=request.getParameter("bookName");
			   String author=request.getParameter("author");
			   Double price=Double.parseDouble(request.getParameter("price"));
			   String bookCategory="Old";
			   String status="Active";
			   Part part=request.getPart("bookImage");
			   String fileName=part.getSubmittedFileName();
			   String isbn=request.getParameter("isbn");
			   String useremail=request.getParameter("user");
			   
			   BookPojo bookPojo=new BookPojo();
			   bookPojo.setBookName(bookName);
			   bookPojo.setAuthor(author);
			   bookPojo.setPrice(price);
			   bookPojo.setBookCategory(bookCategory);
			   bookPojo.setStatus(status);
			   bookPojo.setPhotoName(fileName);
			   bookPojo.setEmail(useremail);
			   bookPojo.setIsbn(isbn);
			   
			   BookImp bookImp=new BookImp();
			   boolean oldbook=bookImp.addBooks(bookPojo);
			   HttpSession session=request.getSession();
			   if(oldbook) {
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
