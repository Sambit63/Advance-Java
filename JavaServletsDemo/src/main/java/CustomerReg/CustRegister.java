package CustomerReg;

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

@WebServlet("/signup")
public class CustRegister extends HttpServlet {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");

		System.err.println(name + " " + age + " " + pass + " " + email);
		boolean isExist = false;

//		Database Logic Starts
		String sql = "select * from customer where username=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next())
				isExist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Database Logic Ends here

		if (isExist) {
			resp.setContentType("text/html");
			PrintWriter pr=resp.getWriter();
			pr.print("<h3 style='color: red; position: absolute; top: 70px'>Username Already exist</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.include(req, resp);
		} else {
			Customer cust = new Customer();
			cust.setUsername(name);
			cust.setAge(age);
			cust.setPassword(pass);
			cust.setEmail(email);

			CustomerService cs = new CustomerService();
			int res = cs.insert(cust);

			if (res != 0) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}
}
