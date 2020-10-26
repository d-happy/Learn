package sec04.exam04;

import java.io.IOException;

public class QStopExanple {

	public static void main(String[] args) throws IOException {
		while (true) {
			int keyCode=System.in.read();
			System.out.println("keyCode: "+keyCode);
			//입력된 문자가 'q'이면 반복 중단
			if (keyCode==113) {
				break;
			}
		}
		System.out.println("종료");
	}
}
