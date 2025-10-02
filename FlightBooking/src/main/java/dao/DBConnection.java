package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String url="jdbc:postgresql://localhost:5432/flightbooking?user=postgres&password=123";
	private static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url);		
	}
}
