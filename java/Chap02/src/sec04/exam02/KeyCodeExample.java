package sec04.exam02;

public class KeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.print("입력> ");
		// System.in - 입력 스트림-키보드
		int keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
		keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
		keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
	}
}
