package phonebook.ex08_01;

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
	
	HashMap<String, PhoneInfo> phoneBook=new HashMap<>();
//	phoneBook.put(info.getName(), info);
	
	//저장, 쓰기, 기록하기 - Create
	public void readData() {
		
		System.out.println("1.대학 2.사회");
		System.out.print("선택> ");
		String choice2=MenuViewer.scanner.nextLine();
	
		if (choice2.equals("1")) {
			System.out.print("이름> ");
			String name=MenuViewer.scanner.nextLine();
			System.out.print("전화번호> ");
			String phone=MenuViewer.scanner.nextLine();
			System.out.print("전공> ");
			String major=MenuViewer.scanner.nextLine();
			System.out.print("학년> ");
			int grade=Integer.parseInt(MenuViewer.scanner.nextLine());
			
			PhoneInfo info=new UnivPhoneInfo(name, phone, major, grade);
			save(info);
			System.out.println(name+"(이)가 저장되었습니다.");
		
		} else if (choice2.equals("2")) {
			System.out.print("이름> ");
			String name=MenuViewer.scanner.nextLine();
			System.out.print("전화번호> ");
			String phone=MenuViewer.scanner.nextLine();
			System.out.print("회사명> ");
			String companyName=MenuViewer.scanner.nextLine();
			
			PhoneInfo info=new CompanyPhoneInfo(name, phone, companyName);
			save(info);
			System.out.println(name+"(이)가 저장되었습니다.");
		}
	}
	
	//저장
	private void save(PhoneInfo info) {
		phoneBook.put(info.getName(), info);
	}
	
	//검색해서 알려주기, 읽기 - Read
	public void search(String name) {
		Set<String> keys=phoneBook.keySet(); //맵에서 키툴(집합)만 집합형태로 얻어돔, HashSet의 상위 타입
		for (String key : keys) {
			if (name.equals(key)) {
				PhoneInfo info=phoneBook.get(key);
//				System.out.println(phoneBook); //전부 다 보여줌
				System.out.println(info);
				return;
			}
		}
		System.out.println("저장된 데이터가 없습니다.");
	}
	
	//수정하기 - Update
	public void modify(PhoneInfo info) { //이름, 전번
		Set<String> keyMo=phoneBook.keySet();
		
		for (String key : keyMo) {
			if (info.getName().equals(key)) {
				info=phoneBook.get(key); //info phoneBook.get(key);로 재정의 하고
				info.setPhone(info.getPhone()); 
				//받아온 phone으로 수정, 아래 if에서 해보니 왜?? 수정 안 됨
				
				if (info instanceof UnivPhoneInfo) { 
					//PhoneInfo info가	UnivPhoneInfo	성분이라면 
					
					System.out.print("전공> ");
					String major=MenuViewer.scanner.nextLine();
					System.out.print("학년> ");
					int grade=Integer.parseInt(MenuViewer.scanner.nextLine());
					
					UnivPhoneInfo infoUniv=(UnivPhoneInfo)info; 
					//info : PhoneInfo -변경-> UnivPhoneInfo, 변수명 새로 //DownCasting
					
					infoUniv.setMajor(major);
					infoUniv.setGrade(grade);
					
					System.out.println(info.getName()+"(이)가 수정되었습니다.");
					return;
					
					} else if (info instanceof CompanyPhoneInfo) {
						System.out.print("회사명> ");
						String companyName=MenuViewer.scanner.nextLine();
						
						CompanyPhoneInfo infoCom=(CompanyPhoneInfo)info;
						infoCom.setCompanyName(companyName);
						
						System.out.println(info.getName()+"(이)가 수정되었습니다.");
						return;
					}
				/*System.out.println(info.getName()+"(이)가 수정되었습니다.");
				return;*/
			}
		}
		System.out.println("저장된 데이터가 없습니다.");
	}
	
	//삭제하기 - Delete
	public void remove(String name) { 
		Set<String> keyDel=phoneBook.keySet();
		for (String key : keyDel) {
			if (name.equals(key)) {
				phoneBook.remove(key);
				System.out.println(name+"(이)가 삭제되었습니다.");
				return;
			}
		}
		System.out.println("저장된 데이터가 없습니다.");
	}
	
	//테스트 만들기
	public void insertTestData() {
		PhoneInfo info=null;
		for (int i=0; i<5; i++) {
			if (i%2==0) {
				info=new UnivPhoneInfo("포도"+i, "전번"+i, "과일"+i, i);
				} else if (i%2!=0) {
					info=new CompanyPhoneInfo("키위"+i, "전번"+i, "애플"+i);
				}
			save(info);
		}
		System.out.println("테스트 생성");
	}
	
	//전화번호부 전체 보기
	public void showAll() {
		Set<String> keySet=phoneBook.keySet();
		for (String key : keySet) {
			PhoneInfo info=phoneBook.get(key);
			System.out.println(info);
		}
	}

	

} //class
