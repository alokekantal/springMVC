package com.PG.dao;
import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.PG.entity.Artical;

@Transactional
@Repository
public class ArticalDAO {
	public List getAllArticales() {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Criteria c = session.createCriteria(Artical.class);
		 return c.list();		 
	}
	
	public Serializable createArticle(Artical artical) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Serializable id = session.save(artical);
		t.commit();
		session.close();
		return id;
	}
}
