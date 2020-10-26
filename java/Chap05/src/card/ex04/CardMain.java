package card.ex04;

public class CardMain {

	public static void main(String[] args) {
		Card c1=new Card();
		System.out.printf("c1: %d, %s\n", c1.num, c1.shape);
		
		Card c2=new Card(1);
		System.out.printf("c2: %d, %s\n", c2.num, c2.shape);
		
		Card c3=new Card(1, "하트");
		System.out.printf("c3: %d, %s\n", c3.num, c3.shape);
		
		Card c4=new Card(4, "다이아");
		System.out.printf("c4: %d, %s\n", c4.num, c4.shape);
	}
}
