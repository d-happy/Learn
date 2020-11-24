package com.kh.calc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		com.kh.calc.MyCalculator calc = new com.kh.calc.MyCalculator();
		
//		MyCalculator calc = ctx.getBean("calc", MyCalculator.class);
//		calc.setFirstNum(20);
//		calc.setSecondNum(10);
//		System.out.println(calc.add());
//		System.out.println(calc.sub());
//		System.out.println(calc.mul());
//		System.out.println(calc.div());
		
		String location = "classpath:application-context.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		User user = ctx.getBean("user", User.class);
		
		user.add(20, 10);
		user.sub(20, 10);
		user.mul(20, 10);
		user.div(20, 10);
		
		ctx.close();
	}
}
