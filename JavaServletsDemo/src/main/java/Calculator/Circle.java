package Calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Circle extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double radius = Double.parseDouble(req.getParameter("radius"));
		ServletConfig config = getServletConfig();
		double pi = Double.parseDouble(config.getInitParameter("pi"));

		double res = pi * radius * radius;
		double peri = 2 * pi * radius;

		// pass values to JSP
		req.setAttribute("area", res);
		req.setAttribute("perimeter", peri);

		// forward to JSP (not include)
		RequestDispatcher dispatcher = req.getRequestDispatcher("calculator.jsp");
		dispatcher.forward(req, resp);

	}
}
