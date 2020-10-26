package phonebook.ex02;

import java.util.Scanner;

public class PhoneBookMain {
	
	static Scanner scanner = new Scanner(System.in); //static �ٿ��� class ��𼭳� ��� ����
	
	public static void main(String[] args) {
		
		while (true) { //?�� �ݺ����״� while (true)
			showMenu();
			String choice = scanner.nextLine();
			
			switch (choice) {
			case "1" :
				readData();
				break;
			case "2" :
				System.out.println("���α׷� ����");
				System.exit(0); //<main class�� main method ���� ==�ڹ� ���α׷� ����>, System.exit(0);�� <>=/= �׳� �� �����Ŵ!!!
				return; //switch(); �����ϸ鼭 ������ ""�� ������, �� ����Ǹ鼭 �ƹ��ŵ� �� ���� ���� ��� ���Ե� �Լ��� ��
			}
		}
	}		

	public static void showMenu() {
		System.out.println("1.�������Է� 2.���α׷�����");
		System.out.print("����> "); //print �ؼ� Ŀ���� ����> "|" �ٷ� �տ� �ְ�
	}
	
	public static void readData() {
		System.out.print("�̸�> ");
		String name=scanner.nextLine();
		System.out.print("����> ");
		String phone=scanner.nextLine();
		System.out.print("����> ");
		String birth=scanner.nextLine();

		if (birth.equals("")) { //������ (���� ��������) ��="", ~.equals("") �ؼ� ���ڿ��� ��
			birth=null;
		}
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		pInfo.showPhoneInfo();
	}
} //class

