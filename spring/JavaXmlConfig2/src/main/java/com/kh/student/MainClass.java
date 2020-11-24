package com.kh.student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Person p = ctx.getBean("kim", Person.class);
		Student s = ctx.getBean("lee", Student.class);
		
		System.out.println(p);
		System.out.println(s);
		
		ctx.close();
	}
}
