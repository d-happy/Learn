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

	//입력
	public void read() {
		System.out.print("이름> ");
		String name=MenuViewer.scanner.nextLine();
		System.out.print("전화번호> ");
		String phone=MenuViewer.scanner.nextLine();
		System.out.print("생일> ");
		String birth=MenuViewer.scanner.nextLine();
		
		PhoneInfo pInfo=new PhoneInfo(name, phone, birth);
		save(pInfo);
	}
	
	//배열에 저장
	public void save(PhoneInfo pInfo) {
		if (index>=phoneBook.length) {
		 update();
		}
		phoneBook[index]=pInfo;
//		System.out.print("데이터가 저장되었습니다.");
		index++;
	}

	//업데이트
	public void update() {
		PhoneInfo[] newBook=new PhoneInfo[phoneBook.length*2];
		for (int i=0; i<phoneBook.length; i++) {
			newBook[i]=phoneBook[i];
		}
		phoneBook=newBook;
	}
		
	//검색
	public void search(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				phoneBook[i].showPhoneInfo();
				return;
			}
		}
		System.out.println(name+"으로 저장된 데이터가 없습니다.");
	}
	
	//수정
	public void modify(PhoneInfo Info) {
		for (int i=0; i<index; i++) {
			if (Info.getName().equals(phoneBook[i].getName())) {
				phoneBook[i].setPhone(Info.getPhone());
				phoneBook[i].setBirth(Info.getBirth());
				System.out.println("수정된 데이터입니다.");
				phoneBook[i].showPhoneInfo();
				return;
			}		
		}
	}
	
	//삭제
	public void delete(String name) {
		for (int i=0; i<index; i++) {
			if (name.equals(phoneBook[i].getName())) {
				for (int j=i; j<index; j++) {
					phoneBook[j]=phoneBook[j+1];
				}
				phoneBook[index-1]=null;
				index--;
				System.out.println("데이터가 삭제되었습니다.");
				return;
			}
		}
		System.out.println("삭제할 데이터가 없습니다.");
	}
	
	//확인
	public void show() {
		for (int i=0; i<phoneBook.length; i++) {
			if (phoneBook[i]==null) {
				return;
			}
			System.out.println(phoneBook[i]);
		}
	}
	
	//테스트
	public void test() {
		for (int i=0; i<5; i++) {
			PhoneInfo pInfo=new PhoneInfo("바나나"+i, "전번"+i, "생일"+i);
			save(pInfo);		
		}
	}



} //class
