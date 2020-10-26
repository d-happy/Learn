package lotto.ex03;

import java.util.Scanner;

public class LottoMain_random {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//변수명 : 값의 의미를 잘 알 수 있게 작명
		
		System.out.println("-----Lottl 6/45-----");
		
		//금액 넣기
		int money=0;
		while (true) {
			System.out.print("금액> ");
			String str1=scanner.nextLine();
			System.out.println(str1);
			//1게임 1,000원 최소금액
			money=Integer.parseInt(str1);
			if (money<1000) {
				System.out.println("\"돈이 부족합니다. 1게임은 1,000원입니다.\"");
				System.out.print("금액> ");		
				String str2=scanner.nextLine();
				System.out.println(str2);
				money=Integer.parseInt(str2); //16<int money>라고 변수 지정, money만 적고 변수 재정의
			} else {
				money=Integer.parseInt(str1);
				break;
			}
		}
		
		//게임 몇 번? while로 계속 반복하다가 조건에 맞으면 break해서 탈출
		//while 밖에서 변수=0; 해두고 while 안에서 변수 재정의 해서 사용
		int game=0;
		while (true) {
			System.out.print("게임> ");
			String str3=scanner.nextLine();
			System.out.println(str3);
			//최대 5게임, 최소 1게임
			game=Integer.parseInt(str3);
			if (game<1 || game>5) {
				System.out.println("\"최소 1게임, 최대 5게임입니다. 게임 횟수를 다시 입력하시오.\"");	
				System.out.print("게임> ");
				String str4=scanner.nextLine();
				System.out.println(str4);
				game=Integer.parseInt(str4);
			} else {
				game=Integer.parseInt(str3);
				break;
			}
		}
		
		//로또 1~45 생성, 자리 만들고 값 넣음
		int[] arrBall=new int[45];
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i]=i+1;
		}
		System.out.println("------------------------");
		
		//로또 6개 랜덤 뽑기  * game 횟수
		for (int num=0; num<game; num++) {
			//랜덤 6개 생성 (아직 인출 안 해서 안 보임, 값만 있음)
			for (int i=0; i<6; i++) {
				arrBall[i]=(int)(Math.random()*45)+1; //1~45
				for (int n=0; n<i; n++) {
					if (arrBall[i]==arrBall[n]) {
						i--;
						break;
					}
				}
			}
			//위에서 만든 랜덤 6개 인출 (인출해서 보임)
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
		
		//거스름돈
		int change=money-(game*1000);
		System.out.printf("거스름돈: %d원",change);
		
		scanner.close(); //scanner 입력 종료 (없어도 운영되긴 함)
	}
}
