package ex01;

import java.io.File;
import java.util.Date;

public class FileEx {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//프로그램에서의 파일 : 파일, 폴더(디렉터리)
		File f1 = new File("G:\\workspace\\java\\Hello.java");
		System.out.println(f1);
		File f2 = new File("G:\\workspace\\java");
		System.out.println(f2);
		
		//파일인지
		if (f1.isFile()) { //is - boolean 표현
			System.out.println("f1은 파일이다"); //Hello.java == 파일
		} else {
			System.out.println("f1은 파일이 아니다");
		}
		if (f2.isFile()) {
			System.out.println("f2는 파일이다");
		} else {
			System.out.println("f2는 파일이 아니다");
		}
		//폴더(디렉터리)인지
		if (f1.isDirectory()) {
			System.out.println("f1은 폴더이다");
		} else {
			System.out.println("f1은 폴더가 아니다");
		}
		if (f2.isDirectory()) { 
			System.out.println("f2는 폴더이다"); //java == 폴더
		} else {
			System.out.println("f2는 폴더가 아니다");
		}
		
		//폴더 만들기 - make directory - mkdir()
		File f3 = new File("G:\\workspace\\javs2");
		
		if (!f3.exists()) { //존재하지 않는다면
			f3.mkdir();     //폴더 생성
		}
		
		//다중 폴더 생성
		File f4 = new File("G:\\workspace\\java3\\dir1\\dir2\\dir3");
		if (!f4.exists()) {
			f4.mkdirs(); //폴더 여러개 생성
		}
		
		//파일 목록
		File f5 = new File("G:\\workspace\\html"); //html 폴더 -> new File
		String[] names = f5.list(); //리스트 생성
		
		
//		System.out.println(names);
		
		
		for (String name : names) {
			
			File temp = new File("G:\\workspace\\html\\"+name); //html 각각의 파일에 대해 객체 생성
			
			
			//시간 구하기
			long l = temp.lastModified(); //timestamp - 1970/01/01/00:00
			Date d = new Date(l);
			
			int year = d.getYear() + 1900;
			int month = d.getMonth() + 1; //0부터 시작
			int date = d.getDate();
			int hour = d.getHours();
			int minute = d.getMinutes();
			int second = d.getSeconds();
			
			System.out.printf("%s-%s-%s %s:%s:%s \t", 
					make2digits(year), 
					make2digits(month), 
					make2digits(date), 
					make2digits(hour), 
					make2digits(minute), 
					make2digits(second));
			
			if (temp.isDirectory()) {
				System.out.print("<DIR>\t");
			} else {
				System.out.print("\t");
			}
			
			System.out.print(name+"\t"); //파일(파일, 폴더) 이름으로 출력
			
			//파일 크기
			long len = temp.length();
			System.out.println(len);
			
		}
		
		
		
	}//main
	
	
	public static String make2digits (int i) {
//		if (i < 10) {
//			return "0"+i;
//		} else {
//			return ""+i;
//		}
		return (i<10) ? ("0"+i) : ""+i ;
	}
	

}//class
