package card.ex04;

public class Card {
	int num;
	String shape;
	
	Card () {
		System.out.println("ī�� ����: ");
		System.out.printf("Card: %d, %s\n", this.num, shape); 
		//���� ���ǵ�  Card (~~~) �ϳ� ���� ������ ���
	}
	
	Card (int n) {
		num=n;
		System.out.println("ī�� ����: "+n);
	}
	
	Card (int num, String shape) {
		this.num=num;
		this.shape=shape;
		System.out.println("ī�� ����: "+num+", "+shape);
		System.out.printf("Card: %d, %s\n", this.num, shape); 
	}
	
}
