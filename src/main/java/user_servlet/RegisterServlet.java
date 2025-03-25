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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name=req.getParameter("name");
			String email=req.getParameter("email");
			String phno=req.getParameter("phno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			
			UserPojo pojo=new UserPojo();
			pojo.setName(name);
			pojo.setEmail(email);
			pojo.setPhno(phno);
			pojo.setPassword(password);
			
			HttpSession session=req.getSession();
			
			if(check!=null) {
				UserImp userDAO=new UserImp();
				boolean existingUser=userDAO.checkUser(email);
				System.out.println(existingUser);
				
				if(!existingUser) {
					boolean registerUser=userDAO.userRegister(pojo);
					
					if(registerUser) {
						// System.out.println("User Register Success..");

						session.setAttribute("succMsg", "Registration Successfully..");
						resp.sendRedirect("register.jsp");
					}else {
						session.setAttribute("failedMsg", "Registration failed..");
						resp.sendRedirect("register.jsp");
					}
					
				}else {
					session.setAttribute("failedMsg", "User Already Exist Try Another Email id");
					resp.sendRedirect("register.jsp");
				}
				
			}else {
				session.setAttribute("failedMsg", "Please Check Agree & Terms Condition");
				resp.sendRedirect("register.jsp");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
