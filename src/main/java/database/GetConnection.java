package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
	private static Connection conn;
  public static Connection getConnection() {
	  
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app", "root", "Rajan@2345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
  }
}
