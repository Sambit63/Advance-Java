import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDoperations {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
//	static
//	{
//		Class.forName("org.postgresql.Driver");
//	}
	public static void Insert(String sql) throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		try(Connection con=DriverManager.getConnection(url))
		{
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setInt(1, 101);
			ps.setString(2, "Sambit");
			ps.setInt(3, 45);
			
			ps.execute();
			System.out.println("Data Inserted");
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void update(String sql) throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		try(Connection con=DriverManager.getConnection(url))
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, 25);
			ps.setInt(2, 101);
			ps.execute();
			
			System.out.println("data updated");
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(String sql) throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		try(Connection con=DriverManager.getConnection(url))
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, 101);
			ps.execute();
			
			System.out.println("data deleted");
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fetch(String sql) throws ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		try(Connection con=DriverManager.getConnection(url))
		{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			System.out.println("\ndata fetched sucessfully");
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
//		String sql="insert into faculty values(?,?,?)";
//		Insert(sql);
		
//		String sql="update faculty set age=? where id=?";
//		update(sql);
		
//		String sql="Delete from faculty where id=?";
//		delete(sql);
		
		String sql="select * from faculty";
		fetch(sql);
	}
}
