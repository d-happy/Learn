package card.ex01;

public class Dealer { //참조 class니까 main 필요 없음

	Card[] cardPack=new Card[52];
	int index=0;

	// 카드 1~52 생성
	void createCards() {
		// 카드 무늬4개 스4다3하2클1
		for (int i2 = 0; i2 < 4; i2++) {
			// 카드 1~13
			for (int i = 0; i < 13; i++) {
				int index = i2 * 13 + i;
				cardPack[index] = new Card();
				cardPack[index].num = i + 1;
				cardPack[index].pattern = i2 + 1;
			}
		}
		System.out.println("카드 1벌을 생성했습니다.");
	}
	
	//카드 확인
	void showCard() {
		for (int i = 0; i < cardPack.length; i++) {
			cardPack[i].showinfo();
			System.out.println();
		}
	}

	// 카드 섞기
	void sufflCard() {
		for (int i=0; i<cardPack.length; i++) {
			int rand=(int)(Math.random()*51)+1; //52중에 1 빼고 51장
			Card temp=cardPack[0];
			cardPack[0]=cardPack[rand];
			cardPack[rand]=temp;
			System.out.println("카드 1벌을 섞었습니다.");
		}
	}
	
	// 컴퓨터-랜덤1 주기
	int c=(int)(Math.random()*52)+1;
	void comCard1 () {
//		cardPack[c].showinfo();
//		System.out.print("당신의 카드: "); 
//		cardPack[c].showinfo();
		System.out.println(); 
	}
	
	// 사용자-랜덤1 주기
	int u=(int)(Math.random()*52)+1;
	void userCard1 () {
//		int u=(int)(Math.random()*52)+1;
		System.out.print("당신의 카드: "); 
		cardPack[u].showinfo();
	}

	// 컴퓨터-사용자 결과?
	void resultGame () {
		if (cardPack[c].num<cardPack[u].num) { //유저 승
			System.out.println("당신이 이겼어요"); 
		} else if (cardPack[c].num>cardPack[u].num) { //컴 승
			System.out.println("당신이 졌어요");
		} else { //숫자 =
			if (cardPack[c].pattern<cardPack[u].pattern) { //유저 승
			System.out.println("당신이 이겼어요"); 
			} else { //컴 승
			System.out.println("당신이 졌어요");
			} 
		}
	}

	// 게임 종료
//	void () {}
}