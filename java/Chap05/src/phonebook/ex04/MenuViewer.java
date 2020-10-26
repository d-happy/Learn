package phonebook.ex04;

import java.util.Scanner;

//유틸리티 클래스
public class MenuViewer {
		
	public static Scanner scanner = new Scanner(System.in); 
	
	public static String showMenu () {
		System.out.println("1.데이터입력 2.프로그램종료");
		System.out.print("선택> ");
		String choice = MenuViewer.scanner.nextLine();
		return choice;
	}

} //class
