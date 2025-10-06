package com.ManyTOOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDriver {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
		System.out.println("EntityManagerFactory created: " + factory);

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

//		Product product = new Product(1, "Washing MC", 27438);
//		Reviews r1 = new Reviews(101, "Not Good", product);
//		Reviews r2 = new Reviews(102, "Ok Product", product);
		transaction.begin();

//		1.Insert Records
//		manager.persist(product);
//		manager.persist(r1);
//		manager.persist(r2);
//		transaction.commit();

//		2.Fetch Review With Product
//		Reviews reviews = manager.find(Reviews.class, 101);
//		if (reviews != null) {
//			System.out.println(reviews.getRid() + " " + reviews.getMsg());
//			Product product2 = reviews.getProduct();
//			if (product2 != null) {
//				System.out.println(product2.getPid() + " " + product2.getPname() + " " + product2.getPrice());
//
//			}
//		}
		
//		3.Delete Product
//		Product product=manager.find(Product.class, 1);
//		Reviews r1=manager.find(Reviews.class, 101);
//		Reviews r2=manager.find(Reviews.class, 102);
//		
//		if(product!=null)
//		{
//			r1.setProduct(null);
//			r2.setProduct(null);
//			manager.remove(product);
//			manager.merge(r1);
//			manager.merge(r2);
//			transaction.commit();
//		}
		
//		4.Update Product
//		Product product=manager.find(Product.class, 1);
//		if(product!=null)
//		{
//			product.setPrice(30000);
//			manager.merge(product);
//			transaction.commit();
//		}
		
//		5.Update Product and Reviews
		Product product=manager.find(Product.class, 1);
		Reviews reviews=manager.find(Reviews.class, 101);
		if(product!=null && reviews!=null)
		{
			product.setPrice(400000);
			reviews.setMsg("Expensive");
			manager.merge(product);
			manager.merge(reviews);
			transaction.commit();
		}
	}
}
