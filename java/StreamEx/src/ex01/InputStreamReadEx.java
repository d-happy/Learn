package ex01;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReadEx {

	public static void main(String[] args) throws Exception {
		// G:\\workspace\\java\\test2.txt
		FileInputStream fis = new FileInputStream("G:\\workspace\\java\\test2.txt"); //�а�
		InputStreamReader isr = new InputStreamReader(fis, "MS949"); //���� ������ "MS949"������ ��ȯ
		
		while (true) {
			int i = isr.read(); //��ȯ�� ������ �а�
			if (i==-1) {
				break;
			}
			System.out.print((char)i); //���ڷ� �ٲ㼭 ���
		}
		
		System.out.println("�б� �Ϸ�");
		isr.close();

	}//main

}//class
