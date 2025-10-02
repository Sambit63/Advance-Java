package SchoolManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
	public boolean save(Student s)
	{
		int res=0;
		String sql="insert into student values(?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res!=0;
	}
	public List<Student> fetchAll()
	{
		List<Student> list=new ArrayList<>();
		String sql="select * from student";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				list.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int update(Student s)
	{
		int res=0;
		String sql="update student set name=?,age=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setInt(2, s.getAge());
			ps.setInt(3, s.getId());
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
		String sql="delete from student where id=?";
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
}
