import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExecution {
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		try {
			Connection conn=DriverManager.getConnection(url);
			String sql="Insert into student values(?,?,?)";
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1, 1001);
			ps.setString(2, "Sambit");
			ps.setInt(3, 24);
			ps.addBatch();
			
			ps.setInt(1, 1002);
			ps.setString(2, "Sam");
			ps.setInt(3, 25);
			ps.addBatch();
			
			ps.setInt(1, 1003);
			ps.setString(2, "Pikun");
			ps.setInt(3, 26);
			ps.addBatch();
			
			int batch[]=ps.executeBatch();
			System.out.println("data saved......");
			for(int i=0;i<batch.length;i++)
			System.out.println("rows affected: = "+batch[i]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
