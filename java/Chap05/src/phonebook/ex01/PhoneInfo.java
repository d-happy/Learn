package phonebook.ex01;

public class PhoneInfo {
	String name;
	String phone;
	String birth;
	
	PhoneInfo (String name, String phone) { //public 없어도 실행 가능
		this.name=name;
		this.phone=phone;
	}
	public PhoneInfo (String name, String phone, String birth) {
		this.name=name; //PhoneInfo 클래스의 name, ... 필드에 <pInfo?=new PhoneInfo>의 매개변수 값을 넣고 후에 사용
		this.phone=phone;
		this.birth=birth;
	}
	void showPhoneInfo () {
		if (birth!=null) {
			System.out.printf("name: %s\n", name);
			System.out.printf("phone: %s\n", phone);
			System.out.printf("birth: %s\n", birth);
			System.out.println();
		} else if (birth==null) {
			System.out.printf("name: %s\n", name);
			System.out.printf("phone: %s\n", this.phone); 
			//this. 있어도 없어도 가능 어차피 이 클래스 안에서
			//위에서 <pInfo?=new PhoneInfo> 매개변수 따라서 오버로딩 해서 객체의 매개변수 저장됨
			//그 저장된 값들을 모아서 필드 name, ... 라고 부르고 사용함
			System.out.println();
		}
		/*
		System.out.println("name: "+name);
		System.out.println("phone: "+phone);
		if (birth!=null) {
			System.out.println("birth: "+birth);
		}
		System.out.println();
		*/
	}
}
