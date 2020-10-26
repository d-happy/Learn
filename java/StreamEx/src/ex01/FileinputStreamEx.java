package ex01;

//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class FileinputStreamEx {

	public static void main(String[] args) throws Exception {
		//파일에 빨대 꽂기
		FileInputStream fis=
				new FileInputStream("G:\\workspace\\java\\Hello.java"); //주소 잘 적기!!!!!
		//데이터 읽고
		while (true) {
			int i = fis.read(); //1byte 읽기->읽은 값이 없으면 -1
			if (i==-1) {
				break;
			}
			char c = (char)i;
//			System.out.println("i : "+i);
			System.out.print(c); //println 안 쓰니까 붙어서 잘 나옴
		}
		//빨대 제거
		fis.close();

	}

}//class
