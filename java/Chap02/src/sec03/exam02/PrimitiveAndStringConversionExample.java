package sec03.exam02;

public class PrimitiveAndStringConversionExample {

	public static void main(String[] args) {
		int i1=Integer.parseInt("10");
		System.out.println("10"+1); //101
		System.out.println(i1+1); //11
		
		double d1=Double.parseDouble("3.14");
		System.out.println(d1+0.1); //3.24
		
		boolean b1=Boolean.parseBoolean("true");
		System.out.println(!b1); //false
		
		// primitive -> String
		// String.valueOf(°ª)
		String s1=String.valueOf(10); //"10"
		System.out.println(s1+1); //101
		
		String s2=String.valueOf(3.14);
		System.out.println(s2+0.1); // "3.14"+0.1=3.140.1
		
		String s3=String.valueOf(true); //"true"
//		System.out.println(!s3); //!"true" error
		
		String s4=10+""; //"10"
		String s5=""+10; //"10"
	}
}
