package phonebook.ex04;

import java.util.Scanner;

//��ƿ��Ƽ Ŭ����
public class MenuViewer {
		
	public static Scanner scanner = new Scanner(System.in); 
	
	public static String showMenu () {
		System.out.println("1.�������Է� 2.���α׷�����");
		System.out.print("����> ");
		String choice = MenuViewer.scanner.nextLine();
		return choice;
	}

} //class
