package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import database.GetConnection;
import model.OrderPojo;
import operations.OrderOperations;

public class OrderDAO implements OrderOperations {
	
	private Connection conn;

	@Override
	public boolean saveOrder(List<OrderPojo> orders) {
	    boolean success = false;
	    try {
	        String sql = "INSERT INTO orders(orderId, userName, email, fulladd, phno, bookName, author, price, paymentType, orderStatus, isbn) " +
	                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement preparedStatement = GetConnection.getConnection().prepareStatement(sql);

	        for (OrderPojo order : orders) {
	            preparedStatement.setString(1, order.getOrderId());
	            preparedStatement.setString(2, order.getUserName());
	            preparedStatement.setString(3, order.getEmail());
	            preparedStatement.setString(4, order.getFulladd());
	            preparedStatement.setString(5, order.getPhno());
	            preparedStatement.setString(6, order.getBookName());
	            preparedStatement.setString(7, order.getAuthor());
	            preparedStatement.setDouble(8, order.getPrice());
	            preparedStatement.setString(9, order.getPaymentType());
	            preparedStatement.setString(10, order.getOrderStatus());
	            preparedStatement.setString(11, order.getIsbn());

	            preparedStatement.addBatch(); // Add to batch
	        }

	        int[] result = preparedStatement.executeBatch(); // Execute batch
	        success = result.length > 0;

	        ;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	
	public boolean updateStatus(String st, int id) {
		boolean f = false;
		try {

			String sql = "update orders set orderStatus=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			ps.setInt(2, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public List<OrderPojo> getBook(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPojo> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
