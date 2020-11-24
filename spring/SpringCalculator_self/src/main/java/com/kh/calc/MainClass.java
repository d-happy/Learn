package com.kh.calc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
//		com.kh.calc.MyCalculator calc = new com.kh.calc.MyCalculator();
		
		String location = "classpath:application-context.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(location);
		
		MyCalculator calc = ctx.getBean("calc", MyCalculator.class);
		
		calc.setFirstNum(20);
		calc.setSecondNum(10);
		
		System.out.println(calc.add());
		System.out.println(calc.sub());
		System.out.println(calc.mul());
		System.out.println(calc.div());
		
		ctx.close();
	}
}
