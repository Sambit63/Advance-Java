package SchoolManagement;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class DeleteStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		PrintWriter out=resp.getWriter();
		StudentService sr=new StudentService();
		int res=sr.delete(id);
		if(res!=0)
		{
			out.println("confirm('Deleted Sucessfully');");
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			out.println("confirm('Failed to Delete');");
			req.getRequestDispatcher("displayStudent.jsp").forward(req, resp);	
		}
	}
}
