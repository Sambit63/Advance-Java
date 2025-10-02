package Bcrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class WorkerLogin {
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
	public static boolean SignIn(Worker worker)
	{
		String sql="select password from worker where username=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, worker.getName());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				String storedPass=rs.getString("password");
//				Password Comparision using BCrypt
				if(BCrypt.checkpw(worker.getPass(), storedPass))
				{
					System.out.println("Login Sucessfull");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Invalid User Credentials");
		return false;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String name=sc.next();
		
		System.out.println("Enter password");
		String pass=sc.next();
		
		Worker worker=new Worker(name, pass);
		
		SignIn(worker);
		System.out.println("$2a$12$yrFPRgQo2gk/coFpUPTDR.4.uvreeeAYTM2Mykt71lqDdkrc38U26".length());
	}

}
