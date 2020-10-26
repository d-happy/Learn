package singleton.ex02;

public class Screen {
	
	private static Screen instance;
	
	private Screen() {
	}
	
	public static Screen getInstance() {
		if (instance==null) {
			instance=new Screen();
		}
		return instance;
	}
	
} //class
