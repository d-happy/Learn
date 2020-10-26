package phonebook.ex04;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		while (true) { 
			String choice=MenuViewer.showMenu(); 
			
			switch (choice) {
			case "1" :
				readData();
				break;
			case "2" :
				System.out.println("프로그램 종료");
				MenuViewer.scanner.close();
				System.exit(0);
				return; 
			}
		}
	}		
	
	public static void readData() {
		
		PhoneInfo pInfo=new PhoneInfo();
		
		System.out.print("이름> ");
		String name=MenuViewer.scanner.nextLine();
		pInfo.setName(name);
		System.out.print("전번> ");
		String phone=MenuViewer.scanner.nextLine();
		pInfo.setPhone(phone);
		System.out.print("생일> ");
		String birth=MenuViewer.scanner.nextLine();
		pInfo.setBirth(birth);

		if (birth.equals("")) {
			pInfo.setBirth (null);
		}
	
		pInfo.showPhoneInfo();
	}
	
} //class

