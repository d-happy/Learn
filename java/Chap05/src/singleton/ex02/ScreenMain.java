package singleton.ex02;

public class ScreenMain {

	public static void main(String[] args) {
		Screen sc1=Screen.getInstance();
		Screen sc2=Screen.getInstance();
		System.out.println("sc1: "+sc1);
		System.out.println("sc2: "+sc2);
	}

} //class
