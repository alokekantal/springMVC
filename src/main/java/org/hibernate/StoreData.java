package org.hibernate;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;  
  
public class StoreData {  
public static void main(String[] args) {  
      
    //creating configuration object  
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Transaction t = session.beginTransaction();
    Employee e1=new Employee();  
    e1.setId(777);
    e1.setName("aloke kantal");;  
    e1.setSalary(30000);
    e1.setDesignation("web Developer");
      
    session.persist(e1);//persisting the object  
      
    t.commit();//transaction is commited  
    session.close();  
      
    System.out.println("successfully saved");  
      
}  
}  
