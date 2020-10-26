package sec02.exam01;

public class LongExample {

	public static void main(String[] args) {
		// long -8byte(-900경~900경)
		// int -4byte(-21억~21억)
		long l1=10;
		long l2=10000000000L; //100억
		//->100억이라는 리터럴 값이 int의 범위를 벗어남 (정수는 기본으로 int 취급)
		//->끝에 'L'이라는 long 타입 리터럴
		//->소문자 'l'도 가능하지만 숫자'1'과 식별 어려움
		
		System.out.println("l1: "+l1);
		System.out.println("l2: "+l2);
	}
}
