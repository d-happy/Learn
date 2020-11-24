package com.kh.calc;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public int add() {
		return firstNum + secondNum;
	}
	
	public int sub() {
		return firstNum - secondNum;
	}
	
	public int mul() {
		return firstNum * secondNum;
	}
	
	public int div() {
		return firstNum / secondNum;
	}
	
	@Override
	public String toString() {
		return "MyCalculator [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
	}
	
}
