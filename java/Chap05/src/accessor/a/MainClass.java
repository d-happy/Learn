package accessor.a;

public class MainClass {

	public static void main(String[] args) {
		ClassA objA=new ClassA();
		objA.a=1;
		objA.b=2;
//		objA.c=3; //private 접근 제어자이므로 다른 클래스에서 접근할 수 없음
	}

} //class
