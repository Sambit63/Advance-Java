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
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.DBConnection;
import model.User;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE email=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("password");

                if (BCrypt.checkpw(password, hashedPassword)) {
                    // Build User object
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setAge(rs.getInt("age"));
                    user.setEmail(rs.getString("email"));
                    user.setPhone(rs.getString("phone"));
                    user.setRole(rs.getString("role"));

                    // Save user in session
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);

                    // Redirect based on role
                    if ("admin".equalsIgnoreCase(user.getRole())) {
                        resp.sendRedirect("adminDashboard.jsp");
                    } else {
                        resp.sendRedirect("userDashboard.jsp");
                    }
                } else {
                    // Invalid password
                    resp.setContentType("text/html");
                    PrintWriter out = resp.getWriter();
                    out.println("<h3 style='color:red; position:absolute; top:70px;'>Invalid Email or Password</h3>");
                    RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");
                    rd.include(req, resp);
                }
            } else {
                // No user found with given email
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                out.println("<h3 style='color:red; position:absolute; top:70px;'>User not found</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("SignUp.jsp");
                rd.include(req, resp);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            req.getRequestDispatcher("error.jsp").forward(req, resp);           
        }
    }
}
