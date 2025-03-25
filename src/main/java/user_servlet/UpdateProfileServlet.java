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

import dao.UserDAO;

@WebServlet("/update-profile")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phno=request.getParameter("phno");
			String password=request.getParameter("password");
			
			UserPojo pojo=new UserPojo();
			pojo.setId(id);
			pojo.setName(name);
			pojo.setEmail(email);
			pojo.setPhno(phno);
			
			UserImp imp=new UserImp();
			
			boolean checkPassword=imp.checkPassword(id, password);
			HttpSession session=request.getSession();
			
			
			if(checkPassword) {
				boolean update=imp.updateProfile(pojo);
				if(update) {
					session.setAttribute("succMsg","Profile Update Successfully..");
					response.sendRedirect("edit_profile.jsp");
				}else {
					session.setAttribute("failedMsg","Something wrong on server");
					response.sendRedirect("edit_profile.jsp");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
