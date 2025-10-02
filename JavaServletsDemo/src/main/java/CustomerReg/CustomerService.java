package CustomerReg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerService {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	private static Connection con;
	
	static {
		try
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			con=DriverManager.getConnection(url);
			System.out.println("Connection Established");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public int insert(Customer cust)
	{
		int res=0;
		String sql="insert into customer values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, cust.getUsername());
			ps.setInt(2, cust.getAge());
			ps.setString(3, cust.getPassword());
			ps.setString(4, cust.getEmail());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
