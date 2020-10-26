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
				System.out.println("���α׷� ����");
				MenuViewer.scanner.close();
				System.exit(0);
				return; 
			}
		}
	}		
	
	public static void readData() {
		
		PhoneInfo pInfo=new PhoneInfo();
		
		System.out.print("�̸�> ");
		String name=MenuViewer.scanner.nextLine();
		pInfo.setName(name);
		System.out.print("����> ");
		String phone=MenuViewer.scanner.nextLine();
		pInfo.setPhone(phone);
		System.out.print("����> ");
		String birth=MenuViewer.scanner.nextLine();
		pInfo.setBirth(birth);

		if (birth.equals("")) {
			pInfo.setBirth (null);
		}
	
		pInfo.showPhoneInfo();
	}
	
} //class

