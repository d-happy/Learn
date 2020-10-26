package phonebook.ex02;

public class PhoneInfo {
	String name;
	String phone;
	String birth;
	
	PhoneInfo (String name, String phone) {
		this.name=name;
		this.phone=phone;
	}
	PhoneInfo (String name, String phone, String birth) {
		this.name=name;
		this.phone=phone;
		this.birth=birth;
	}
	void showPhoneInfo () {
		
		System.out.printf("name: %s\n", name);
		System.out.printf("phone: %s\n", phone);
		if (birth!=null) {
			System.out.printf("birth: %s\n", birth);
		}
		System.out.println();
		
		/*
		if (birth!=null) {
			System.out.printf("name: %s\n", name);
			System.out.printf("phone: %s\n", phone);
			System.out.printf("birth: %s\n", birth);
			System.out.println();
		} else if (birth==null) {
			System.out.printf("name: %s\n", name);
			System.out.printf("phone: %s\n", this.phone); 
			System.out.println();
		}
		*/
	}
} //class
