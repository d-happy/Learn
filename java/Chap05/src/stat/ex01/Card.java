package stat.ex01;

public class Card {
	int num;
	static double width;
	
	//static�� class���������� ��ȣ ��ȯ
	//static�� ��ü ������ ����
	
	//������ �ƴ�
	static void setCard (int n, double w) {
//		num=n; //num�� ��ü ����, Ŭ���� ���� �ƴ�
		width=w;
	}
	
	void method1 () {
		staticMethod1();
	}
	
	static void staticMethod1 () {
//		method1(); //error-��ü ����
		staticMethod2();
	}
	
	static void staticMethod2 () {
		
	}
}
