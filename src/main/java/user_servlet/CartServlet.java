package user_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BookPojo;
import model.CartPojo;
import operationsImp.BookImp;
import operationsImp.CartImp;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int bookId=Integer.parseInt(request.getParameter("bookId"));
			int userId=Integer.parseInt(request.getParameter("userId"));
			String bookCategory=request.getParameter("bookCategory");
			
			BookImp bookImp=new BookImp();
			BookPojo bookDetails=bookImp.getBookById(bookId);
			CartPojo  cartPojo=new CartPojo();
			cartPojo.setBookId(bookId);
			cartPojo.setUserId(userId);
			cartPojo.setBookName(bookDetails.getBookName());
			cartPojo.setAuthor(bookDetails.getAuthor());
			cartPojo.setPrice(bookDetails.getPrice());
			cartPojo.setTotalPrice(bookDetails.getPrice());
			
			CartImp cartImp=new CartImp();
			boolean cartAdd=cartImp.addCart(cartPojo);
			
			HttpSession session=request.getSession();
			
			if(cartAdd) {
				session.setAttribute("succMsg", "Added to cart successfully");
				response.sendRedirect("all_books.jsp");
				
			}else {
				session.setAttribute("failedMsg", "Books cart failed");
				response.sendRedirect("admin/all_books.jsp");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
