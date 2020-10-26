package sec01.exam04;

//MyClass가 final 클래스이므로 상속 안 됨
public class YourClass /* extends MyClass */ {
	//오버라이드 금지
	final public void method1() {
		System.out.println("메서드1");
	}

}
