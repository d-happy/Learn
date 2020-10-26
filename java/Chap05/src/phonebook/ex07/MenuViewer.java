package phonebook.ex07;

import java.util.Scanner;

//유틸리티 클래스
public class MenuViewer {
		
	public static Scanner scanner=new Scanner(System.in);
	
	public static String showMenu () {
		System.out.println("1.데이터입력   2.검색   3.수정   4.삭제   5.프로그램 종료");
		System.out.print("선택> ");
		String choice=scanner.nextLine(); //MenuViewer class 니까 없어도 있어도 그만
		return choice;
	}
	
	public static String getsearchName() {
		System.out.print("검색할 이름> ");
		String searghName=MenuViewer.scanner.nextLine();
		return searghName;
	}

	public static PhoneInfo getModifyName() {
		System.out.print("수정할 이름> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("수정할 전화번호> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("수정할 생일> ");
		String birth=MenuViewer.scanner.nextLine();
		
		PhoneInfo Info=new PhoneInfo(name, phone, birth);
		
		return Info;
	}
	
	public static String getDeleteName() {
		System.out.print("삭제할 이름> ");
		String deleteName=MenuViewer.scanner.nextLine();
		return deleteName;
	}

} //class
