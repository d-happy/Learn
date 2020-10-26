package sec01.exam01;

public class Gugudan2 {

	public static void main(String[] args) {
		
		//출력 :	1줄 1,2단 -> 2줄 1,2단	OOOOO
		//1단 1,2,3줄 -> 2단 1,2,3줄	XXXXX
		
		for (int num=1; num<=9; num++) {
				
			for (int i=2; i<=5; i++) {
				int gugu=i*num;
//				System.out.print(i+" X "+num+" = "+gugu+"\t");	
				System.out.printf("%1$d X %2$d = %3$d\t", i, num, gugu);
			}
			System.out.println();
		}
		System.out.println();
		
		for (int num2=1; num2<=9; num2++) {
				
			for (int s=6; s<=9; s++) {
				int gugu2=s*num2;
//				System.out.print(s+" X "+num2+" = "+gugu2+"\t");				
				System.out.printf("%1$d X %2$d = %3$d\t", s, num2, gugu2);
			}
			System.out.println();
		}
	}
}
