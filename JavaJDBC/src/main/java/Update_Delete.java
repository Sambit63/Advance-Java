
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update_Delete {
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
//	private static String user = "postgres";
//	private static String pass = "123";
	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded\n");
		try {
			Connection conn = DriverManager.getConnection(url);
//			String sql="update principal set age=? where id in(?,?)";
//			String sql="delete from principal where id=?";
			String sql="Select id,name from principal where age=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 23);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("Id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
//				System.out.println("Age = "+rs.getInt(3));
//				System.out.println("Salary = "+rs.getInt(4));
//				System.out.println("Gender = "+rs.getString(5));
//				System.out.println("Phone no = "+rs.getBigDecimal(6));
//				System.out.println("Address = "+rs.getString(7));
			}
			System.out.println("\ndata loaded");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
