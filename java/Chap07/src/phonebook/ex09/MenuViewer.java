package phonebook.ex09;

import java.util.Scanner;

//유틸리티 클래스
public class MenuViewer {
		
public static Scanner scanner = new Scanner(System.in);
	
	public static String showMenu() {
		System.out.println("1.데이터입력   2.검색   3.수정   4.삭제   5.프로그램종료");
		System.out.print("선택> ");
		String choice = scanner.nextLine();
		return choice;
	}
	
	// 검색할 이름 입력 받기
	public static String getSearchName() { 
		System.out.print("검색할 이름> ");
		String name = scanner.nextLine();
		return name;
	}
	
	// 수정할 데이터 입력 받기
	public static PhoneInfo inputUpdateData() {
		System.out.print("수정할 이름> ");
		String name = scanner.nextLine();
		System.out.print("수정할 전번> ");
		String phone = scanner.nextLine();
		PhoneInfo info = new PhoneInfo(name, phone);
		return info;
	}
	
	// 삭제할 이름 입력 받기
	public static String getDeleteName() {
		System.out.print("삭제할 이름> ");
		String name = scanner.nextLine();
		return name;
	}

} //class
