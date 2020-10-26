package ex01;

public class ExceptionEx {

	public static void main(String[] args) {
		int a=10;
		int b = 0;
		
		/*//그냥 2가지 선택지 보여준 것
		 if (b != 0) {
			int c = a / b;
			System.out.println(c);
		} else {
			System.out.println("0으로 나눌 수 없어요");
		}
		*/
		
		//예외 처리 직접 하는 형태
		/*
		try {
			int c=a/b;
			System.out.println(c);
		} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없어요");}
		*/
		
		try {
		method1(a, b);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램 종료");

	}
	//throws ~~~ : { ... } 실행부 안에서 ... 가 처리 못하는 에러 나오면 "에러 메세지" 나옴
	public static int method1(int num1, int num2) throws ArithmeticException{
		int result=num1/num2;
		return result;
	}

}//class
