package phonebook.ex01;

public class PhoneInfo {
	String name;
	String phone;
	String birth;
	
	PhoneInfo (String name, String phone) { //public ��� ���� ����
		this.name=name;
		this.phone=phone;
	}
	public PhoneInfo (String name, String phone, String birth) {
		this.name=name; //PhoneInfo Ŭ������ name, ... �ʵ忡 <pInfo?=new PhoneInfo>�� �Ű����� ���� �ְ� �Ŀ� ���
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
			//this. �־ ��� ���� ������ �� Ŭ���� �ȿ���
			//������ <pInfo?=new PhoneInfo> �Ű����� ���� �����ε� �ؼ� ��ü�� �Ű����� �����
			//�� ����� ������ ��Ƽ� �ʵ� name, ... ��� �θ��� �����
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
