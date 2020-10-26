package accessor.a;

public class ClassA {

	public int a;
	int b;
	private int c;
	
	void method2 () {
		c=c+1; //private은 개인(같은 클래스 내)에서만 접근 가능
	}
	
} //class
