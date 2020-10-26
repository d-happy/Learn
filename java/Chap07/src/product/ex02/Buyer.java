package product.ex02;

public class Buyer {
	int money=1000;
	int bonusPoint=0;
	Product[] cart=new Product[10];
	int index=0;
	
	void buy(Product p) { 
		if (money<p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"를(을) 구매함");
		
		cart[index++]=p;
//		index++;
	}
	
	void showBuyList() {
		System.out.println("---- 구매 목록 ----");
		for (int i=0; i<index; i++) {
			System.out.println(cart[i]);
		}
		System.out.println("----------------");
	}
		
}//class
