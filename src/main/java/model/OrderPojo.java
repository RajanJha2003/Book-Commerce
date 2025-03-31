package model;

public class OrderPojo {
	private int id;
	private String orderId;
	private String userName;
	private String email;
	private String phno;
	private String fulladd;

	private String bookName;
	private String author;
	private Double price;

	private String paymentType;

	private String orderStatus;

	private String isbn;

	@Override
	public String toString() {
		return "OrderPojo [id=" + id + ", orderId=" + orderId + ", userName=" + userName + ", email=" + email
				+ ", phno=" + phno + ", fulladd=" + fulladd + ", bookName=" + bookName + ", author=" + author
				+ ", price=" + price + ", paymentType=" + paymentType + ", orderStatus=" + orderStatus + ", isbn="
				+ isbn + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getFulladd() {
		return fulladd;
	}

	public void setFulladd(String fulladd) {
		this.fulladd = fulladd;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
