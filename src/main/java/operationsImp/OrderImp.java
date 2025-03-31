package operationsImp;

import java.util.List;

import dao.OrderDAO;
import model.OrderPojo;
import operations.OrderOperations;

public class OrderImp implements OrderOperations{

	@Override
	public boolean saveOrder(List<OrderPojo> b) {
		// TODO Auto-generated method stub
		return new OrderDAO().saveOrder(b);
	}

	@Override
	public List<OrderPojo> getBook(String email) {
		// TODO Auto-generated method stub
		return new OrderDAO().getBook(email);
	}

	@Override
	public List<OrderPojo> getAllOrder() {
		// TODO Auto-generated method stub
		return new OrderDAO().getAllOrder();
	}

}
