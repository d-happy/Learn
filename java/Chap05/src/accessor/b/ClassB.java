package accessor.b;

import accessor.a.ClassA;

public class ClassB {
	void method1 () {
		ClassA objA=new ClassA();
		objA.a=1;
//		objA.b=2; //�ٸ� ��Ű���̹Ƿ� ����Ʈ ���������ڿ� ����(.) �� �� ����
//		objA.c=3; //private ���� �������̹Ƿ� �ٸ� Ŭ�������� ������ �� ����
	}
	
} //class
