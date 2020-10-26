package card.ex01_2;

public class Dealer {
	Card[] cards=new Card[52];
	int index=0;
	
	//카드 생성
	void createCards () {
		for (int n=0; n<13; n++) {
			for (int p=0; p<4; p++) {
				int index=(p*13)+n; //0~51, 52개
				cards[index]=new Card();
				cards[index].num=n+1;
				cards[index].pattern=p+1;
			}
		}
		System.out.println("카드 1벌을 생성했습니다.");
	}
	
	//카드 보여주기
	void showCards () {
		for (int i=0; i<cards.length; i++) {
			cards[i].showinfo();
		}
	}
	
	//카드 셔플
	void suffleCards () {
		for (int i=0; i<cards.length; i++) {
			int random=(int)(Math.random()*51)+1;
			Card temp=cards[0];
			cards[0]=cards[random];
			cards[random]=temp;
		}
		System.out.println("카드 1벌을 섞었습니다.");
	}
	
	//카드 주기
	Card getOneCard() {
		if (index>=cards.length) {
			return null;
		}
		return cards[index++];
	}
	
	/*
	//컴퓨터 카드 주기
	void getComCard () {
		System.out.println("컴퓨터에게 카드 1장을 주었습니다.");
		cards[index].showinfo();
	}
	
	//유저 카드 주기
	void getUserCard () {
		System.out.println("당신에게 카드 1장을 주었습니다.");
		cards[index].showinfo();
	}
	*/
	
	//게임 결과
	void resultGame (Card userCard, Card comCard) {
		if (userCard.num>comCard.num) {
			System.out.println("당신이 이겼습니다.");
		} else if (userCard.num<comCard.num) {
			System.out.println("당신이 졌습니다.");
		} else if (userCard.num==comCard.num) {
			if (userCard.pattern>comCard.pattern) {
				System.out.println("당신이 이겼습니다.");
			} else {
				System.out.println("당신이 졌습니다.");
			}
		}
	}
	
	//게임 종료

} //class
