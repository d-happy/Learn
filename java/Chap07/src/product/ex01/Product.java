package product.ex01;

public class Product {
	int price;      //가격
	int bonusPoint; //보너스 점수
	
	Product(int price) {
		this.price=price;
		bonusPoint=(int)(price/10.0);
	}

}
