package FacultyManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class FacultyDriver {

	public static void main(String[] args) {
		FacultyService faServ=new FacultyService();
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
				System.out.println("Enter the ID");
				int id=sc.nextInt();
				System.out.println("Enter the name");
				String name=sc.next();
				System.out.println("Enter the age");
				int age=sc.nextInt();
				
				Faculty faculty=new Faculty();
				faculty.setId(id);
				faculty.setName(name);
				faculty.setAge(age);
				
				int res=faServ.insert(faculty);
				if(res!=0)System.out.println("data saved...");
				else System.out.println("data not saved...");
				break;
			case 2:
				//Update school data
				System.out.println("Enter the new name");
				String faName=sc.next();
				System.out.println("Enter the id");
				int sid=sc.nextInt();
				int res1=faServ.update(faName, sid);
				if(res1!=0)
					System.out.println("Record updated");
				else System.out.println("Record not updated");
				break;
			case 3:
				//Delete school data
				System.out.println("Enter the Id for delete");
				int id1=sc.nextInt();
				int res2=faServ.delete(id1);
				
				if(res2!=0)System.out.println("Record deleted");
				else System.out.println("Record not deleted");
				break;
			case 4:
				//View school data
				List<Faculty> list=faServ.viewData();
				
				if(!list.isEmpty())
				{
					for (Faculty faculty2 : list) {
						System.out.println(faculty2);
					}
				}
				else System.out.println("Not data found");
				break;
			case 5:
				//exit operation
				try {
					faServ.exit();
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
