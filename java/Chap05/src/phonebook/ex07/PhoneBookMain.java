package phonebook.ex07;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
//		"1.데이터입력   2.검색   3.수정   4.삭제   5.프로그램 종료"
		
		PhoneBookManager manager=PhoneBookManager.getInstance();
		
		while (true) {
			MenuViewer.showMenu();
			String choice=MenuViewer.scanner.nextLine();
			
			switch (choice) {
			
			case "1" : 
				manager.read();
				break;
				
			case "2" :
				String searghName=MenuViewer.getsearchName()
				manager.search(searghName);
				break;
				
			case "3" :
				
				manager.modify();
				break;
				
			case "4" :
				manager.delete();
				break;
				
			case "5" :
				System.out.println("프로그램 종료");
				System.exit(0);
				return;
				
			case "98" :
				manager.test();
				break;
				
			case "99" :
				manager.show();
				break;
			
			}
		
		}
		
	} //main	
	
} //class

