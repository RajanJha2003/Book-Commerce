package operations;

import java.util.List;

import model.OrderPojo;

public interface OrderOperations {
public boolean saveOrder(List<OrderPojo> b);
	
	public List<OrderPojo> getBook(String email);
	
	public List<OrderPojo> getAllOrder();
}
