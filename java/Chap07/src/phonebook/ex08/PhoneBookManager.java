package phonebook.ex08;

import java.util.*; //util ���� �� 

public class PhoneBookManager {

	private static PhoneBookManager instance;
	
	private PhoneBookManager() { /* singleton */ }
	
	public static PhoneBookManager getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}
	
	HashMap<String, PhoneInfo> phoneBookMap=new HashMap<>();
//	phoneBookMap.put(pInfo.getName(), pInfo);
	
	// ����, ����, ����ϱ� - Create
	public void readData() {
		
		System.out.println("�Է¸޴�> 1.����    2.��ȸ");
		System.out.print("����> ");
		String inputChoice = MenuViewer.scanner.nextLine();
		
		System.out.print("�̸�> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("����> ");
		String phone = MenuViewer.scanner.nextLine();
		PhoneInfo info = null;
		switch (inputChoice) {
		// ����, �г�
		case "1":
			System.out.print("����> ");
			String major = MenuViewer.scanner.nextLine();
			System.out.print("�г�> ");
			String grade = MenuViewer.scanner.nextLine();
			info = new UnivPhoneInfo(name, phone, major, Integer.parseInt(grade) );
			break;
		// ȸ���
		case "2":
			System.out.print("ȸ���> ");
			String companyName = MenuViewer.scanner.nextLine();
			info = new CompanyPhoneInfo(name, phone, companyName);
			break;
		}
		save(info); 
	}
	
	// ����
	private void save(PhoneInfo pInfo) {
//		HashMap<String, PhoneInfo> phoneBookMap=new HashMap<>();
		phoneBookMap.put(pInfo.getName(), pInfo);
	}
	
	// �˻��ؼ� �˷��ֱ�, �б� - Read
	public void search(String name) {
		
		System.out.println("�˻��� �����մϴ�.");
		
		if (phoneBookMap.get(name)==null) {
			System.out.println(name + "���� ����� ������ �����ϴ�.");
		}
		
		PhoneInfo info = phoneBookMap.get(name);
		System.out.println(info);
		
		/*System.out.println("�˻��� �����մϴ�.");
		PhoneInfo info = phoneBook.get(name);
		if (info == null) {
			System.out.println(name + "���� ����� ������ �����ϴ�.");
		} else {
			info.showPhoneInfo();
		}*/
	}
	
	// �����ϱ� - Update
	public void modify(PhoneInfo info) { // �̸�, ����
		
		Set<String> keys=phoneBookMap.keySet();
		
		for (String key : keys) {
			if (key.equals(info.getName())) {
				PhoneInfo pinfo=phoneBookMap.get(key);
				pinfo.setPhone(info.getPhone());
				if (pinfo instanceof UnivPhoneInfo) {
					System.out.print("������ ����> ");
					String major = MenuViewer.scanner.nextLine();
					System.out.print("������ �г�> ");
					String grade = MenuViewer.scanner.nextLine();
					UnivPhoneInfo uInfo = (UnivPhoneInfo)pinfo;
					uInfo.setMajor(major);
					uInfo.setGrade(Integer.parseInt(grade));
				} else if (pinfo instanceof CompanyPhoneInfo) {
					System.out.print("������ ȸ���> ");
					String companyName = MenuViewer.scanner.nextLine();
					CompanyPhoneInfo cInfo = (CompanyPhoneInfo)pinfo;
					cInfo.setCompanyName(companyName);
				}
				System.out.println(info.getName()+"�����Ͱ� �����Ǿ����ϴ�.");
			}//if - ã��
		}
		System.out.println(info.getName() + "���� ����� ������ �����ϴ�.");
	}
	
	// �����ϱ� - Delete
	public void remove(String name) { 
		
		Set<String> ketSet=phoneBookMap.keySet();
		for (String key : ketSet) {
			if (name.equals(key)) {
				phoneBookMap.remove(name);
				System.out.println(name + "��(��) ���� �Ǿ����ϴ�.");
				return;
			}
		}
	}
	
	//�׽�Ʈ �����
	public void insertTestData() {
		for (int i = 1; i <= 5; i++) {
			PhoneInfo info = null;
			if (i % 2 == 0) {
				info = new UnivPhoneInfo("���" + i, "����" + i, "����" + i, i);
			} else {
				info = new CompanyPhoneInfo("�ٳ���" + i, "����" + i, "����" + i);
			}
		save(info);
		}
	}
	
	// ��ȭ��ȣ�� ��ü ���� - �׽�Ʈ��
	public void showAll() { 
		Set<String> keySet=phoneBookMap.keySet(); //�ʿ��� Ű��(����)�� �������·� ��, HashSet�� ���� Ÿ��
		for (String key : keySet) {
			PhoneInfo info=phoneBookMap.get(key);
			System.out.println(info);
		}
	}

	

} //class
