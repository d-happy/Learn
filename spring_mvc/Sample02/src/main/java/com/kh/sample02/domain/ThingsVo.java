package com.kh.sample02.domain;

public class ThingsVo {
	
	private String name;
	private int number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "thingsVo [name=" + name + ", number=" + number + "]";
	}
	
}
