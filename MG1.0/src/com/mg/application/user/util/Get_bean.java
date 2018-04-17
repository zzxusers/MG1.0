package com.mg.application.user.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public  class Get_bean {
	private static ApplicationContext axt=null;
	public static Object sel_bean(String beanid){
		/*ApplicationContext axt = new ClassPathXmlApplicationContext("applicationContext.xml");
		return axt.getBean(beanid);*/
		//Paper_service ps = (Paper_service) axt.getBean("paperService");
		//synchronized (Object.class) {//保证线程安全
			if(axt==null){
				axt = new ClassPathXmlApplicationContext("applicationContext.xml");
			}
		
		
		
		return axt.getBean(beanid);
		
	}
}
