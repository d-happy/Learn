package ex01;

public class ExceptionEx {

	public static void main(String[] args) {
		int a=10;
		int b = 0;
		
		/*//�׳� 2���� ������ ������ ��
		 if (b != 0) {
			int c = a / b;
			System.out.println(c);
		} else {
			System.out.println("0���� ���� �� �����");
		}
		*/
		
		//���� ó�� ���� �ϴ� ����
		/*
		try {
			int c=a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
				System.out.println("0���� ���� �� �����");}
		*/
		
		try {
		method1(a, b);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("���α׷� ����");

	}
	//throws ~~~ : { ... } ����� �ȿ��� ... �� ó�� ���ϴ� ���� ������ "���� �޼���" ����
	public static int method1(int num1, int num2) throws ArithmeticException{
		int result=num1/num2;
		return result;
	}

}//class
