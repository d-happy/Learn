package sec04.exam03;

public class ContinueKeyCodeExample {

	public static void main(String[] args) throws Exception {
		//���ѹݺ�
		while (true) {
			System.out.print("�Է�> ");
			int keyCode=System.in.read();
			System.out.println("keyCode: "+keyCode);
		}
	}
}