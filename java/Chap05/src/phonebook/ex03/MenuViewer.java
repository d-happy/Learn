package phonebook.ex03;

import java.util.Scanner;

//유틸리티 클래스
public class MenuViewer {
		
	static Scanner scanner = new Scanner(System.in); 
	
	static String showMenu () {
		System.out.println("1.데이터입력 2.프로그램종료");
		System.out.print("선택> ");
//		scanner.nextLine();
		String choice = MenuViewer.scanner.nextLine(); //여기서 입력을 choice라고 변수명 지으면서 변수로 저장함
		return choice; //showMenu(); 끝나면 return choice;해서 choice 남아있음
	}
	/*	
	String menu="1.데이터입력 2.프로그램종료";
	String choice="선택> ";
	MenuViewer () {
		this.menu=menu;
		this.choice=choice;
	}
	*/
		
} //class
