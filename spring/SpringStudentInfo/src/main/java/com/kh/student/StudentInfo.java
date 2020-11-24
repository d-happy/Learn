package com.kh.student;

public class StudentInfo {
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void showStudentInfo() {
		String name = student.getName();
		String age = student.getAge();
		String gradeNum = student.getGradeNum();
		String classNum = student.getClassNum();
		
		System.out.println("이름 :" + name);
		System.out.println("나이 :" + age);
		System.out.println("학년 :" + gradeNum);
		System.out.println("반 :" + classNum);
	}
	
} //StudentInfo
