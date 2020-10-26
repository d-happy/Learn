package product.ex03;

public class PreductMain {

	public static void main(String[] args) {
		Buyer b1=new Buyer();
		Tv tv1=new Tv();
		b1.buy(tv1);
		System.out.println("money: "+b1.money);
		System.out.println("bonusPoint: "+b1.bonusPoint);
		
		Computer com1=new Computer();
		b1.buy(com1);
		System.out.println("money: "+b1.money);
		System.out.println("bonusPoint: "+b1.bonusPoint);
		b1.showBuyList();
		
		//환불 해와
		b1.refund(com1);
		//구매 목록 보여줘
		b1.showBuyList();
		System.out.println("money: "+b1.money);
		System.out.println("bonusPoint: "+b1.bonusPoint);
		System.out.println("----------------");
		b1.buy(com1);
		b1.refund(tv1);
		b1.showBuyList();
		System.out.println("money: "+b1.money);
		System.out.println("bonusPoint: "+b1.bonusPoint);
		
		
	}//main

}//class
