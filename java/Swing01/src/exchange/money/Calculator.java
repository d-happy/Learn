package exchange.money;

public class Calculator {
	
	private int five_thounds=5000;
	private int one_thounds=1000;
	private int five_hundreds=500;
	private int one_hundreds=100;
	private int five_ten=50;
	private int one_ten=10;
	private int one=1;
	
	private static Calculator instance;
	private Calculator() { /* singleton */ }
	public static Calculator getInctance() {
		if (instance == null) {
			instance = new Calculator();
		}
		return instance;
	}
	
	public int[] calculate(int money) {
//		System.out.println("들어옴 - "+money);
		int[] changeCount = new int[7]; //배열종류[] 배열이름 = new 배열종류[배열 갯수];
		
		while (money > 0) {
			
			if (money >= five_thounds) { //5000
				int count5000 = money/five_thounds;
				
				for (int i=0; i<count5000; i++) {
					money = money-five_thounds;
				}
//				System.out.println("5000원 : " +count5000);
				changeCount[0] = count5000;
			} 
			
			if (money >= one_thounds) { //1000
				int count1000 = money/one_thounds;
						
				for (int i=0; i<count1000; i++) {
					money = money-one_thounds;
				}
				changeCount[1] = count1000;
			}
			
			if (money >= five_hundreds) { //500
				int count500 = money/five_hundreds;
				
				for (int i=0; i<count500; i++) {
					money = money-five_hundreds;
				}
				changeCount[2] = count500;
			}
			
			if (money >= one_hundreds) { //100
				int count100 = money/one_hundreds;
				
				for (int i=0; i<count100; i++) {
					money = money-one_hundreds;
				}
				changeCount[3] = count100;
			}
			
			if (money >= five_ten) { //50
				int count50 = money/five_ten;
				
				for (int i=0; i<count50; i++) {
					money = money-five_ten;
				}
				changeCount[4] = count50;
			}
			
			if (money >= one_ten) { //10
				int count10 = money/one_ten;
				
				for (int i=0; i<count10; i++) {
					money = money-one_ten;
				}
				changeCount[5] = count10;
			}
			
			if (money >= one) { //1
				int count1 = money/one;
				
				for (int i=0; i<count1; i++) {
					money = money-one;
				}
				changeCount[6] = count1;
			}
		}//while
		return changeCount;
		
		/*
		money[0]= getMoney/5000;
		money[1]= (getMoney%5000)/1000;
		money[2]= (getMoney%1000)/500;
		money[3]= ((getMoney%1000)%500)/100;
		money[4]= (((getMoney%1000)%500)%100)/50;
		money[5]= ((((getMoney%1000)%500)%100)%50)/10;
		money[6]= (((((getMoney%1000)%500)%100)%50)%10)/1;
		*/
		//getMoney=money 변수값, 게터세터 아님, 
		//나머지% 값을 나눈/ 값을 배열에 넣음
		
	}//calculate

}//class
