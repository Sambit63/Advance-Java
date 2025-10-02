import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrincipalData {
	private static String url = "jdbc:postgresql://localhost:5432/school";
	private static String user="postgres";
	private static String pass="123";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			Step 1
			Class.forName("org.postgresql.Driver");
			
			try {
//				Step 2
				Connection conn=DriverManager.getConnection(url,user,pass);
				
//				Step 3
				Statement stmt=conn.createStatement();
				
//				Step 4
				String sql="Insert into principal values(101,'Soumya',30,60000,'male',7077321712,'Jajpur'),(104,'Sambit',23,50000,'male',7077321715,'Angul')";
//				String sql="Update principal set name='Pikun' where id=102";
//				String sql="Delete from principal where id=101";
				stmt.execute(sql);
				
				System.out.println("Data loaded Sucessfully");
//				Step 5
				conn.close();
				System.out.println("Connection closed sucessfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
