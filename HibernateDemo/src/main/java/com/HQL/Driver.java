package com.HQL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.Test.Student;

public class Driver {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

//        transaction.begin();  

//        Students s1 = new Students(1, "Amit", 18, "Bhubaneswar", 85);
//        Students s2 = new Students(2, "Sita", 19, "Cuttack", 92);
//        Students s3 = new Students(3, "Ravi", 17, "Puri", 76);
//        Students s4 = new Students(4, "Sneha", 18, "Sambalpur", 88);
//        Students s5 = new Students(5, "Rahul", 20, "Rourkela", 67);
//        Students s6 = new Students(6, "Priya", 19, "Baleswar", 95);
//        Students s7 = new Students(7, "Karan", 18, "Berhampur", 73);
//        Students s8 = new Students(8, "Tina", 21, "Balangir", 82);
//        Students s9 = new Students(9, "Deepak", 20, "Jharsuguda", 90);
//        Students s10 = new Students(10, "Meena", 22, "Nayagarh", 79);
//        Students s11=new Students(11,"Sambit",23,"Banglore",89);
//        Students s12=new Students(12,"Pikun",22,"Hyderabad",79);
//        manager.persist(s1);
//        manager.persist(s2);
//        manager.persist(s3);
//        manager.persist(s4);
//        manager.persist(s5);
//        manager.persist(s6);
//        manager.persist(s7);
//        manager.persist(s8);
//        manager.persist(s9);
//        manager.persist(s10);
//        manager.persist(s11);
//        manager.persist(s12);
//        transaction.commit();
//        manager.close();
//        factory.close();
        
//        1.Age Greater than 20
//        Query query = manager.createQuery("from Students s where s.age>:age");
//        query.setParameter("age", 20);
        
//        2.Who lives in Banglore
//        Query query = manager.createQuery("from Students s where s.address=:address");
//        query.setParameter("address", "Banglore");
        
//        3.Names Starts with 'A'
//        Query query = manager.createQuery("from Students s where s.name like :name");
//        query.setParameter("name", "A%");
        
//        4.Marks Between 60 and 80
//        Query query = manager.createQuery("from Students s where s.marks between :m1 and :m2");
//        query.setParameter("m1", 60);
//        query.setParameter("m2", 80);
        
//       5.Top 3 Students with Higher Marks 
//        Query query = manager.createQuery("from Students s order by s.marks desc");
//        query.setMaxResults(3);
        
//      6.Fetch All Students order by age in descending order  
//        Query query = manager.createQuery("from Students s order by s.age desc");

//        7.City either Banglore or Hyderabad
//        Query query = manager.createQuery("from Students s where s.address in ('Banglore','Hyderabad')");
        
//        8.Count Students Who Lives in Banglore
//        Query query = manager.createQuery("select count(s) from Students s where s.address = :address");
//        query.setParameter("address", "Banglore");
//        Long count=(Long)query.getSingleResult();
//        System.out.println("Number of Students LIves in Baglore are ="+count);
        
//       9.Maximum Marks Scored By a student
//        Query query = manager.createQuery("select max(s.marks) from Students s");
//        Integer maxMark=(Integer)query.getSingleResult();
//        System.out.println("Maximun Mark is ="+maxMark);
        
//        10.ID and Marks where Marks greater than 75
        Query query = manager.createQuery("from Students s where s.marks > :marks");
        query.setParameter("marks", 75);
        
        List<Students> resultList = query.getResultList();
        for (Students s : resultList) {
            System.out.println(s.getId() + " " + s.getMarks());
        }

    }
}
