package accessor.b;

import accessor.a.ClassA;

public class ClassB {
	void method1 () {
		ClassA objA=new ClassA();
		objA.a=1;
//		objA.b=2; //다른 패키지이므로 디폴트 접근제어자에 접근(.) 할 수 없음
//		objA.c=3; //private 접근 제어자이므로 다른 클래스에서 접근할 수 없음
	}
	
} //class
