package StudentManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentDriver {

	public static void main(String[] args) {
		StudentService stServ=new StudentService();
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
				//Save School data
				System.out.println("Enter student id");
				int id=sc.nextInt();
				System.out.println("Enter student name");
				String name=sc.next();
				System.out.println("Enter student Age");
				int age=sc.nextInt();
				Student student=new Student();
				student.setId(id);
				student.setName(name);
				student.setAge(age);
				
				int res=stServ.insert(student);
				if(res!=0)System.out.println("data saved...");
				else System.out.println("data not saved...");
				break;
				
			case 2:
				//Update school data
				System.out.println("Enter the new name");
				String scName=sc.next();
				System.out.println("Enter the id");
				int sid=sc.nextInt();
				int res1=stServ.update(scName, sid);
				if(res1!=0)
					System.out.println("Record updated");
				else System.out.println("Record not updated");
				break;
			case 3:
				//Delete school data
				System.out.println("Enter the school for delete");
				int id1=sc.nextInt();
				int res2=stServ.delete(id1);
				
				if(res2!=0)System.out.println("Record deleted");
				else System.out.println("Record not deleted");
				break;
			case 4:
				//View school data
				List<Student> list=stServ.viewData();
				
				if(!list.isEmpty())
				{
					for (Student student2 : list) {
						System.out.println(student2);
					}
				}
				else System.out.println("Not data found");
				break;
			case 5:
				//exit operation
				try {
					stServ.exit();
					System.out.println("Connection Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag=false;
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}

}
