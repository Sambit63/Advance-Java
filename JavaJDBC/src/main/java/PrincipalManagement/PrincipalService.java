package PrincipalManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SchoolManagement.School;

public class PrincipalService {
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
	
	public int insert(Principal principal)
	{
		int res=0;
		String sql="insert into principal values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, principal.getId());
			ps.setString(2, principal.getName());
			ps.setInt(3, principal.getAge());
			ps.setInt(4, principal.getSalary());
			ps.setString(5, principal.getGender());			
			ps.setLong(6, principal.getPhno());
			ps.setString(7, principal.getAddress());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public int update(String name,int id)
	{
		int res=0;
		String sql="update principal set name =? where id=?";
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
		String sql="delete from principal where id=?";
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
	public List<Principal> viewData()
	{
		List<Principal> list =new ArrayList<>();
		String sql="select * from principal";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next())
				list.add(new Principal(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getLong(6), rs.getString(7)));
			
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
