package sec04.exam05;

import java.util.Scanner;

public class Example3 { //99p Ȯ�ι���3

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("[�ʼ� ���� �Է�]");
		
		System.out.println("1. �̸�: ");
		String str1=scanner.nextLine();

		System.out.println("2. �ֹι�ȣ �� 6�ڸ�: ");
		String str2=scanner.nextLine();
//		int num1=Integer.parseInt(str2);
		
		System.out.println("3. ��ȭ��ȣ: ");
		String str3=scanner.nextLine(); //010-123-4567
//		String str4=String.valueOf(str3);
		//int call1=Integer.parseInt(str3);
		//System.out.print(call1);
		
		System.out.println(); //���� 1
		
		System.out.println("[�Է��� ����]");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		//System.out.printf("1. �̸�: %s\n", str1);
		//System.out.printf("2. �ֺ��ȣ �� 6�ڸ�: %d\n", num1);
		//System.out.printf("3. ��ȭ��ȣ: %s\n", str4);
	}
}

// ����? ���û���? ������ <�ڼ��� ����> <�״�� ��µǰ�> �ۼ�!!!!1