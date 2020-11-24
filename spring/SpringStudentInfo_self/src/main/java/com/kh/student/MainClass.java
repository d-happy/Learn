package com.kh.student;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		String location = "classpath:app-ctx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		
//		Student student1 = ctx.getBean("stu1", Student.class);
//		Student student2 = ctx.getBean("stu1", Student.class);
//		System.out.println(student1);
//		System.out.println(student2);
		
		StudentInfo info = ctx.getBean("studentInfo", StudentInfo.class);
		
		info.showStudentInfo();
		
		ctx.close();
	}
}
