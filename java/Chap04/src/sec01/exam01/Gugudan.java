package sec01.exam01;

public class Gugudan {

	public static void main(String[] args) {

		for (int i=2; i<=9; i++) {

			for (int num=1; num<=9; num++) {
				int gugu=i*num;
				System.out.printf("%1$d X %2$d = %3$d\n", i, num, gugu);
				
//				System.out.println(i+" X "+num+" = "+gugu);
//				System.out.printf("%d X %d = %2d\n", i, num, i*num); 
				//2d=2�ڸ� ����, gugu ���� �ٷ� *�ص� ��
			}
			System.out.println("----------");
		}
	}
}
