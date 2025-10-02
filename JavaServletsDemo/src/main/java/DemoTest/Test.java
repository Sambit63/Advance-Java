package DemoTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test")
public class Test extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String company=context.getInitParameter("company");
		String username=context.getInitParameter("user");
		String pass=context.getInitParameter("password");
		
		System.out.println(company+" "+username+" "+pass);
		PrintWriter pr=resp.getWriter();
		pr.print("<h1>"+"Company name is "+company+"</h1");
		pr.print("<h1>"+"User name is "+username+"</h1");
		pr.print("<h1>"+"Password is "+pass+"</h1");
	}
}
