package Demo.connector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/register")
public class DemoPost extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));

//		Databse Logics
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setAge(age);

		StudentService stServ = new StudentService();
		int res = stServ.insert(student);
		PrintWriter pr = resp.getWriter();

		if (res != 0) {
			System.out.println("Posted sucessfully");
			pr.print("<h1>" + "Registration was sucessfull !!!" + "</h1>");
			pr.print("<h4>" + "Student Id is " + id + "</h4>");
			pr.print("<h4>" + "Student name is " + name + "</h4>");
			pr.print("<h4>" + "Student age is " + age + "</h4>");
		} else {
			System.out.println("Failed to Register");
			pr.print("<h1>" + "Registration was failed " + "</h1>");
			
		}
	}
}
