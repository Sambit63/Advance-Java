package com.CRUD;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Test.Student;

public class CustomerDriver {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
        System.out.println("EntityManagerFactory created: " + factory);

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        System.out.println("EntityManager created: " + manager);
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.Read one Record\n5.Read All records\n6.Exit");
			int n=sc.nextInt();
			switch (n) {
			case 1:{
				System.out.println("Enter the Id,Name,Gender,Age");
				int id=sc.nextInt();
				String name=sc.next();
				String gender=sc.next();
				int age=sc.nextInt();
				Customer c1=new Customer(id, name, gender, age);
				 transaction.begin();
		        manager.persist(c1); // save student in DB
		        transaction.commit();
		        System.out.println("Inserted Sucessfully");
			}break;
			case 2:{
				System.out.println("Enter the Id,Name,Gender,Age");
				int id=sc.nextInt();
				String name=sc.next();
				String gender=sc.next();
				int age=sc.nextInt();
				
				Customer c1=manager.find(Customer.class, id);
				if(c1!=null)
				{
					transaction.begin();
					c1.setId(id);
					c1.setName(name);
					c1.setGender(gender);
					c1.setAge(age);
					manager.merge(c1);
					
		        	transaction.commit();
		        	System.out.println("Updated Sucessfully");
				}
				else
				{
					System.out.println("User Not Exist");
				}
			}break;
			case 3:{
				System.out.println("Enter the Id to be delete");
				int id=sc.nextInt();
				Customer c1=manager.find(Customer.class, id);
				if(c1!=null)
				{
					transaction.begin();
					manager.remove(c1);
					transaction.commit();
					System.out.println("Deleted Sucessfully");
				}
				else System.out.println("Invalid Id ");
			}break;
			case 4:
			{
				System.out.println("Enter the Id to Fetch the records");
				int id=sc.nextInt();
				Customer c1=manager.find(Customer.class, id);
				if(c1!=null)
				{
					System.out.println(c1);
				}
				else System.out.println("Invalid Id ");
			}break;
			case 5:
			{
				Query query = manager.createQuery("from Student");
				List<Student> resultList=query.getResultList();
				for(Student s:resultList)System.out.println(s);
			}break;
			case 6:{
				flag=false;
				System.out.println("Thank You Visit Again");
			}break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
	}
}
