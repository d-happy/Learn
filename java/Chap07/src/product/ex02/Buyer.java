package product.ex02;

public class Buyer {
	int money=1000;
	int bonusPoint=0;
	Product[] cart=new Product[10];
	int index=0;
	
	void buy(Product p) { 
		if (money<p.price) {
			System.out.println("�ܾ��� �����մϴ�.");
			return;
		}
		
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"��(��) ������");
		
		cart[index++]=p;
//		index++;
	}
	
	void showBuyList() {
		System.out.println("---- ���� ��� ----");
		for (int i=0; i<index; i++) {
			System.out.println(cart[i]);
		}
		System.out.println("----------------");
	}
		
}//class
