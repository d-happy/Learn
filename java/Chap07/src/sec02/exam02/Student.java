package sec02.exam02;

public class Student extends People {
	
	public int studentNo;
	
	public Student(String name, String ssn, int studentNO) {
		super(name, ssn); //People(name, ssn)
		this.studentNo=studentNO;
	}

	@Override
	public void method1() {
		super.method1();
		System.out.println("B");
	}
	
	/*@Override
	public void method1() {
		System.out.println("AA");
	}*/
	
	
	
}//class
