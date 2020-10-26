package ex01;

import java.io.BufferedOutputStream;
import java.io.InputStreamReader;

public class BufferedStreamEx {
	public static void main(String[] args) throws Exception {
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
		
		while (true) {
			int i = in.read();
			if (i == -1) {
				break;
			}
			out.write(i);
		}
		
//		out.flush(); //버퍼에 남아있는 나머지 데이터 출력하기
		
		out.close();
		in.close();
	}

}//class
