package sec02.exam01;

public class StringExample {

	public static void main(String[] args) {
		//문자열은 쌍따옴표-0개 이상
		String s1="";
		String s2="A";
		String s3="AB";
//		String s4='A'; //홑따옴표-에러
		
		//문자열에서의 +는 연결
		System.out.println(s1+s2+s3);
		
		//문자열 내에서 따옴표 표현
		System.out.println("She said \"꺼져\"");
		
		//t-tab문자
		System.out.println("가\t나\t다\t라");
		
		//n-new line (줄바꾸기-개행)
		System.out.println("마\n바\n사\n아");
		
		//홑따옴표-\'
		System.out.println("자\'차\'카타");
		
		//백슬래시 자제-\\
		System.out.println("C:\\workspace\\java");
	}
}
