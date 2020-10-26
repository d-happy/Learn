package phonebook.ex03;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		while (true) { 
			
			String choice=MenuViewer.showMenu(); 
			//MenuViewer class로 메뉴 나오고 고르게 하고 return choice; 해서 메인 클래스에서도 choice 사용 가능
			
			switch (choice) {
			case "1" :
				readData();
				break;
			case "2" :
				System.out.println("프로그램 종료");
				MenuViewer.scanner.close();
				//종료하기 전에 MenuViewer class에 있는 scanner 종료 (다른 class라서 System.exit(0);이 영향 못 끼침)
				System.exit(0);
				return; 
			}
		}
	}		
	
	public static void readData() {
		System.out.print("이름> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전번> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("생일> ");
		String birth=MenuViewer.scanner.nextLine();

		if (birth.equals("")) {
			birth=null;
		}
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		pInfo.showPhoneInfo();
		/*
		PhoneInfo[] arrInfo=new PhoneInfo[100];
		arrInfo[0]=pInfo;
		
		for (int i=0; i<100; i++ ) {
			arrInfo[i]=new PhoneInfo(name, phone, birth);
		}
		
		arrInfo[1].showPhoneInfo();
		*/
	}
} //class

