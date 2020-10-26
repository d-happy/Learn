package phonebook.ex05;

public class PhoneBookManager {
	
	private PhoneBookManager() {/*singleton*/}
	private static PhoneBookManager instance;

	public static PhoneBookManager getInstance() {
		if (instance==null) {
			instance=new PhoneBookManager();
		}
		return instance;
	}
	
	private PhoneInfo[] phoneBook=new PhoneInfo[2];
	private int index=0;
	
	//����, ����, ��� - Create
	public void readData() {
		
		System.out.print("�̸�> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String birth=MenuViewer.scanner.nextLine();

		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		save(pInfo);
	}
	
	private void save(PhoneInfo pInfo) {
		if (index>=phoneBook.length) {
			//���ο� ��ȭ��ȣ�θ� ���� ���
			updatePhoneBook();
		}
		phoneBook[index]=pInfo;
		System.out.println(pInfo.getName()+"������ �ԷµǾ����ϴ�.");
		index++; //����� ����=index
	}
	
	private void updatePhoneBook() {
		//2�� ũ���� ���ο� �迭 ����
		PhoneInfo[] newPhoneBook=new PhoneInfo[phoneBook.length*2];
		//���� �迭�� �����͸� ���ο� �迭�� �ű��
		for (int i=0; i<phoneBook.length; i++) {
			newPhoneBook[i]=phoneBook[i];
		}
		//����ϴ� ������ ���ο� �迭 �Ҵ�
		phoneBook=newPhoneBook;
	}
	
	//��ȭ��ȣ�� ��ü ����
	public void showAll() {
		for (int i=0; i<phoneBook.length; i++) {
			if (phoneBook[i]==null) {
				return;
			}
			System.out.println(phoneBook[i]);
		}
	}

	//�˻��ؼ� �˷��ֱ�, �б� - Read
	public void search(String name) {
		System.out.println("�˻��� �̸�> ");
		for (int i=0; i<index; i++) { //index=����� ������ ����
			if (name.equals(phoneBook[i].getName())) {
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
		System.out.println(name+"���� ����� ������ �����ϴ�.");
	}
	
	//���� - Update
	public void modify(PhoneInfo info) {
		System.out.println("�˻��� �����մϴ�.");
		for (int i=0; i<index; i++) {
			if (info.getName().equals(phoneBook[i].getName())) {
				phoneBook[i].setPhone(info.getPhone());
				phoneBook[i].setBirth(info.getBirth());
				System.out.println("������ �������Դϴ�.");
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
	}
	
	//���� - Delete
	public void remove(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				//phoneBook[i]=null;
				for (int j=i; i<index-1; j++) {
					phoneBook[j]=phoneBook[j+1];
				}
				phoneBook[index-1]=null;
				index--;
				System.out.println(name+"��(��) �����Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println(name+"���� ����� ������ �����ϴ�.");
	}
	
	//�׽�Ʈ
	public void insertTestData() {
		for (int i=0; i<5; i++) {
			PhoneInfo info=new PhoneInfo("�ű�ȯ"+i, "����"+i, "����"+i);
			save(info);
		}
	}
	
} //class
