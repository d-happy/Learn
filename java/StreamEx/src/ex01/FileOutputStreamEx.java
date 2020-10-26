package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {
	public static void main(String[] args) throws Exception {
		//출력용 빨대 꽂기 //txt 파일 생성됨
		FileOutputStream fos=new FileOutputStream("G:\\workspace\\java\\test.txt");
		
		//데이터 출력
		for (int i=0; i<10; i++) {
			fos.write(i);
		}
		
		//빨대 제거
		fos.close();
					
		//입력용 빨대 꽂기
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
