package phonebook.ex09;

public class PhoneBookMain {
	
public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {
			String choice = MenuViewer.showMenu();
			
			switch (choice) {
			case IMenu.INPUT : // �Է�
				manager.readData();
				break;
			case IMenu.SEARCH : // �˻�
				String searchName = MenuViewer.getSearchName();
				manager.search(searchName);
				break;
			case IMenu.MODIFY : // ����
				PhoneInfo info = MenuViewer.inputUpdateData(); // �̸�, ����
				manager.modify(info);
				break;
			case IMenu.REMOVE : // ����
				String deleteName = MenuViewer.getDeleteName();
				manager.remove(deleteName);
				break;
			case IMenu.EXIT :
				System.out.println("���α׷� ����");
				MenuViewer.scanner.close();
				System.exit(0);
				break;
			case "98":
				manager.insertTestData();
				break;
			case "99":
				// ������ ��ü Ȯ��
				manager.showAll();
				break;
				
			} // switch
		}
	} // main
	
	
	
} //class

