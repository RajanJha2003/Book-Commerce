package user_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import operationsImp.UserImp;

import java.io.IOException;

@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String phno = request.getParameter("phno");
			String password = request.getParameter("password");
			HttpSession session=request.getSession();
			
			UserImp imp=new UserImp();
			
			boolean forgotPassword=imp.forgotPassword(email, phno, password);
			if (forgotPassword) {
				session.setAttribute("succMsg", "Password change sucessfully");
				response.sendRedirect("forgot.jsp");
			} else {
				session.setAttribute("failedMsg", "something wrong on server ! try again");
				response.sendRedirect("forgot.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
