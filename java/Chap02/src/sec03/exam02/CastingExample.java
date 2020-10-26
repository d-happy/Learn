package sec03.exam02;

public class CastingExample {

	public static void main(String[] args) {
		//명시적 형변환
		int i1=1;
		byte b1=(byte)i1; //값100 가능하지만 int>byte라서  안 된다고 판단 
		System.out.println("b1: "+b1);
		
		//암시적 형변환
		byte b2=1;
		int i2=b2;
		System.out.println("i2: "+i2);
		
		byte b3=(byte)(b1+b2);
		System.out.println("b3: "+b3);
		
		int i3=b1+b2;
		System.out.println("i3: "+i3);
		
		//정수가 나왔다->int 사용
	}
}
