package card.ex03;

public class Card {
	int num;
	String shape;
	double double1;
	
	Card () {
		System.out.println("墨靛 积己");
	}
	Card (int n) {
//		this.num=num; //me, my, self //this.num=int num; 啊府糯
		num=n;
		System.out.println(num+"墨靛 积己");
	}
	Card (int num, String shape) {
		this.num=num;
		this.shape=shape;
		System.out.println(num+", "+shape+"墨靛 积己");
	}
	Card (int num, String shape, double double1) {
		this.num=num;
		this.shape=shape;
		this.double1=double1;
		System.out.println(num+", "+shape+", "+double1+" 积己");
	}
}
