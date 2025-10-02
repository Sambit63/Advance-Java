import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInput {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String pass = "123";
	public static void main(String[] args) throws ClassNotFoundException {
	Scanner sc=new Scanner(System.in);
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded\n");
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql="Insert into principal values(?,?,?,?,?,?,?)";
			System.out.println("Enter id,name,age,salary,gender, phno, address");
			int id=sc.nextInt();
			String name=sc.next();
			int age=sc.nextInt();
			int sal=sc.nextInt();
			String gender=sc.next();
			BigDecimal phno=sc.nextBigDecimal();
			String address=sc.next();
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setInt(4, sal);
			ps.setString(5, gender);
			ps.setBigDecimal(6, phno);
			ps.setString(7, address);
			ps.execute();
			System.out.println("\ndata loaded");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
