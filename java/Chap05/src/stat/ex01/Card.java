package stat.ex01;

public class Card {
	int num;
	static double width;
	
	//static은 class레벨에서만 상호 교환
	//static은 객체 이전에 가능
	
	//생성자 아님
	static void setCard (int n, double w) {
//		num=n; //num은 객체 변수, 클래스 레벨 아님
		width=w;
	}
	
	void method1 () {
		staticMethod1();
	}
	
	static void staticMethod1 () {
//		method1(); //error-객체 레벨
		staticMethod2();
	}
	
	static void staticMethod2 () {
		
	}
}
