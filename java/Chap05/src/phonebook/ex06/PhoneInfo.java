package phonebook.ex06;

public class PhoneInfo {
	private String name;
	private String phone;
	private String birth;
	
	public PhoneInfo () {
	}
	public PhoneInfo (String name, String phone) {
		this.name=name;
		this.phone=phone;
	}
	public PhoneInfo (String name, String phone, String birth) {
		this.name=name;
		this.phone=phone;
		this.birth=birth;
	}
	public void setName (String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setPhone (String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setBirth (String birth) {
		this.birth=birth;
	}
	public String getBirth() {
		return birth;
	}
	
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}
	
	public void showPhoneInfo () {
		System.out.printf("name: %s\n", name);
		System.out.printf("phone: %s\n", phone);
		if (birth!=null) {
			System.out.printf("birth: %s\n", birth);
		}
		System.out.println();
	}
	
} //class
