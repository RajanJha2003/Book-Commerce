package user_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import operationsImp.BookImp;

import java.io.IOException;

/**
 * Servlet implementation class DeleteOldBookServlet
 */
public class DeleteOldBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email=request.getParameter("email");
			int id=Integer.parseInt(request.getParameter("id"));
			BookImp bookImp=new BookImp();
			boolean delete=bookImp.oldBookDelete(email, "Old", id);
			HttpSession session=request.getSession();
			if(delete) {
				session.setAttribute("succMsg", "Old Book deleted successfully");
				response.sendRedirect("old_book.jsp");
		   }else {

				session.setAttribute("failedMsg", "Something wrong");
				response.sendRedirect("old_book.jsp");
		   
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
