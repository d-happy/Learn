package sec04.exam05;

public class StringEqualTest {

	public static void main(String[] args) {
		String str1="Hello"; //문자열 상수
		String str2=new String("Hello"); //문자열 객체
		if (str1==str2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
			
		}
		//문자열 값이 같은지를 비교할 때는 ==이 아닌 equals()를 사용
		if (str1.equals(str2)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}

}
