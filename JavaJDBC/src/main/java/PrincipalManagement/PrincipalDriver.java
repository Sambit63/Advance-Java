package PrincipalManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PrincipalDriver {

	public static void main(String[] args) {
		PrincipalService prServ=new PrincipalService();
		System.out.println("Welcome to School managements");
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		
		while(flag)
		{
			System.out.println("Press 1 to insert details");
			System.out.println("Press 2 to update details");
			System.out.println("Press 3 to delete details");
			System.out.println("Press 4 to view details");
			System.out.println("Press 5 to exit");
			int choice=sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the id");
				int id=sc.nextInt();
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("Enter the age");
				int age=sc.nextInt();
				System.out.println("Enter the salary");
				int sal=sc.nextInt();
				System.out.println("Enter the gender");
				String gender=sc.next();
				System.out.println("Enter the phone no");
				long phno=sc.nextLong();
				System.out.println("Enter the address");
				String address=sc.next();
				
				Principal principal=new Principal();
				principal.setId(id);
				principal.setName(name);
				principal.setAge(age);
				principal.setSalary(sal);
				principal.setGender(gender);
				principal.setPhno(phno);
				principal.setAddress(address);
				
				int res=prServ.insert(principal);
				if(res!=0)System.out.println("data saved...");
				else System.out.println("data not saved...");
				break;
			case 2:
				//Update school data
				System.out.println("Enter the new name");
				String prName=sc.next();
				System.out.println("Enter the id");
				int pid=sc.nextInt();
				int res1=prServ.update(prName, pid);
				if(res1!=0)
					System.out.println("Record updated");
				else System.out.println("Record not updated");
				break;
			case 3:
				//Delete principal data
				System.out.println("Enter the principal id for delete");
				int id1=sc.nextInt();
				int res2=prServ.delete(id1);
				
				if(res2!=0)System.out.println("Record deleted");
				else System.out.println("Record not deleted");
				break;
			case 4:
				//View school data
				List<Principal> list=prServ.viewData();
				
				if(!list.isEmpty())
				{
					for (Principal principal2 : list) {
						System.out.println(principal2);
					}
				}
				else System.out.println("Not data found");
				break;
			case 5:
				//exit operation
				try {
					prServ.exit();
					System.out.println("Connection Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag=false;
				break;
			default:
				break;
			}
		}
	}
}
