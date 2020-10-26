package card.ex01;

public class CardMain {
	//순서대로 하기!!!!!!!!!!
	public static void main(String[] args) {
		Dealer dealer1=new Dealer();
		
		
		dealer1.createCards();
		dealer1.showCard();
		System.out.println("----------");
		dealer1.sufflCard();
		System.out.println("----------");
		dealer1.showCard();
		System.out.println("----------");
		/*
		Card comCard=dealer1.giveOneCard(); 
		comCard.showinfo();
		Card userCard=dealer1.giveOneCard(); 
		userCard.showinfo();
		*/
		dealer1.comCard1();
		dealer1.userCard1();
		dealer1.resultGame();

	}

}
