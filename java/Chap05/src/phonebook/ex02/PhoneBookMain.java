package phonebook.ex02;

import java.util.Scanner;

public class PhoneBookMain {
	
	static Scanner scanner = new Scanner(System.in); //static 붙여서 class 어디서나 사용 가능
	
	public static void main(String[] args) {
		
		while (true) { //?번 반복할테니 while (true)
			showMenu();
			String choice = scanner.nextLine();
			
			switch (choice) {
			case "1" :
				readData();
				break;
			case "2" :
				System.out.println("프로그램 종료");
				System.exit(0); //<main class의 main method 종료 ==자바 프로그램 종료>, System.exit(0);은 <>=/= 그냥 다 종료시킴!!!
				return; //switch(); 종료하면서 최종값 ""을 내보냄, 즉 종료되면서 아무거도 안 나옴 실행 노노 포함된 함수만 끝
			}
		}
	}		

	public static void showMenu() {
		System.out.println("1.데이터입력 2.프로그램종료");
		System.out.print("선택> "); //print 해서 커서가 선택> "|" 바로 앞에 있게
	}
	
	public static void readData() {
		System.out.print("이름> ");
		String name=scanner.nextLine();
		System.out.print("전번> ");
		String phone=scanner.nextLine();
		System.out.print("생일> ");
		String birth=scanner.nextLine();

		if (birth.equals("")) { //공백의 (눈에 보여지는) 값="", ~.equals("") 해서 문자열만 비교
			birth=null;
		}
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		pInfo.showPhoneInfo();
	}
} //class

