package singleton.ex01;

public class Screen {
	
	private static Screen instance;
	public int a;
	
	private Screen() {}
	
	public static  Screen getInstance() {
		if (instance==null) {
			instance=new Screen();
		}
		return instance;
	}
	
} //class
