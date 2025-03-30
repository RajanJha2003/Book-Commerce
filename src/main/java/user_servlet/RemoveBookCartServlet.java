package user_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import operationsImp.CartImp;

import java.io.IOException;

@WebServlet("/remove_book")
public class RemoveBookCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		int cartId=Integer.parseInt(request.getParameter("cartId"));
		CartImp cartImp=new CartImp();
		boolean removed=cartImp.deleteBook(bookId, userId, cartId);
		
		HttpSession session=request.getSession();
		
		
		if(removed) {
			session.setAttribute("succMsg", "Books removed from cart");
			response.sendRedirect("admin/all_books.jsp");
			
		}else {
			session.setAttribute("failedMsg", "Something went wrong");
			response.sendRedirect("admin/all_books.jsp");
			
		}
	}

	

}
