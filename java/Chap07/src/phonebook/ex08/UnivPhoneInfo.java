package phonebook.ex08;

public class UnivPhoneInfo extends PhoneInfo {
	private String major; // 전공
	private int grade; 	  // 학년
	
	public UnivPhoneInfo(String name, String phone, String major, int grade) {
		super(name, phone);
		this.major = major;
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo(); // 이름, 전번
		System.out.println("major: " + major);
		System.out.println("grade: " + grade);
	}

	@Override
	public String toString() {
		return "UnivPhoneInfo [name= " + name + ", phone=" + phone + ", major=" + major + ", grade=" + grade + "]";
	}

}
