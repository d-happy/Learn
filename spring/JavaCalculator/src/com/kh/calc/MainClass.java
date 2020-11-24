package com.kh.calc;

public class MainClass {

	public static void main(String[] args) {  // main 치고 Ctrl+spaceBar
		com.kh.calc.MyCalculator calc = new com.kh.calc.MyCalculator();
		calc.setFirstNum(20);
		calc.setSecondNum(10);
		
		System.out.println(calc.add());
		System.out.println(calc.sub());
		System.out.println(calc.mul());
		System.out.println(calc.div());

	}

}
