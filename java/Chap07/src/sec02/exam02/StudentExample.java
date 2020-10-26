package sec02.exam02;

public class StudentExample {

	public static void main(String[] args) {
		Student st1=
				new Student("김자바", "123456-124567", 2009140001);
		System.out.println("이름: "+st1.name);
		System.out.println("주민번호: "+st1.ssn);
		System.out.println("학번: "+st1.studentNo);
		
		
	}//main

}//class
