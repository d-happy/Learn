package ex01;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileWriterEx {

	public static void main(String[] args) throws Exception {
		//Ű����κ��� �ѱ��� �Է¹޾Ƽ� ����
		InputStreamReader isr = new InputStreamReader(System.in);
		FileWriter fw = new FileWriter("G:\\workspace\\java\\test3.txt");
		System.out.print("�Է�> ");
		while (true) {
			int i=isr.read();
			if (i==-1) {
				break;
			}
			fw.write(i);
		}
		fw.close();
		isr.close();
		System.out.println("���� ���� �Ϸ�"); // Enter -> Ctrl+z

	}

}//class
