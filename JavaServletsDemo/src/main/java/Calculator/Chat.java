package Calculator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebServlet("/chat")
public class Chat extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		String user=(String) httpSession.getAttribute("user");
		String pass=(String) httpSession.getAttribute("pass");
		PrintWriter pr=resp.getWriter();
		pr.print("<h1> user name is "+user+"<h1>");
	}
}
