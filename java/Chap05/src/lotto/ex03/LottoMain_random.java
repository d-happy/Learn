package lotto.ex03;

import java.util.Scanner;

public class LottoMain_random {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//������ : ���� �ǹ̸� �� �� �� �ְ� �۸�
		
		System.out.println("-----Lottl 6/45-----");
		
		//�ݾ� �ֱ�
		int money=0;
		while (true) {
			System.out.print("�ݾ�> ");
			String str1=scanner.nextLine();
			System.out.println(str1);
			//1���� 1,000�� �ּұݾ�
			money=Integer.parseInt(str1);
			if (money<1000) {
				System.out.println("\"���� �����մϴ�. 1������ 1,000���Դϴ�.\"");
				System.out.print("�ݾ�> ");		
				String str2=scanner.nextLine();
				System.out.println(str2);
				money=Integer.parseInt(str2); //16<int money>��� ���� ����, money�� ���� ���� ������
			} else {
				money=Integer.parseInt(str1);
				break;
			}
		}
		
		//���� �� ��? while�� ��� �ݺ��ϴٰ� ���ǿ� ������ break�ؼ� Ż��
		//while �ۿ��� ����=0; �صΰ� while �ȿ��� ���� ������ �ؼ� ���
		int game=0;
		while (true) {
			System.out.print("����> ");
			String str3=scanner.nextLine();
			System.out.println(str3);
			//�ִ� 5����, �ּ� 1����
			game=Integer.parseInt(str3);
			if (game<1 || game>5) {
				System.out.println("\"�ּ� 1����, �ִ� 5�����Դϴ�. ���� Ƚ���� �ٽ� �Է��Ͻÿ�.\"");	
				System.out.print("����> ");
				String str4=scanner.nextLine();
				System.out.println(str4);
				game=Integer.parseInt(str4);
			} else {
				game=Integer.parseInt(str3);
				break;
			}
		}
		
		//�ζ� 1~45 ����, �ڸ� ����� �� ����
		int[] arrBall=new int[45];
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i]=i+1;
		}
		System.out.println("------------------------");
		
		//�ζ� 6�� ���� �̱�  * game Ƚ��
		for (int num=0; num<game; num++) {
			//���� 6�� ���� (���� ���� �� �ؼ� �� ����, ���� ����)
			for (int i=0; i<6; i++) {
				arrBall[i]=(int)(Math.random()*45)+1; //1~45
				for (int n=0; n<i; n++) {
					if (arrBall[i]==arrBall[n]) {
						i--;
						break;
					}
				}
			}
			//������ ���� ���� 6�� ���� (�����ؼ� ����)
			System.out.print("[ ");
			for (int i=0; i<6; i++) {
				System.out.print(arrBall[i]);
				if (i!=5) {
					System.out.print(", ");
				}
			}
			System.out.println(" ]");
		}
		System.out.println("------------------------");
		
		//�Ž�����
		int change=money-(game*1000);
		System.out.printf("�Ž�����: %d��",change);
		
		scanner.close(); //scanner �Է� ���� (��� ��Ǳ� ��)
	}
}
