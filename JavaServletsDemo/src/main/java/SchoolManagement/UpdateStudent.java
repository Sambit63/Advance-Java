package SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));

            Student s = new Student(id, name, age);
            StudentService sr = new StudentService();
            int res = sr.update(s);

            if (res > 0) {
               
                resp.sendRedirect("display.jsp");
            } else {
                out.println("<script>alert('Failed to Update Student');</script>");
                req.getRequestDispatcher("update.jsp").include(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('Error while updating student');</script>");
        }
    }
}
