package card.ex05;

import java.util.Scanner;

public class CardMain {

	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("1.ī�� ���� 2.ī�� ���� 3.��ǻ�� ī�� �ֱ� 4.���� ī�� �ֱ� 5.���� ��� 6.���� ����");
		Dealer dealer1=Dealer.getInstance();
		Dealer dealer2=Dealer.getInstance();
		System.out.println(dealer1+"|"+dealer2);
		Card comCard=null;
		Card userCard=null;
		
		while (true) {
		
			System.out.print("�Է�> ");
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
					System.out.println("���� ī�尡 �����ϴ�.");
				} else{
					System.out.println("��ǻ�Ϳ��� ī�� 1���� �־����ϴ�.");
					comCard.showinfo();
				}
				break;
			case "4":
				userCard=dealer1.getOneCard();
				if (comCard==null) {
					System.out.println("���� ī�尡 �����ϴ�.");
				} else{
					System.out.println("��ſ��� ī�� 1���� �־����ϴ�.");
					System.out.print("����� ī��: ");
					userCard.showinfo();
				}
				break;
			case "5":
				dealer1.resultGame(userCard, comCard);
				break;
			case "6":
				System.out.println("���� ����");
				System.exit(0);
				return;
			}
			
		} //while
		
	} //main
	
} //class
