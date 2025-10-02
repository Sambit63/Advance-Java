package ParentManagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ParentDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParentService prServ=new ParentService();
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
				System.out.println("Enter parent id");
				int id=sc.nextInt();
				System.out.println("Enter parent name");
				String name=sc.next();
				System.out.println("Enter parent Phone Number");
				long phone=sc.nextLong();
				Parent parent=new Parent();
				parent.setId(id);
				parent.setName(name);
				parent.setPhno(phone);
				
				int res=prServ.insert(parent);
				if(res!=0)System.out.println("data saved...");
				else System.out.println("data not saved...");
				break;
				
			case 2:
				//Update school data
				System.out.println("Enter the new number");
				long pPhno=sc.nextLong();
				System.out.println("Enter the id");
				int sid=sc.nextInt();
				int res1=prServ.update(pPhno, sid);
				if(res1!=0)
					System.out.println("Record updated");
				else System.out.println("Record not updated");
				break;
			case 3:
				//Delete school data
				System.out.println("Enter the Parent Id for delete");
				int id1=sc.nextInt();
				int res2=prServ.delete(id1);
				
				if(res2!=0)System.out.println("Record deleted");
				else System.out.println("Record not deleted");
				break;
			case 4:
				//View school data
				List<Parent> list=prServ.viewData();
				
				if(!list.isEmpty())
				{
					for (Parent parent2 : list) {
						System.out.println(parent2);
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
				System.out.println("Invalid choice");
				break;
			}
		}
	}

}
