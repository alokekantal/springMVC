package org.hibernate;

import java.util.ArrayList;

import org.hibernate.cfg.Configuration;

public class StoreQuestion {
	public static void main(String[] args) { 
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		
		ArrayList<String> answer1 = new ArrayList<String>();		
		answer1.add("java is a programming language");  
		answer1.add("java is a platform"); 
		
		Question question1 = new Question();
		question1.setId(1);
		question1.setqName("What is Java?");  
	    question1.setAnswer(answer1);
	    
	    ArrayList<String> answer2 = new ArrayList<String>();		
	    answer2.add("Servlet is an Interface");  
	    answer2.add("Servlet is an API");
		
		Question question2 = new Question();
		question2.setqName("What is Java?");  
	    question2.setAnswer(answer2);
	    
	    session.persist(question1);
	    session.persist(question2);
	    t.commit();
	    session.close();
	    System.out.println("success");  
	}
}
