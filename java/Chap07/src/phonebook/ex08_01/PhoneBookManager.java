package phonebook.ex08_01;

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
	
	HashMap<String, PhoneInfo> phoneBook=new HashMap<>();
//	phoneBook.put(info.getName(), info);
	
	//����, ����, ����ϱ� - Create
	public void readData() {
		
		System.out.println("1.���� 2.��ȸ");
		System.out.print("����> ");
		String choice2=MenuViewer.scanner.nextLine();
	
		if (choice2.equals("1")) {
			System.out.print("�̸�> ");
			String name=MenuViewer.scanner.nextLine();
			System.out.print("��ȭ��ȣ> ");
			String phone=MenuViewer.scanner.nextLine();
			System.out.print("����> ");
			String major=MenuViewer.scanner.nextLine();
			System.out.print("�г�> ");
			int grade=Integer.parseInt(MenuViewer.scanner.nextLine());
			
			PhoneInfo info=new UnivPhoneInfo(name, phone, major, grade);
			save(info);
			System.out.println(name+"(��)�� ����Ǿ����ϴ�.");
		
		} else if (choice2.equals("2")) {
			System.out.print("�̸�> ");
			String name=MenuViewer.scanner.nextLine();
			System.out.print("��ȭ��ȣ> ");
			String phone=MenuViewer.scanner.nextLine();
			System.out.print("ȸ���> ");
			String companyName=MenuViewer.scanner.nextLine();
			
			PhoneInfo info=new CompanyPhoneInfo(name, phone, companyName);
			save(info);
			System.out.println(name+"(��)�� ����Ǿ����ϴ�.");
		}
	}
	
	//����
	private void save(PhoneInfo info) {
		phoneBook.put(info.getName(), info);
	}
	
	//�˻��ؼ� �˷��ֱ�, �б� - Read
	public void search(String name) {
		Set<String> keys=phoneBook.keySet(); //�ʿ��� Ű��(����)�� �������·� ��, HashSet�� ���� Ÿ��
		for (String key : keys) {
			if (name.equals(key)) {
				PhoneInfo info=phoneBook.get(key);
//				System.out.println(phoneBook); //���� �� ������
				System.out.println(info);
				return;
			}
		}
		System.out.println("����� �����Ͱ� �����ϴ�.");
	}
	
	//�����ϱ� - Update
	public void modify(PhoneInfo info) { //�̸�, ����
		Set<String> keyMo=phoneBook.keySet();
		
		for (String key : keyMo) {
			if (info.getName().equals(key)) {
				info=phoneBook.get(key); //info phoneBook.get(key);�� ������ �ϰ�
				info.setPhone(info.getPhone()); 
				//�޾ƿ� phone���� ����, �Ʒ� if���� �غ��� ��?? ���� �� ��
				
				if (info instanceof UnivPhoneInfo) { 
					//PhoneInfo info��	UnivPhoneInfo	�����̶�� 
					
					System.out.print("����> ");
					String major=MenuViewer.scanner.nextLine();
					System.out.print("�г�> ");
					int grade=Integer.parseInt(MenuViewer.scanner.nextLine());
					
					UnivPhoneInfo infoUniv=(UnivPhoneInfo)info; 
					//info : PhoneInfo -����-> UnivPhoneInfo, ������ ���� //DownCasting
					
					infoUniv.setMajor(major);
					infoUniv.setGrade(grade);
					
					System.out.println(info.getName()+"(��)�� �����Ǿ����ϴ�.");
					return;
					
					} else if (info instanceof CompanyPhoneInfo) {
						System.out.print("ȸ���> ");
						String companyName=MenuViewer.scanner.nextLine();
						
						CompanyPhoneInfo infoCom=(CompanyPhoneInfo)info;
						infoCom.setCompanyName(companyName);
						
						System.out.println(info.getName()+"(��)�� �����Ǿ����ϴ�.");
						return;
					}
				/*System.out.println(info.getName()+"(��)�� �����Ǿ����ϴ�.");
				return;*/
			}
		}
		System.out.println("����� �����Ͱ� �����ϴ�.");
	}
	
	//�����ϱ� - Delete
	public void remove(String name) { 
		Set<String> keyDel=phoneBook.keySet();
		for (String key : keyDel) {
			if (name.equals(key)) {
				phoneBook.remove(key);
				System.out.println(name+"(��)�� �����Ǿ����ϴ�.");
				return;
			}
		}
		System.out.println("����� �����Ͱ� �����ϴ�.");
	}
	
	//�׽�Ʈ �����
	public void insertTestData() {
		PhoneInfo info=null;
		for (int i=0; i<5; i++) {
			if (i%2==0) {
				info=new UnivPhoneInfo("����"+i, "����"+i, "����"+i, i);
				} else if (i%2!=0) {
					info=new CompanyPhoneInfo("Ű��"+i, "����"+i, "����"+i);
				}
			save(info);
		}
		System.out.println("�׽�Ʈ ����");
	}
	
	//��ȭ��ȣ�� ��ü ����
	public void showAll() {
		Set<String> keySet=phoneBook.keySet();
		for (String key : keySet) {
			PhoneInfo info=phoneBook.get(key);
			System.out.println(info);
		}
	}

	

} //class
