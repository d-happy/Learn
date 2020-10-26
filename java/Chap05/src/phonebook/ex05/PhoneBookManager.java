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
	
	//저장, 쓰기, 기록 - Create
	public void readData() {
		
		System.out.print("이름> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전번> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("생일> ");
		String birth=MenuViewer.scanner.nextLine();

		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		save(pInfo);
	}
	
	private void save(PhoneInfo pInfo) {
		if (index>=phoneBook.length) {
			//새로운 전화번호부를 만들어서 사용
			updatePhoneBook();
		}
		phoneBook[index]=pInfo;
		System.out.println(pInfo.getName()+"정보가 입력되었습니다.");
		index++; //저장된 숫자=index
	}
	
	private void updatePhoneBook() {
		//2배 크기의 새로운 배열 생성
		PhoneInfo[] newPhoneBook=new PhoneInfo[phoneBook.length*2];
		//기존 배열의 데이터를 새로운 배열에 옮기기
		for (int i=0; i<phoneBook.length; i++) {
			newPhoneBook[i]=phoneBook[i];
		}
		//사용하던 변수에 새로운 배열 할당
		phoneBook=newPhoneBook;
	}
	
	//전화번호부 전체 정보
	public void showAll() {
		for (int i=0; i<phoneBook.length; i++) {
			if (phoneBook[i]==null) {
				return;
			}
			System.out.println(phoneBook[i]);
		}
	}

	//검색해서 알려주기, 읽기 - Read
	public void search(String name) {
		System.out.println("검색할 이름> ");
		for (int i=0; i<index; i++) { //index=저장된 데이터 숫자
			if (name.equals(phoneBook[i].getName())) {
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
		System.out.println(name+"으로 저장된 정보가 없습니다.");
	}
	
	//수정 - Update
	public void modify(PhoneInfo info) {
		System.out.println("검색을 시작합니다.");
		for (int i=0; i<index; i++) {
			if (info.getName().equals(phoneBook[i].getName())) {
				phoneBook[i].setPhone(info.getPhone());
				phoneBook[i].setBirth(info.getBirth());
				System.out.println("수정된 데이터입니다.");
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
	}
	
	//삭제 - Delete
	public void remove(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				//phoneBook[i]=null;
				for (int j=i; i<index-1; j++) {
					phoneBook[j]=phoneBook[j+1];
				}
				phoneBook[index-1]=null;
				index--;
				System.out.println(name+"이(가) 삭제되었습니다.");
				return;
			}
		}
		System.out.println(name+"으로 저장된 정보가 없습니다.");
	}
	
	//테스트
	public void insertTestData() {
		for (int i=0; i<5; i++) {
			PhoneInfo info=new PhoneInfo("신귀환"+i, "전번"+i, "생일"+i);
			save(info);
		}
	}
	
} //class
