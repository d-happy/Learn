package phonebook.ex07;

import java.util.Scanner;

//��ƿ��Ƽ Ŭ����
public class MenuViewer {
		
	public static Scanner scanner=new Scanner(System.in);
	
	public static String showMenu () {
		System.out.println("1.�������Է�   2.�˻�   3.����   4.����   5.���α׷� ����");
		System.out.print("����> ");
		String choice=scanner.nextLine(); //MenuViewer class �ϱ� ��� �־ �׸�
		return choice;
	}
	
	public static String getsearchName() {
		System.out.print("�˻��� �̸�> ");
		String searghName=MenuViewer.scanner.nextLine();
		return searghName;
	}

	public static PhoneInfo getModifyName() {
		System.out.print("������ �̸�> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("������ ��ȭ��ȣ> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("������ ����> ");
		String birth=MenuViewer.scanner.nextLine();
		
		PhoneInfo Info=new PhoneInfo(name, phone, birth);
		
		return Info;
	}
	
	public static String getDeleteName() {
		System.out.print("������ �̸�> ");
		String deleteName=MenuViewer.scanner.nextLine();
		return deleteName;
	}

} //class
