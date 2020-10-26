package card.ex05;

import java.util.Scanner;

public class CardMain {

	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("1.카드 생성 2.카드 섞기 3.컴퓨터 카드 주기 4.유저 카드 주기 5.게임 결과 6.게임 종료");
		Dealer dealer1=Dealer.getInstance();
		Dealer dealer2=Dealer.getInstance();
		System.out.println(dealer1+"|"+dealer2);
		Card comCard=null;
		Card userCard=null;
		
		while (true) {
		
			System.out.print("입력> ");
			String choice=scanner.nextLine();
			
			switch (choice) {
			
			case "1":
				dealer1.createCards();
				break;
			case "2":
				dealer1.suffleCards();
				break;
			case "3":
					comCard=dealer1.getOneCard();
				if (comCard==null) {
					System.out.println("섞을 카드가 없습니다.");
				} else{
					System.out.println("컴퓨터에게 카드 1장을 주었습니다.");
					comCard.showinfo();
				}
				break;
			case "4":
				userCard=dealer1.getOneCard();
				if (comCard==null) {
					System.out.println("섞을 카드가 없습니다.");
				} else{
					System.out.println("당신에게 카드 1장을 주었습니다.");
					System.out.print("당신의 카드: ");
					userCard.showinfo();
				}
				break;
			case "5":
				dealer1.resultGame(userCard, comCard);
				break;
			case "6":
				System.out.println("게임 종료");
				System.exit(0);
				return;
			}
			
		} //while
		
	} //main
	
} //class
