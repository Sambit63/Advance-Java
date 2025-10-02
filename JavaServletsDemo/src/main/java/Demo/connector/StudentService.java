package Demo.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentService {
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
	public int insert(Student student)
	{
		int res=0;
		String sql="insert into student values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
