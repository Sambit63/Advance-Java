package com.OneTOMany;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankDriver {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sambit");
        System.out.println("EntityManagerFactory created: " + factory);

        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        System.out.println("EntityManager created: " + manager);
        
        Accounts ac1=new Accounts(101,"Pikun",186007);
        Accounts ac2=new Accounts(102, "Bob", 67990);
        
        List<Accounts> accounts=new LinkedList<>();
        accounts.add(ac1);
        accounts.add(ac2);
        
        Bank b=new Bank(1, "SBI", accounts);
        
        transaction.begin();
//        manager.persist(ac1);
//        manager.persist(ac2);
//        manager.persist(b);
//        transaction.commit();
//        System.out.println("Data Saved");
        
//       1. Fetch Records
//        Bank bank =manager.find(Bank.class, 1);
//        if(bank!=null)
//        {
//        	System.out.println(bank.getId()+" "+bank.getName());
//        	System.out.println("++++++++++++++++++++++++");
//        	
//        	List<Accounts> accs=bank.getAccounts();
//        	if(accounts!=null)
//        	{
//        		for(Accounts ac:accs)
//        			System.out.println(ac.getAcid()+" "+ac.getAcname()+" "+ac.getBalance());
//        	}
//        }
        
//        2. Update all Records
//        Bank bank=manager.find(Bank.class, 2);
//        if(bank!=null)
//        {
//        	bank.setName("ICICI");
//        	List<Accounts> list=bank.getAccounts();
//        	for (Accounts accounts2 : list) {
//				accounts2.setBalance(accounts2.getBalance()-1000);
//				manager.merge(accounts2);
//			}
//        	manager.merge(bank);
//        	transaction.commit();
//        }
        
//        3.Update Specific Records
//        Accounts actoUpdate=manager.find(Accounts.class, 101);
//        Bank bank=manager.find(Bank.class, 2);
//        if(bank!=null)
//        {
//        	List<Accounts> list =bank.getAccounts();
//        	for (Accounts accounts2 : list) {
//				if(accounts2.getAcid()==101)
//					actoUpdate=accounts2;
//			}
//        	actoUpdate.setBalance(50002);
//        	manager.merge(actoUpdate);
//        	manager.merge(bank);
//        	transaction.commit();
//        }
        
//        4.Deleting Bank deletes accounts also because of cascade Type
//        Bank bank=manager.find(Bank.class, 1);
//        if(bank!=null)
//        {
//        	manager.remove(bank);
//        	transaction.commit();
//        }
        
//        5.Add Acount in Existing Bank
        Accounts newAcc=new Accounts(105, "Smith", 500045);
        Bank bank=manager.find(Bank.class, 1);
        if(bank!=null)
        {
        	List<Accounts> list=bank.getAccounts();
        	list.add(newAcc);
        	bank.setAccounts(list);
        	manager.merge(bank);
        	transaction.commit();
        }
	}
}
