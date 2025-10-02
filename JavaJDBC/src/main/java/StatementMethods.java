import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementMethods {
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver loaded");
		try {
			Connection con=DriverManager.getConnection(url);
			
		Statement stm=con.createStatement();
//		String sql="select * from student";
//		String sql="Insert into student values(10,'Amit',24)";
//		String sql="Delete from student where id in(1001,1002,1003,10)";
		String sql="update student set age=25 where name='Pikun'";
		
//		Execute Method
//		boolean exe=stm.execute(sql);
//		System.out.println(exe);
//		String res=!exe ?"data saved":"data not saved";
//		System.out.println(res);
		
		
//		ExecuteQuery Method
//		ResultSet rs=stm.executeQuery(sql);
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//		}
		
//		ExecuteUpdate Method
		int n=stm.executeUpdate(sql);
		String res=n!=0 ?"Data Updated":"Data Not Updated";
		System.out.println(res);
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
