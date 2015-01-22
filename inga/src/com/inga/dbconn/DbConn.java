package com.inga.dbconn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbConn{
	
	public  List queryString(String sql){
		
		
		List list = new ArrayList();
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SessionFactory sessionFactory =(SessionFactory) ctx.getBean("sessionFactory");
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.createSQLQuery(sql);
		
		
		return list;
	}

	
	

}
