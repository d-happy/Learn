package sec02.exam02;

public class People {
	public String name;
	public String ssn; //Social Secret Number
	
	public People(String name, String ssn) {
		super(); //java.lang.Object 생성자, super() 생략 가능 -> 자동생성
		this.name = name;
		this.ssn = ssn;
	}
	
	public void method1() {
		System.out.println("A");
	}

}//class
