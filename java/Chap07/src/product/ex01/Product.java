package product.ex01;

public class Product {
	int price;      //����
	int bonusPoint; //���ʽ� ����
	
	Product(int price) {
		this.price=price;
		bonusPoint=(int)(price/10.0);
	}

}
