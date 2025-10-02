package Bcrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class WorkerRegister {
	private static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	private static Connection con;
	
	static {
		try
		{
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			con=DriverManager.getConnection(url);
			System.out.println("Connection Established");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static int SignUp(Worker worker)
	{
		String hashedPass=BCrypt.hashpw(worker.getPass(), BCrypt.gensalt(12));
		int res=0;
		String sql="insert into worker values(?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, worker.getName());
			ps.setString(2, hashedPass);
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the username");
		String name=sc.next();
		System.out.println("Enter Password");
		String pass=sc.next();
		
		Worker worker=new Worker();
		worker.setName(name);
		worker.setPass(pass);
		
		int res=SignUp(worker);
		if(res!=0)System.out.println("User Registered Sucessfully");
		else System.out.println("Failed to register");
	}

}
