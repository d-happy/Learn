package phonebook.ex09;

public class PhoneInfo {
	protected String name;
	protected String phone;
	
	public PhoneInfo () {
	}
	public PhoneInfo (String name, String phone) {
		this.name=name;
		this.phone=phone;
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
	
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phone=" + phone + "]";
	}
	
	public void showPhoneInfo () {
		System.out.printf("name: %s\n", name);
		System.out.printf("phone: %s\n", phone);
		System.out.println();
	}
	
} //class
