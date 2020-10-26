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
				
			case "3" : //����
				PhoneInfo info=MenuViewer.inputUpdateData();
				manager.modify(info);
				break;
				
			case "4" : //����
				String name=MenuViewer.scanner.nextLine();
				manager.remove(name);
				break;
				
			case "5" :
				System.out.println("���α׷� ����");
				MenuViewer.scanner.close();
				System.exit(0);
				return;
				
			case "98" :
				manager.insertTestData();
				break;
				
			case "99" :
				//������ ��ü Ȯ��
				manager.showAll();
				break;
			}
		}
		
	} //main	
	
} //class

