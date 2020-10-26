package card.ex04;

public class Card {
	int num;
	String shape;
	
	Card () {
		System.out.println("카드 생성: ");
		System.out.printf("Card: %d, %s\n", this.num, shape); 
		//위에 정의된  Card (~~~) 하나 만들 때마다 출력
	}
	
	Card (int n) {
		num=n;
		System.out.println("카드 생성: "+n);
	}
	
	Card (int num, String shape) {
		this.num=num;
		this.shape=shape;
		System.out.println("카드 생성: "+num+", "+shape);
		System.out.printf("Card: %d, %s\n", this.num, shape); 
	}
	
}
