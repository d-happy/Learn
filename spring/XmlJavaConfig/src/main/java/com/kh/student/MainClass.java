package com.kh.student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:application-context.xml");
		
		Person p = ctx.getBean("kim", Person.class);
		Student s = ctx.getBean("hong", Student.class);
		
		System.out.println("p :"+p);
		System.out.println("s :"+s);
	}
}
