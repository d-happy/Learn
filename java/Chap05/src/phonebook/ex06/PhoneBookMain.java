package phonebook.ex06;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager=PhoneBookManager.getInstance();
		
		while (true) { 
			String choice=MenuViewer.showMenu(); 
			
			switch (choice) {
			
			case "1": //데이터 입력
				manager.read();
				break;
			case "2": //검색
				String SearchName=MenuViewer.getSearchName();
				manager.search(SearchName);
				break;
				1
			case "3": //수정
				PhoneInfo Info=MenuViewer.getModifyName();
				manager.modify(Info);
				break;
				
			case "4": //삭제
				String DeleteName=MenuViewer.getDeleatName();
				manager.delete(DeleteName);
				break;
				
			case "5": //종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				
			case "98": //테스트
				manager.test();
				break;
		
			case "99": //확인
				manager.show();
				break;
			}
			
		}
		
	} //main	
	
} //class

