package sec04.exam05;

import java.util.Scanner;

public class Example3 { //99p 확인문제3

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("[필수 정보 입력]");
		
		System.out.println("1. 이름: ");
		String str1=scanner.nextLine();

		System.out.println("2. 주민번호 앞 6자리: ");
		String str2=scanner.nextLine();
//		int num1=Integer.parseInt(str2);
		
		System.out.println("3. 전화번호: ");
		String str3=scanner.nextLine(); //010-123-4567
//		String str4=String.valueOf(str3);
		//int call1=Integer.parseInt(str3);
		//System.out.print(call1);
		
		System.out.println(); //빈줄 1
		
		System.out.println("[입력한 내용]");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		//System.out.printf("1. 이름: %s\n", str1);
		//System.out.printf("2. 주빈번호 앞 6자리: %d\n", num1);
		//System.out.printf("3. 전화번호: %s\n", str4);
	}
}

// 문제? 지시사항? 있으면 <자세히 보고> <그대로 출력되게> 작성!!!!1