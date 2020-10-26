package ex01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BinaryCopy {

	public static void main(String[] args) throws Exception { //Exception 오류 처리 미룬다?!
		
		// throws IOException 즉 익셉션(예외)가 발생하면 해당 클래스에서 벗어나게 된다는 것입니다. 
		//모든 특이사항은 던져(throw)버린다는 말로 
		//만일 그 부분을 감싸는 try ~ catch 문이 있다면 튕겨져나온 예외를 핸들링할 수도 있습니다.
		
		//시작 시간
		long startTime = System.currentTimeMillis(); //밀리세컨드(1/1000) 단위로 현재 시간을 구함
		File src = new File("G:\\workspace\\java\\jdk.exe");
		File dst = new File("G:\\workspace\\java\\jdk_copy.exe");
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dst);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		//원본, 복사 -> 빨대 읽고 쓰기 -> 버퍼로 데이터 모아서 속도 빠르게 실행 
		
		while (true) {
			int readData = bis.read();
			if (readData == -1) {
				break;
			}
			bos.write(readData); //원본이 있다면 복사한다
		}
		
		bis.close();
		bos.close(); //버퍼 다 종료
		
		System.out.println("파일 복사 완료"); //위에서 아래로 모든 코드 실행 뒤에 출력, 실행 여부 확인 가능
		//끝나는 시간
		long endTime = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(endTime-startTime)); //복사하는데 걸린 시간 출력 
		

	}//main

}//class
