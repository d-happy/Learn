package phonebook.ex07;

public class PhoneInfo {
	private String name;
	private String phone;
	private String birth;
	
	public PhoneInfo () {}

	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public PhoneInfo(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", phone=" + phone + ", birth=" + birth + "]";
	}
	
	public void showInfo () {
		System.out.println("name: "+name);
		System.out.println("phone: "+phone);
		if (birth!=null) {
			System.out.println("birth: "+birth);
		}
		System.out.println();
	}
	
} //class
