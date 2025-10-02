import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user = "postgres";
	private static String pass = "123";

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			Statement stm = conn.createStatement();

			String sql = "Select * from principal where age>21";
			ResultSet rs = stm.executeQuery(sql);
			System.out.println("Name" + "\t" + "age" + "\t" + "gender");
			System.out.println("-------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(5));
			}
			System.out.println("\ndata fetched sucessfully");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
