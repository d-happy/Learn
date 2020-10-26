package phonebook.ex01;

public class PhoneBookMain {

	public static void main(String[] args) {
		PhoneInfo pInfo1 = new PhoneInfo("Ω≈±Õ»Ø", "010-1111-1111", "89.09.12");
		PhoneInfo pInfo2 = new PhoneInfo("±Ë∫¿±‘", "010-2222-2222");
		pInfo1.showPhoneInfo();
		pInfo2.showPhoneInfo();
	}
}
