package FacultyManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacultyService {
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
	public int insert(Faculty faculty)
	{
		int res=0;
		String sql="insert into faculty values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, faculty.getId());
			ps.setString(2, faculty.getName());
			ps.setInt(3, faculty.getAge());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public int update(String name,int id)
	{
		int res=0;
		String sql="update faculty set name =? where id=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int delete(int id)
	{
		int res=0;
		String sql="delete from faculty where id=?";
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
	public List<Faculty> viewData()
	{
		List<Faculty> list =new ArrayList<>();
		String sql="select * from faculty";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
				list.add(new Faculty(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			
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
