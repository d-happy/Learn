package phonebook.ex05;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager=PhoneBookManager.getInstance();
		
		while (true) { 
			String choice=MenuViewer.showMenu(); 
			
			switch (choice) {
			case "1" :
				manager.readData();
				break;
				
			case "2" :	
				String searchName=MenuViewer.scanner.nextLine();
				manager.search(searchName);
				break;
				
			case "3" : //수정
				PhoneInfo info=MenuViewer.inputUpdateData();
				manager.modify(info);
				break;
				
			case "4" : //삭제
				String name=MenuViewer.scanner.nextLine();
				manager.remove(name);
				break;
				
			case "5" :
				System.out.println("프로그램 종료");
				MenuViewer.scanner.close();
				System.exit(0);
				return;
				
			case "98" :
				manager.insertTestData();
				break;
				
			case "99" :
				//데이터 전체 확인
				manager.showAll();
				break;
			}
		}
		
	} //main	
	
} //class

