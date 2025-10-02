package Demo.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class DemoGet extends HttpServlet{
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
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		
		System.out.println(user+" "+pass);
		boolean isValid=false;
		
//	Database Logic Starts
		String sql="select * from student where name=? and id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setInt(2, Integer.parseInt(pass));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())isValid=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
// Database Logic Ends here
		
		if(isValid)
		{
//			RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
//			dispatcher.forward(req, resp);
			resp.sendRedirect("home.jsp");
		}
		else
		{
//			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//			dispatcher.include(req, resp);
			PrintWriter pr = resp.getWriter();
			pr.print("<h3 style='color: red; position: absolute; top: 50px'>Invalid user credentials</h3>");
			resp.sendRedirect("index.jsp");

			
		}
	}
}
