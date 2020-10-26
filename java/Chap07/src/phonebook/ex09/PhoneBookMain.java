package phonebook.ex09;

public class PhoneBookMain {
	
public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {
			String choice = MenuViewer.showMenu();
			
			switch (choice) {
			case IMenu.INPUT : // 입력
				manager.readData();
				break;
			case IMenu.SEARCH : // 검색
				String searchName = MenuViewer.getSearchName();
				manager.search(searchName);
				break;
			case IMenu.MODIFY : // 수정
				PhoneInfo info = MenuViewer.inputUpdateData(); // 이름, 전번
				manager.modify(info);
				break;
			case IMenu.REMOVE : // 삭제
				String deleteName = MenuViewer.getDeleteName();
				manager.remove(deleteName);
				break;
			case IMenu.EXIT :
				System.out.println("프로그램 종료");
				MenuViewer.scanner.close();
				System.exit(0);
				break;
			case "98":
				manager.insertTestData();
				break;
			case "99":
				// 데이터 전체 확인
				manager.showAll();
				break;
				
			} // switch
		}
	} // main
	
	
	
} //class

