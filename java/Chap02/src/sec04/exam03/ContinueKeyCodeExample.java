package sec04.exam03;

public class ContinueKeyCodeExample {

	public static void main(String[] args) throws Exception {
		//무한반복
		while (true) {
			System.out.print("입력> ");
			int keyCode=System.in.read();
			System.out.println("keyCode: "+keyCode);
		}
	}
}