package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.DBConnection;
import dao.UserDAO;
import model.User;
import validation.Validate;

@WebServlet("/signup")
public class UserRegister extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		String phone=req.getParameter("phone");
		
//		Hashing + Salting Password
		String hashedPass=BCrypt.hashpw(password, BCrypt.gensalt(12));
		
//		Check wheather email already exist
		boolean isExist = false;
		if (!(Validate.isEmailValid(email) && Validate.isPassValid(password)) && Validate.isPhoneValid(phone)) {
			resp.setContentType("text/html");
			resp.getWriter()
					.write("<h3 style='color: red; position: absolute; top: 70px'>Invalid Email or Password or Phone!</h3>");
			req.getRequestDispatcher("signUp.jsp").include(req, resp);
			return;
		}

//		Db Logic
//		Database Logic Starts
		String sql = "select * from users where email=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				isExist=true;
			
//			Data entry
			if (isExist) {
				resp.setContentType("text/html");
				PrintWriter pr=resp.getWriter();
				pr.print("<h3 style='color: red; position: absolute; top: 70px;margin:auto'>Username Already exist</h3>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("signUp.jsp");
				dispatcher.include(req, resp);
			} else {
				User user=new User();
				user.setName(name);
				user.setAge(age);
				user.setEmail(email);
				user.setPassword(password);
				user.setPassword(hashedPass);
				user.setPhone(phone);
				user.setRole(role);
				UserDAO ud=new UserDAO();
				boolean res=ud.registerUser(user);

				if (res) {
					resp.setContentType("text/html");
					PrintWriter pr=resp.getWriter();
					pr.print("<h3 style='color: red; position: absolute; top: 70px;margin:auto'>Registered Sucessfully Now please login !!</h3>");
					RequestDispatcher dispatcher = req.getRequestDispatcher("signUp.jsp");
					dispatcher.include(req, resp);
				} else {
					RequestDispatcher dispatcher = req.getRequestDispatcher("error.jsp");
					dispatcher.forward(req, resp);
				}
			}
			
//			Data entry ends
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
	}
}
