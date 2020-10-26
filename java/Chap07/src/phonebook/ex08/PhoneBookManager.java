package phonebook.ex08;

import java.util.*; //util 전부 다 

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
	
	// 저장, 쓰기, 기록하기 - Create
	public void readData() {
		
		System.out.println("입력메뉴> 1.대학    2.사회");
		System.out.print("선택> ");
		String inputChoice = MenuViewer.scanner.nextLine();
		
		System.out.print("이름> ");
		String name = MenuViewer.scanner.nextLine();
		System.out.print("전번> ");
		String phone = MenuViewer.scanner.nextLine();
		PhoneInfo info = null;
		switch (inputChoice) {
		// 전공, 학년
		case "1":
			System.out.print("전공> ");
			String major = MenuViewer.scanner.nextLine();
			System.out.print("학년> ");
			String grade = MenuViewer.scanner.nextLine();
			info = new UnivPhoneInfo(name, phone, major, Integer.parseInt(grade) );
			break;
		// 회사명
		case "2":
			System.out.print("회사명> ");
			String companyName = MenuViewer.scanner.nextLine();
			info = new CompanyPhoneInfo(name, phone, companyName);
			break;
		}
		save(info); 
	}
	
	// 저장
	private void save(PhoneInfo pInfo) {
//		HashMap<String, PhoneInfo> phoneBookMap=new HashMap<>();
		phoneBookMap.put(pInfo.getName(), pInfo);
	}
	
	// 검색해서 알려주기, 읽기 - Read
	public void search(String name) {
		
		System.out.println("검색을 시작합니다.");
		
		if (phoneBookMap.get(name)==null) {
			System.out.println(name + "으로 저장된 정보가 없습니다.");
		}
		
		PhoneInfo info = phoneBookMap.get(name);
		System.out.println(info);
		
		/*System.out.println("검색을 시작합니다.");
		PhoneInfo info = phoneBook.get(name);
		if (info == null) {
			System.out.println(name + "으로 저장된 정보가 없습니다.");
		} else {
			info.showPhoneInfo();
		}*/
	}
	
	// 수정하기 - Update
	public void modify(PhoneInfo info) { // 이름, 전번
		
		Set<String> keys=phoneBookMap.keySet();
		
		for (String key : keys) {
			if (key.equals(info.getName())) {
				PhoneInfo pinfo=phoneBookMap.get(key);
				pinfo.setPhone(info.getPhone());
				if (pinfo instanceof UnivPhoneInfo) {
					System.out.print("수정할 전공> ");
					String major = MenuViewer.scanner.nextLine();
					System.out.print("수정할 학년> ");
					String grade = MenuViewer.scanner.nextLine();
					UnivPhoneInfo uInfo = (UnivPhoneInfo)pinfo;
					uInfo.setMajor(major);
					uInfo.setGrade(Integer.parseInt(grade));
				} else if (pinfo instanceof CompanyPhoneInfo) {
					System.out.print("수정할 회사명> ");
					String companyName = MenuViewer.scanner.nextLine();
					CompanyPhoneInfo cInfo = (CompanyPhoneInfo)pinfo;
					cInfo.setCompanyName(companyName);
				}
				System.out.println(info.getName()+"데이터가 수정되었습니다.");
			}//if - 찾기
		}
		System.out.println(info.getName() + "으로 저장된 정보가 없습니다.");
	}
	
	// 삭제하기 - Delete
	public void remove(String name) { 
		
		Set<String> ketSet=phoneBookMap.keySet();
		for (String key : ketSet) {
			if (name.equals(key)) {
				phoneBookMap.remove(name);
				System.out.println(name + "이(가) 삭제 되었습니다.");
				return;
			}
		}
	}
	
	//테스트 만들기
	public void insertTestData() {
		for (int i = 1; i <= 5; i++) {
			PhoneInfo info = null;
			if (i % 2 == 0) {
				info = new UnivPhoneInfo("사과" + i, "전번" + i, "전공" + i, i);
			} else {
				info = new CompanyPhoneInfo("바나나" + i, "전번" + i, "애플" + i);
			}
		save(info);
		}
	}
	
	// 전화번호부 전체 정보 - 테스트용
	public void showAll() { 
		Set<String> keySet=phoneBookMap.keySet(); //맵에서 키툴(집합)만 집합형태로 얻어돔, HashSet의 상위 타입
		for (String key : keySet) {
			PhoneInfo info=phoneBookMap.get(key);
			System.out.println(info);
		}
	}

	

} //class
