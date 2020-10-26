package phonebook.ex03;

public class PhoneBookMain {
	
	public static void main(String[] args) {
		
		while (true) { 
			
			String choice=MenuViewer.showMenu(); 
			//MenuViewer class�� �޴� ������ ���� �ϰ� return choice; �ؼ� ���� Ŭ���������� choice ��� ����
			
			switch (choice) {
			case "1" :
				readData();
				break;
			case "2" :
				System.out.println("���α׷� ����");
				MenuViewer.scanner.close();
				//�����ϱ� ���� MenuViewer class�� �ִ� scanner ���� (�ٸ� class�� System.exit(0);�� ���� �� ��ħ)
				System.exit(0);
				return; 
			}
		}
	}		
	
	public static void readData() {
		System.out.print("�̸�> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String birth=MenuViewer.scanner.nextLine();

		if (birth.equals("")) {
			birth=null;
		}
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		pInfo.showPhoneInfo();
		/*
		PhoneInfo[] arrInfo=new PhoneInfo[100];
		arrInfo[0]=pInfo;
		
		for (int i=0; i<100; i++ ) {
			arrInfo[i]=new PhoneInfo(name, phone, birth);
		}
		
		arrInfo[1].showPhoneInfo();
		*/
	}
} //class

