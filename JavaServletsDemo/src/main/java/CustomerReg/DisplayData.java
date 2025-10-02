package CustomerReg;

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
@WebServlet("/sort")
public class DisplayData extends HttpServlet {
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
        String value = req.getParameter("sort");

        
        String sortColumn;
        switch (value) {
            case "age": sortColumn = "age"; break;
            case "username": sortColumn = "username"; break;
            case "email": sortColumn = "email"; break;
            default: sortColumn = "email"; 
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM customer ORDER BY " + sortColumn+" desc");
            ResultSet rs = ps.executeQuery();

            
            req.getRequestDispatcher("displayData.jsp").include(req, resp);

            // Print the table
            out.println("<h2>Customer List (Sorted by " + sortColumn + ")</h2>");
            out.println("<table border='1' cellpadding='5'>");
            out.println("<tr><th>Username</th><th>Age</th><th>Email</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getInt("age") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error fetching data</p>");
        }
    }
}


