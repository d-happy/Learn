package test;

public class UserDao {
	
	private UserDao instance;
	private UserDao() { /* singleton */ }
	public UserDao getInstance() {
		if (instance ==null) {
			instance = new UserDao();
		}
		return instance;
	}

}
