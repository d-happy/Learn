package phonebook.ex08;

public class CompanyPhoneInfo extends PhoneInfo {
	private String companyName;

	public CompanyPhoneInfo(String name, String phone, String companyName) {
		super(name, phone);
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("companyName: " + companyName);
	}

	@Override
	public String toString() {
		return "CompanyPhoneInfo [ name=" + name + ", phone=" + phone + ", companyName=" + companyName + "]";
	}

}//class