package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {
	public static void main(String[] args) throws Exception {
		//��¿� ���� �ȱ� //txt ���� ������
		FileOutputStream fos=new FileOutputStream("G:\\workspace\\java\\test.txt");
		
		//������ ���
		for (int i=0; i<10; i++) {
			fos.write(i);
		}
		
		//���� ����
		fos.close();
					
		//�Է¿� ���� �ȱ�
		FileInputStream fis=new FileInputStream("G:\\workspace\\java\\test.txt");
		while (true) {
			int i=fis.read();
			if (i==-1) {
				break;
			}
			System.out.print(i);
		}
		fis.close();
		
	}

}//class
