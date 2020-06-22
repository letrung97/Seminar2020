package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	public static Connection connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantdb","root","123456");
			return conn;
		}
		catch (Exception ex){
			return null;
		}
		
	}
}
