package sec04.exam04;

import java.io.IOException;

public class QStopExanple {

	public static void main(String[] args) throws IOException {
		while (true) {
			int keyCode=System.in.read();
			System.out.println("keyCode: "+keyCode);
			//�Էµ� ���ڰ� 'q'�̸� �ݺ� �ߴ�
			if (keyCode==113) {
				break;
			}
		}
		System.out.println("����");
	}
}
