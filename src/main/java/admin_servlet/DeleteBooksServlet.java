package admin_servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import operationsImp.BookImp;

import java.io.IOException;


@WebServlet("/delete-books")
public class DeleteBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		
		BookImp imp=new BookImp();
		boolean deleted=imp.deleteBooks(bookId);
		
		HttpSession session=request.getSession();
		
		
		if(deleted) {
			session.setAttribute("succMsg", "Books deleted successfully");
			response.sendRedirect("admin/all_books.jsp");
			
		}else {
			session.setAttribute("failedMsg", "Books deleted failed");
			response.sendRedirect("admin/all_books.jsp");
			
		}
		
	}

}
