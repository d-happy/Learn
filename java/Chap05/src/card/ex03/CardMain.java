package card.ex03;

public class CardMain {

	public static void main(String[] args) {
		Card c1=new Card();
		Card c2=new Card(1);
		System.out.println("c2: "+c2.num);
		Card c3=new Card(1, "하트");
		System.out.printf("c3: %d, %s\n", c3.num, c3.shape);
		Card c4=new Card(8, "스페이스", 0.9);
		System.out.printf("c4: %d, %s, %1.1f", c4.num, c4.shape, c4.double1);
	}
}
