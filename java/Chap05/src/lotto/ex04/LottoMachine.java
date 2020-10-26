package lotto.ex04;

public class LottoMachine {
	LottoBall[] balls=new LottoBall[45];
	
	//°ø»ý¼º
	void createBalls() {
		for (int i=0; i<balls.length; i++) {
			balls[i]=new LottoBall();
			balls[i].num=i+1;
			if (0<i&&i<=9) {
				balls[i].color="Yellow";
			} else if (10<i&&i<=19) {
				balls[i].color="red";
			} else if (20<i&&i<=29) {
				balls[i].color="Blue";
			} else if (30<i&&i<=39) {
				balls[i].color="Gray";
			} else {
				balls[i].color="Green";
			}
		}
	}
	
	//°ø¼¯±â
	void suffleBalls() {
		for (int i=0; i<balls.length; i++) {
			int rand=(int)(Math.random()*44)+1;
			LottoBall temp=balls[0];
			balls[0]=balls[rand];
			balls[rand]=temp;
		}
	}
	
	//6°³ »©³»±â
	void getBall6() {
		System.out.print("[ ");
		for (int i=0; i<6; i++) {
			System.out.print(balls[i].num);
			if (i!=5) {
				System.out.print(", ");
			}
		}
		System.out.println(" ]");
	}
	
}
