package sec04.exam01;

public class PrintfExample {

	public static void main(String[] args) {
		// printf, f : format(����)
		// printf("����", , , )
		int age=20;
		System.out.println("���̴� "+age+"�� �Դϴ�.");
		System.out.printf("���̴� %d�� �Դϴ�.\n", age);
		
		String name="�ٳ���";
		System.out.println("���̴� "+age+"�� �̰�, �̸��� "+name+"�Դϴ�.");
		System.out.printf("���̴� %d�� �̰�, �̸��� %s�Դϴ�.\n", age, name);
		System.out.printf("�츮�� �⼮�� 100%%\n");
		
		int price=100;
		System.out.printf("������ %6d���Դϴ�.\n", price); //�ڸ���6-������ ����(��)
		System.out.printf("������ %-6d���Դϴ�.\n", price); //�ڸ���6-������ ����(��)
		
		double pi=3.14;
		System.out.printf("������ ���� %f�Դϴ�.\n", pi);
		System.out.printf("������ ���� %10.2f�Դϴ�.\n", pi); //��ü�ڸ���.�Ҽ��������ڸ���
		System.out.printf("������ ���� %.2f�Դϴ�.\n", pi);
	}
}