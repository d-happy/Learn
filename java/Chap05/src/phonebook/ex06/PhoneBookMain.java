package phonebook.ex06;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		PhoneBookManager manager=PhoneBookManager.getInstance();
		
		while (true) { 
			String choice=MenuViewer.showMenu(); 
			
			switch (choice) {
			
			case "1": //������ �Է�
				manager.read();
				break;
			case "2": //�˻�
				String SearchName=MenuViewer.getSearchName();
				manager.search(SearchName);
				break;
				1
			case "3": //����
				PhoneInfo Info=MenuViewer.getModifyName();
				manager.modify(Info);
				break;
				
			case "4": //����
				String DeleteName=MenuViewer.getDeleatName();
				manager.delete(DeleteName);
				break;
				
			case "5": //����
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				
			case "98": //�׽�Ʈ
				manager.test();
				break;
		
			case "99": //Ȯ��
				manager.show();
				break;
			}
			
		}
		
	} //main	
	
} //class

