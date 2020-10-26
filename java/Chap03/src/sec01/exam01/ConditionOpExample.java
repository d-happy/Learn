package sec01.exam01;

public class ConditionOpExample {

	public static void main(String[] args) {
		int a=10;
		int b=2;
		String result="";
		
		if (a%b==0) {
			result="입니다";
		} else {
			result="가 아닙니다";
		}
		System.out.println("2의 배수"+result);
		
		int c=10;
		int d=3;
		// (조건식) ? A : B
		result=(c%d==0)? "입니다.":"가 아닙니다.";
		System.out.println("3의 배수"+result);
	}
}
