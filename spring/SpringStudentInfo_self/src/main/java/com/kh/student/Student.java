package com.kh.student;

public class Student {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	// 기본 생성자 노노
	
	public Student(String name, String age, String gradeNum, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

//	@Override
//	public String toString() {
//		return "Student [name=" + name + ", age=" + age + ", gradeNum=" + gradeNum + ", classNum=" + classNum + "]";
//	}
	
}
