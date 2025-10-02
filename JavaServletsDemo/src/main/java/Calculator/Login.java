package Calculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/signin")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("name");
		String pass=req.getParameter("password");
		
		HttpSession hs=req.getSession();
		hs.setAttribute("user", user);
		hs.setAttribute("pass", pass);
		
		req.getRequestDispatcher("chat.jsp").forward(req, resp);
	}
}
