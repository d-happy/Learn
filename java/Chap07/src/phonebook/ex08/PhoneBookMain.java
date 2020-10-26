package phonebook.ex08;

public class PhoneBookMain {
	
public static void main(String[] args) {
		
		PhoneBookManager manager = PhoneBookManager.getInstance();
		
		while (true) {
			String choice = MenuViewer.showMenu();
			
			switch (choice) {
			case "1": // �Է�
				manager.readData();
				break;
			case "2": // �˻�
				String searchName = MenuViewer.getSearchName();
				manager.search(searchName);
				break;
			case "3": // ����
				PhoneInfo info = MenuViewer.inputUpdateData(); // �̸�, ����
				manager.modify(info);
				break;
			case "4": // ����
				String deleteName = MenuViewer.getDeleteName();
				manager.remove(deleteName);
				break;
			case "5":
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

