package stat.ex01;

public class CardMain {

	public static void main(String[] args) {
//		Card.num=1;  //error
		Card.width=2.5;
//		Card.method1(); //error
		Card.staticMethod1();

//		System.out.println("1.입력 2.저장 3.종료");
		showMenu();
		
	}
	
	public static void showMenu () {
		System.out.println("1.입력 2.저장 3.종료");
	}

}
