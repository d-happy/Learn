package sec04.exam02;

public class KeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.print("�Է�> ");
		// System.in - �Է� ��Ʈ��-Ű����
		int keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
		keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
		keyCode=System.in.read();
		System.out.println("keyCode: "+keyCode);
	}
}
