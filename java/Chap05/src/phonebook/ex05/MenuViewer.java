package phonebook.ex05;

import java.util.Scanner;

//��ƿ��Ƽ Ŭ����
public class MenuViewer {
		
	public static Scanner scanner = new Scanner(System.in); 
	
	public static String showMenu () {
		System.out.println("1.�������Է�   2.�˻�   3.����   4.����   5.���α׷� ����");
		System.out.print("����> ");
		String choice = MenuViewer.scanner.nextLine();
		return choice;
	}
	
	//�˻��� �̸� �Է� �ޱ�
	public static String getSearchName() {
		System.out.print("�˻��� �̸�> ");
		String name = MenuViewer.scanner.nextLine();
		return name;
	}
	
	//������ �̸� �Է� �ޱ�
	public static PhoneInfo inputUpdateData() {
		System.out.print("������ �̸�> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("������ ����> ");
		String phone = MenuViewer.scanner.nextLine();
		System.out.print("������ ����> ");
		String birth = MenuViewer.scanner.nextLine();
		
		PhoneInfo info=new PhoneInfo(name, phone, birth);
		return info;
	}
	
	//������ �̸� �Է� �ޱ�
	public static String getDelateName() {
		System.out.print("������ �̸�> ");
		String name = MenuViewer.scanner.nextLine();
		return name;
	}

} //class
