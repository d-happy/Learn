package com.kh.calc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {  // main 치고 Ctrl+spaceBar
//		com.kh.calc.MyCalculator calc = new com.kh.calc.MyCalculator();
		
		String location = "classpath:application-context.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		
//		MyCalculator calc = ctx.getBean("calc", MyCalculator.class);
		User user = ctx.getBean("user", User.class);
		
//		calc.setFirstNum(20);
//		calc.setSecondNum(10);
//		System.out.println(calc.add());
//		System.out.println(calc.sub());
//		System.out.println(calc.mul());
//		System.out.println(calc.div());
		
		user.add(20, 10);
		user.sub(20, 10);
		user.mul(20, 10);
		user.div(20, 10);
		
		ctx.close();

	}

} //MainClass
