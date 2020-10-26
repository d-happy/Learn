package lotto.ex02;

public class LottoMain {

	public static void main(String[] args) {
		//공 45개 만들어진 게 아니다.
		//공이 들어갈 <<공간>> 45개가 만들어 진 것임. //LottoBall이라는 이름의(;종류의) 배열 생성
		LottoBall[] arrBall=new LottoBall[45];
		for (int i=0; i<arrBall.length; i++) {
			System.out.println(arrBall[i]);
		}

		//공 45개 만들어서 넣기
		for (int i=0; i<arrBall.length; i++) {
			//생성된 공간에 공을 만들어서 넣음, LottoBall클래스 바탕으로 객체 하나 생성
			arrBall[i]=new LottoBall();
			//만들어진 공의 숫자 설정
			arrBall[i].num=i+1;
			//만들어진 공의 색상 설정
			if (0<=i&&i<=9) {
				arrBall[i].color="Yellow";
			} else if (10<=i&&i<=19) {
				arrBall[i].color="Blue";
			} else if (20<=i&&i<=29) {
				arrBall[i].color="Red";
			} else if (30<=i&&i<=39) {
				arrBall[i].color="Gray";
			} else {
				arrBall[i].color="Green";
			}
		}
		System.out.println("---------------------");
		//생성된 공 확인
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
		System.out.println("---------------------");
		for (int i=0; i<90; i++) {
			int rand=(int)(Math.random()*44)+1; //1~44
			LottoBall temp=arrBall[0]; //a,b 교환의 temp
			arrBall[0]=arrBall[rand];
			arrBall[rand]=temp;
		}
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
		System.out.println("---------------------");
		
		LottoBall.radius=5.5; //static 레벨은 class 이름으로 접급

		System.out.println("---------------------");

		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
	}
}
