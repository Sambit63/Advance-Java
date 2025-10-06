package com.OneTOOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CarDriver {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        
        Car c=new Car();
        c.setId(101);
        c.setName("BMW");
        c.setPrice(7500);
        
        Engine engine=new Engine(1, "petrol", 3200);
        c.setEngine(engine);
        
        transaction.begin();
//        1.Insert Record
//        manager.persist(c);
//        manager.persist(engine);
//        transaction.commit();
        
        Car car=manager.find(Car.class, 101);
//        2.Print Records
//        if(car!=null)
//        {
//        	System.out.println(car.getId()+" "+car.getName()+" "+car.getPrice());
//        	Engine e=car.getEngine();
//        	if(e!=null)
//        	{
//        		System.out.println(e.getEid()+" "+e.getFuel()+" "+e.getCc());
//        	}
//        }
        
//        3.Delete Engine
//        Engine en=manager.find(Engine.class, 1);
//        if(car!=null)
//          {
//          	Engine e=car.getEngine();
//          	car.setEngine(null);
//          	manager.remove(en);
//          	transaction.commit();
//          }
        
//        4.Deleting Car
//        if(car!=null)
//        {
//        	manager.remove(car);
//        	transaction.commit();
//        }
        
	}

}
