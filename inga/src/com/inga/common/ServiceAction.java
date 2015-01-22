package com.inga.common;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceAction {
	

	public static final Object userService(String serviceName){
		Object obj = null;
		try {
			
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			obj =(Object) ctx.getBean(serviceName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
