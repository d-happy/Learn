package product.ex03;

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
		if (index<=0) {
			System.out.println("구매한 상품 없음");
			return;
		}
		for (int i=0; i<index; i++) {
			System.out.println(cart[i]);
		}
		System.out.println("----------------");
	}
	
	void refund(Product p) {
		if (index<=0) {
			System.out.println("구매한 상품 없음");
			return;
		}
		for (int i=0; i<index; i++) {
			if (p.price==cart[i].price) {
				for (int j=i; j<index; j++) {
					cart[j]=cart[j+1];
				}
				cart[index-1]=null;
				index--;
				money+=p.price;
				bonusPoint-=p.bonusPoint;
				System.out.println(p+"를(을) 환불함");
				return;
			}
		}
	}
	

}//class

/*cart[index]=p;
			if (p.price==cart[index].price) {
				cart[index]=cart[index+1];
				cart[index-1]=null;
				index--;
				money+=p.price;
				bonusPoint-=p.bonusPoint;
				System.out.println(p+"를(을) 환불함");
				return;
			}*/