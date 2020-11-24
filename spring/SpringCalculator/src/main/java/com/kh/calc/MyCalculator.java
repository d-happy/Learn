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
	
	// 더하기
	public int add() {
		return firstNum + secondNum;
	}
	
	// 빼기기
	public int sub() {
		return firstNum - secondNum;
	}
	
	// 곱하기
	public int mul() {
		return firstNum * secondNum;
	}
	// 나누기
	public int div() {
		return firstNum / secondNum;
	}
	
	@Override
	public String toString() {
		return "MyCalculator [firstNum=" + firstNum + ", secondNum=" + secondNum + "]";
	}
	
} //MyCalculator
