package sec02.exam01;

public class IntegerLiteralExample {

	public static void main(String[] args) {
//		System.out.println("Hello");
		
		int var1=0b1011; //2진수 
		int var2=0206; //8진수 (8^2)*2+6=128+8
		int var3=365; //10진수
		int var4=0xB3; //16진수 (11*(16^1))+(3*(16^0))
				
		System.out.println("var1: "+var1); //11
		System.out.println("var2: "+var2); //134
		System.out.println("var3: "+var3); //365
		System.out.println("var4: "+var4); //179
		
		System.out.println();		
	}
}
