package phonebook.ex06;

public class PhoneBookManager {

	private PhoneBookManager() {
	}
	private static PhoneBookManager instance;
	public static PhoneBookManager getInstance() {
		if (instance==null) {
			instance=new PhoneBookManager();
		}
		return instance;
	}
	
	private PhoneInfo[] phoneBook=new PhoneInfo[2];
	private int index=0;

	//�Է�
	public void read() {
		System.out.print("�̸�> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("��ȭ��ȣ> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String birth=MenuViewer.scanner.nextLine();
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		save(pInfo);
	}
	
	//�迭�� ����
	public void save(PhoneInfo pInfo) {
		if (index>=phoneBook.length) {
		 update();
		}
		phoneBook[index]=pInfo;
//		System.out.print("�����Ͱ� ����Ǿ����ϴ�.");
		index++;
	}

	//������Ʈ
	public void update() {
		PhoneInfo[] newBook=new PhoneInfo[phoneBook.length*2];
		for (int i=0; i<phoneBook.length; i++) {
			newBook[i]=phoneBook[i];
		}
		phoneBook=newBook;
	}
		
	//�˻�
	public void search(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
		System.out.println(name+"���� ����� �����Ͱ� �����ϴ�.");
	}
	
	//����
	public void modify(PhoneInfo Info) {
		for (int i=0; i<index; i++) {
			if (Info.getName().equals(phoneBook[i].getName())) {
				phoneBook[i].setPhone(Info.getPhone());
				phoneBook[i].setBirth(Info.getBirth());
				System.out.println("������ �������Դϴ�.");
				phoneBook[i].showPhoneInfo();
				return;
			}		
		}
	}
	
	//����
	public void delete(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				for (int j=i; j<index; j++) {
					phoneBook[j]=phoneBook[j+1];
				}
				phoneBook[index-1]=null;
				index--;
				System.out.println("�����Ͱ� �����Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("������ �����Ͱ� �����ϴ�.");
	}
	
	//Ȯ��
	public void show() {
		for (int i=0; i<phoneBook.length; i++) {
			if (phoneBook[i]==null) {
				return;
			}
			System.out.println(phoneBook[i]);
		}
	}
	
	//�׽�Ʈ
	public void test() {
		for (int i=0; i<5; i++) {
			PhoneInfo pInfo=new PhoneInfo("�ٳ���"+i, "����"+i, "����"+i);
			save(pInfo);		
		}
	}



} //class
