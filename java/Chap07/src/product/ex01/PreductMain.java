package product.ex01;

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
		
	}//main

}//class
