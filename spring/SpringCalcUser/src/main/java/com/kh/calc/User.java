package com.kh.calc;

public class User { // MyCalculator 관련만 넣기???
	private MyCalculator calc;

	public MyCalculator getCalc() {
		return calc;
	}

	public void setCalc(MyCalculator calc) {
		this.calc = calc;
	}
	
	public void add (int num1, int num2) { // 변수 넣으면 calc가 알아서 처리
		calc.setFirstNum(num1);
		calc.setSecondNum(num2);
		int result = calc.add();
		System.out.println("+ 결과 :" + result);
	}
	
	public void sub (int num1, int num2) {
		calc.setFirstNum(num1);
		calc.setSecondNum(num2);
		int result = calc.sub();
		System.out.println("- 결과 :" + result);
	}
	
	public void mul (int num1, int num2) {
		calc.setFirstNum(num1);
		calc.setSecondNum(num2);
		int result = calc.mul();
		System.out.println("* 결과 :" + result);
	}
	
	public void div (int num1, int num2) {
		calc.setFirstNum(num1);
		calc.setSecondNum(num2);
		int result = calc.div();
		System.out.println("/ 결과 :" + result);
	}
	
} //User
