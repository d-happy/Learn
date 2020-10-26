package ex01;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileWriterEx {

	public static void main(String[] args) throws Exception {
		//키보드로부터 한글자 입력받아서 쓰기
		InputStreamReader isr = new InputStreamReader(System.in);
		FileWriter fw = new FileWriter("G:\\workspace\\java\\test3.txt");
		System.out.print("입력> ");
		while (true) {
			int i=isr.read();
			if (i==-1) {
				break;
			}
			fw.write(i);
		}
		fw.close();
		isr.close();
		System.out.println("파일 쓰기 완료"); // Enter -> Ctrl+z

	}

}//class
