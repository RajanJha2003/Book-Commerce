package user_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.UserPojo;
import operationsImp.UserImp;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		
		try {
			if("admin@gmail.com".equals(email) && "admin".equals(password)) {
				UserPojo pojo=new UserPojo();
				pojo.setName("Admin");
				session.setAttribute("userobj", pojo);
				response.sendRedirect("admin/home.jsp");
			}else {
				UserImp imp=new UserImp();
				UserPojo us=imp.login(email, password);
				System.out.println(us);
				if (us != null) {
					session.setAttribute("userobj", us);
					response.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failedMsg", "Email & Password Invalid");
					response.sendRedirect("login.jsp");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
