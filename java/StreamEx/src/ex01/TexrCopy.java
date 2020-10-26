package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TexrCopy {
	public static void main(String[] args) throws FileNotFoundException {
		//본문
		File src = new File("G:\\workspace\\java\\test3.txt");
		//복사본
		File dst = new File("G:\\workspace\\java\\test3_copy.text");
		
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null; 
		//원본, 카피 '파일'로 만들고 -> 읽는+쓰는 빨대 생성 -> 읽고 쓴 데이터 모아서 보는 버퍼 생성
		
		//문자 - Reader, Writer
		try {
			fr = new FileReader(src);
			fw = new FileWriter(dst);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			
			while(true) {
				int readData = br.read(); //<원본-읽고-모은> 데이터를 readData 라고 변수 지정하고
				if (readData == -1) {     //read() : 1byte 읽기->읽은 값이 없으면 -1 
					break;
				}
				bw.write(readData); //-1(내용 없음)이 아니면 <복사-쓰고>를 모아서 쓴다
			} 
		} catch (FileNotFoundException e) { //e 라는 변수? 만들고
			System.out.println("파일을 찾을 수 없음");
			e.printStackTrace(); //e 라는 변수? 만들고 오류 추적, ... 가능
		} catch (IOException e) {
			System.out.println("파일 쓰기 오류");
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				System.out.println("파일 입출력 오류"); 
				//finally 위에 try, catch 뭐 하든간에 무조건
				//버퍼 다 종료하고 오류 생기면 문구 출력
			}
		}
		
		System.out.println("파일 복사 완료");
		
		
	}//main

}//class
