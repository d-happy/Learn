package phonebook.ex03;

import java.util.Scanner;

//��ƿ��Ƽ Ŭ����
public class MenuViewer {
		
	static Scanner scanner = new Scanner(System.in); 
	
	static String showMenu () {
		System.out.println("1.�������Է� 2.���α׷�����");
		System.out.print("����> ");
//		scanner.nextLine();
		String choice = MenuViewer.scanner.nextLine(); //���⼭ �Է��� choice��� ������ �����鼭 ������ ������
		return choice; //showMenu(); ������ return choice;�ؼ� choice ��������
	}
	/*	
	String menu="1.�������Է� 2.���α׷�����";
	String choice="����> ";
	MenuViewer () {
		this.menu=menu;
		this.choice=choice;
	}
	*/
		
} //class
