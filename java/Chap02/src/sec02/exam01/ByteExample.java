package sec02.exam01;

public class ByteExample {

	public static void main(String[] args) {
		//byte-정수형, -128~127
		byte var1=-128;
		byte var2=127;
//		byte var3=-129; //byte 범위를 벗어나는 값을 할당->에러
//		byte var4=128; //byte 범위를 벗어나는 값을 할당->에러
		
		byte var5=1;
		byte var6=2;
		
		//Java에서의 연산의 기본 단위는 int
		//반드시 값만 가지고 체크하는 게 아님
//		byte var7=var5+var6; //int끼리 더해서 byte로 표현 X
	}
}
