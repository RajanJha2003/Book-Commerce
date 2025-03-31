package user_servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.BookPojo;
import model.CartPojo;
import model.OrderPojo;
import operationsImp.BookImp;
import operationsImp.CartImp;
import operationsImp.OrderImp;




@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			HttpSession session = req.getSession();

			int id = Integer.parseInt(req.getParameter("id"));

			String name = req.getParameter("username");

			String email = req.getParameter("email");

			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");
			String totalPrice = req.getParameter("totalPrice");
			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;
			if ("COD".equals(paymentType)) {

				/* System.out.println(name+" "+email+" "+phno+" "+fullAdd+" "+paymentType); */

				CartImp cartImp=new CartImp();
				BookImp daox=new BookImp();
				List<CartPojo> blist = cartImp.getBookByUser(id);

				if (blist.isEmpty()) {
					session.setAttribute("failedMsg", "Add Item");
					resp.sendRedirect("checkout.jsp");
				} else {
					OrderImp orderImp=new OrderImp();
					OrderPojo o = null;

					ArrayList<OrderPojo> orderList = new ArrayList<OrderPojo>();
					Random r = new Random();
					for (CartPojo c : blist) {
						o = new OrderPojo();
						BookPojo b=daox.getBookById(c.getBookId());
						o.setOrderId("BOOK-ORD-00" + r.nextInt(1000));
						o.setUserName(name);
						o.setEmail(email);
						o.setPhno(phno);
						o.setFulladd(fullAdd);
						o.setBookName(c.getBookName());
						o.setAuthor(c.getAuthor());
						o.setPrice(Double.valueOf(c.getPrice()));

						o.setPaymentType("COD");
						o.setIsbn(b.getIsbn());
						orderList.add(o);

					}

					if ("noselect".equals(paymentType)) {
						session.setAttribute("failedMsg", "Choose Payment Method");
						resp.sendRedirect("checkout.jsp");
					} else {
						boolean f = orderImp.saveOrder(orderList);

						if (f) {
							resp.sendRedirect("order_success.jsp");
						} else {
							session.setAttribute("failedMsg", "Your Order Failed");
							resp.sendRedirect("checkout.jsp");
						}
					}
				}
			} else if ("noselect".equals(paymentType)) {
				session.setAttribute("failedMsg", "Choose Payment Method");
				resp.sendRedirect("checkout.jsp");
			}

			else {
				resp.sendRedirect("cardpayment.jsp?un=" + name + "&&em=" + email + "&&ph=" + phno + "&&ad=" + fullAdd
						+ "&&ta=" + totalPrice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}