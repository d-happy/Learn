package sec02.exam01;

public class CharExample {

	public static void main(String[] args) {
		//문자형은 홑따옴표 안에 1개의 문자
		char ch1='A';
		char ch2='가';
//		char ch3='AB'; //error-2개
//		char ch4=''; //error-0개
		
		char ch5=65;
		System.out.println("ch5: "+ch5); //A
		char ch6='\uac00'; //유니코드(utf-16)
		System.out.println("ch6: "+ch6);
		
		//쌍따옴표는 안됨
//		char ch7="H"; //한글자지만 쌍따옴표 - 에러
	}
}
