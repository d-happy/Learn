package test;

public class Card {
	
	public int num;
	public int shape;
	
	public static void main(String[] args) {
		Card[] cards = new Card[52];
//		int card;
		
		for (int i=0; i<cards.length; i++) {
//			cards[i] = i + 1;
		}
		
		for (int i=0; i<cards.length; i++) {
			int randomNum = (int)((Math.random()*52)+1);
			
			Card temp = cards[i];
			cards[i] = cards[randomNum];
			cards[randomNum] = temp;
		}
	}

}//class
