package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		
		List<OrderPojo> list=new ArrayList<OrderPojo>();
		try {
			String sql="select * from orders where email=?";
			PreparedStatement preparedStatement=GetConnection.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, email);
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				OrderPojo orderPojo=new OrderPojo();
				orderPojo.setId(resultSet.getInt(1));
				orderPojo.setOrderId(resultSet.getString(2));
				orderPojo.setUserName(resultSet.getString(3));
				orderPojo.setEmail(resultSet.getString(4));
				orderPojo.setFulladd(resultSet.getString(5));
				orderPojo.setPhno(resultSet.getString(6));
				orderPojo.setBookName(resultSet.getString(7));
				orderPojo.setAuthor(resultSet.getString(8));
				orderPojo.setPrice(resultSet.getDouble(9));
				orderPojo.setPaymentType(resultSet.getString(10));
				orderPojo.setOrderStatus(resultSet.getString(11));
				orderPojo.setIsbn(resultSet.getString(12));
				
				list.add(orderPojo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<OrderPojo> getAllOrder() {
		List<OrderPojo> list = new ArrayList<OrderPojo>();
		OrderPojo o = null;

		try {

			String sql = "select * from book_order ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				o = new OrderPojo();
				o.setId(rs.getInt(1));
				o.setOrderId(rs.getString(2));
				o.setUserName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setFulladd(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBookName(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getDouble(9));
				o.setPaymentType(rs.getString(10));
				o.setOrderStatus(rs.getString(11));
				o.setIsbn(rs.getString(12));
				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
