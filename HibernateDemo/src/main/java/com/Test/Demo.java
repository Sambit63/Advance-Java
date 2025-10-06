package com.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {

    public static void main(String[] args) {
        // Create EntityManagerFactory from persistence.xml
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
        System.out.println("EntityManagerFactory created: " + factory);

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        System.out.println("EntityManager created: " + manager);

        // Create student object
        Student s = new Student();
        s.setId(103);
        s.setName("Sam");
        s.setEmail("sambit@gmail.com");
        
        Student s1=new Student(102, "Pikun", "pikun@gmail.com");
        
        Teacher t1=new Teacher(201,"Girish",29);
        System.out.println("Student saved successfully: " + s);
        // Transaction block
//        transaction.begin();
//        manager.persist(s); // save student in DB
//        manager.persist(s1);
//        manager.persist(t1);
//        transaction.commit();


//        Delete Operation
//        int id=103;
//        Student st=manager.find(Student.class, id);
//        if(st!=null)
//        {
//        	transaction.begin();
//        	manager.remove(st);
//        	transaction.commit();
//        }
        
//        Fetch Operation
//        int id=201;
//        Teacher th=manager.find(Teacher.class, id);
//        if(th!=null)
//        {
//        	System.out.println(th);
//        }
//        else
//        {
//        	System.out.println("Teacher not exist");
//        }
        
//        Update Operation
        int id=201;
        Teacher th1=manager.find(Teacher.class, id);
        if(th1!=null)
        {
        	transaction.begin();
        	th1.setName("Sambit Kumar");
        	th1.setAge(23);
        	manager.merge(th1);
        	System.out.println("Updated");
        	transaction.commit();
        }
        else
        	System.out.println("Invalid id");
        // Cleanup
        manager.close();
        factory.close();
    }
}
