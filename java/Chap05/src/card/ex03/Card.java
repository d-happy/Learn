package card.ex03;

public class Card {
	int num;
	String shape;
	double double1;
	
	Card () {
		System.out.println("ī�� ����");
	}
	Card (int n) {
//		this.num=num; //me, my, self //this.num=int num; ����Ŵ
		num=n;
		System.out.println(num+"ī�� ����");
	}
	Card (int num, String shape) {
		this.num=num;
		this.shape=shape;
		System.out.println(num+", "+shape+"ī�� ����");
	}
	Card (int num, String shape, double double1) {
		this.num=num;
		this.shape=shape;
		this.double1=double1;
		System.out.println(num+", "+shape+", "+double1+" ����");
	}
}
