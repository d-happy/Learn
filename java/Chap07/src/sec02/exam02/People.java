package sec02.exam02;

public class People {
	public String name;
	public String ssn; //Social Secret Number
	
	public People(String name, String ssn) {
		super(); //java.lang.Object ������, super() ���� ���� -> �ڵ�����
		this.name = name;
		this.ssn = ssn;
	}
	
	public void method1() {
		System.out.println("A");
	}

}//class
