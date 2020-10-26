package ex01;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputStreamReadEx {

	public static void main(String[] args) throws Exception {
		// G:\\workspace\\java\\test2.txt
		FileInputStream fis = new FileInputStream("G:\\workspace\\java\\test2.txt"); //읽고
		InputStreamReader isr = new InputStreamReader(fis, "MS949"); //읽은 데이터 "MS949"식으로 변환
		
		while (true) {
			int i = isr.read(); //변환된 데이터 읽고
			if (i==-1) {
				break;
			}
			System.out.print((char)i); //글자로 바꿔서 출력
		}
		
		System.out.println("읽기 완료");
		isr.close();

	}//main

}//class
