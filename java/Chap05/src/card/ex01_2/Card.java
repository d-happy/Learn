package card.ex01_2;

public class Card {
	int num;      //숫자 1~13
	int pattern;  //무늬 4개 스4다3하2클1
	
	void showinfo() {
		
		//System.out.println(num+"|"+pattern);
		
		if (num==1) {
			System.out.print("A");
		} else if (num==11) {
			System.out.print("J");
		} else if (num==12) {
			System.out.print("Q");
		} else if (num==13) {
			System.out.print("K");
		} else {
			System.out.print(num);
		}
		
		switch (pattern) {
		case 1 : 
			System.out.println("♣");
			break;
		case 2 : 
			System.out.println("♥");
			break;
		case 3 : 
			System.out.println("◆");
			break;
		case 4 : 
			System.out.println("♠");
			break;
		}
	}
	
} //class
