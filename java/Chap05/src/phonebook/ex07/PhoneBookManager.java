package phonebook.ex07;

public class PhoneBookManager {

	private static PhoneBookManager instance;
	private PhoneBookManager () { /* singleton*/ }
	public static PhoneBookManager getInstance () {
		if (instance==null) {
			instance=new PhoneBookManager();
		}
		return instance;
	}
	
	private PhoneInfo[] PhoneBook=new PhoneInfo[2];
	private int index=0;
	
	public void read () {} 
	public void save () {} 
	public void update () {} 
	public void search () {} 
	public void modify () {} 
	public void delete () {} 
	
	public void test () {} 
	public void show () {} 


} //class
