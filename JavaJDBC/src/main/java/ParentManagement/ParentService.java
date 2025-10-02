package ParentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ParentService {
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
	public int insert(Parent parent)
	{
		int res=0;
		String sql="insert into parent values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, parent.getId());
			ps.setString(2, parent.getName());
			ps.setLong(3, parent.getPhno());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int update(Long phone,int id)
	{
		int res=0;
		String sql="update parent set phone =? where id=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, phone);
			ps.setInt(2, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public int delete(int id)
	{
		int res=0;
		String sql="delete from parent where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public List<Parent> viewData()
	{
		List<Parent> list =new ArrayList<>();
		String sql="select * from parent";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
				list.add(new Parent(rs.getInt(1),rs.getString(2),rs.getLong(3)));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void exit() throws SQLException
	{
		con.close();
	}
}
