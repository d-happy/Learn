package phonebook.ex07;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
//		"1.�������Է�   2.�˻�   3.����   4.����   5.���α׷� ����"
		
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
				System.out.println("���α׷� ����");
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

