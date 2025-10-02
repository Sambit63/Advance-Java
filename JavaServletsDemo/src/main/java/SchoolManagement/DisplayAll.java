package SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class DisplayAll extends HttpServlet{
	private static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
    private static Connection con;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");
            con = DriverManager.getConnection(url);
            System.out.println("Connection Established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html");
	    try {
	        PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
	        ResultSet rs = ps.executeQuery();

	        PrintWriter out = resp.getWriter();
	        out.println("<html><body>");
	        out.println("<h2>Student List</h2>");
	        out.println("<table border='1' cellpadding='5'>");
	        out.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Actions</th></tr>");

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");

	            out.println("<tr>");
	            out.println("<td>" + id + "</td>");
	            out.println("<td>" + name + "</td>");
	            out.println("<td>" + age + "</td>");

	            // Action column: Edit + Delete buttons
	            out.println("<td>");
	            
	            // Edit form
	            out.println("<form action='update.jsp' method='get' style='display:inline;'>");
	            out.println("<input type='hidden' name='id' value='" + id + "'>");
	            out.println("<input type='submit' value='Edit'>");
	            out.println("</form>");

	            // Delete form
	            out.println("<form action='delete.jsp' method='post' style='display:inline;margin-left:5px;'>");
	            out.println("<input type='hidden' name='id' value='" + id + "'>");
	            out.println("<input type='submit' value='Delete' onclick=\"return confirm('Are you sure you want to delete this student?');\">");
	            out.println("</form>");

	            out.println("</td>");
	            out.println("</tr>");
	        }

	        out.println("</table>");
	        out.println("</body></html>");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
