package sec04.exam05;

//import java.io.IOException;
import java.util.Scanner;

public class ScannExample {
	
	public static void main(String[] args) {
		//키보드와 연결된 스캐너를 하나 생성
		Scanner scanner=new Scanner(System.in);
		
		while (true) {
			String str=scanner.nextLine();
			System.out.println("str: "+str);
			if (str.equals("q")) {
				break;
			}
		}
		System.out.println("종료");
		scanner.close(); //스캐너 닫기(종료)
	}
}