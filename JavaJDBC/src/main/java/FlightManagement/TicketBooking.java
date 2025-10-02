package FlightManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TicketBooking {
	private static String url="jdbc:postgresql://localhost:5432/airline?user=postgres&password=123";
	private static Connection con;
	
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url);
//			Setting autoCommit to false
			con.setAutoCommit(false);
			
			String sql1="insert into flight values(?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setInt(1, 7431);
			ps1.setString(2, "Air India");
			ps1.setString(3, "BLR");
			ps1.setString(4, "BBSR");
			ps1.execute();
			
			String sql2="insert into passenger values(?,?,?)";
			PreparedStatement ps2=con.prepareStatement(sql2);
			ps2.setInt(1, 101);
			ps2.setString(2, "Sambit");
			ps2.setInt(3, 23);
			ps2.execute();
			
//			Creating Savepoint
			Savepoint savepoint= con.setSavepoint();
			String sql3="insert into ticket values(?,?,?,?)";
			PreparedStatement ps3=con.prepareStatement(sql3);
			ps3.setInt(1, 1122);
			ps3.setString(2, "BLR");
			ps3.setString(3, "BBSR");
			ps3.setInt(4, 6000);
			ps3.execute();
			
			if(Payment.isSuccess() && con!=null)
			{
				System.out.println("Payment sucessful");
				con.commit();
			}
			else
			{
				System.out.println("Payment Failed");
//				Rolling back to Savepoint
				con.rollback(savepoint);
				con.commit();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
