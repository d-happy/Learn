package sec02.exam01;

public class FloatDoubleExample {

	public static void main(String[] args) {
//		float f1=1.414; //에러
		float f2=1.414f;
		float f3=1.414F;
		
		int i1=1;
		int i2=2;
		int i3=i1/i2; //0.5
		System.out.println("i3: "+i3); //0
		
		//정수와 정수의 연산->정수
		
		//e-exponent (지수)
		//1.2e3 -> 1.2*1000=1200
		double d1=1.2e3;
		System.out.println("d1: "+d1);
		
//		int v2=le2; //error
		float f4=1e2f; //1*100
		System.out.println("f4: "+f4);
		
		System.out.print("AAAAAA\n");
		System.out.println("BBBBBB"); //ln : line
		
		boolean b1=true;
		boolean b2=!true;
		
		System.out.println("b1: "+b1);
		System.out.println("b2: "+b2);
	}

}
