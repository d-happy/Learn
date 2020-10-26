package card.ex01_2;

public class Dealer {
	Card[] cards=new Card[52];
	int index=0;
	
	//ī�� ����
	void createCards () {
		for (int n=0; n<13; n++) {
			for (int p=0; p<4; p++) {
				int index=(p*13)+n; //0~51, 52��
				cards[index]=new Card();
				cards[index].num=n+1;
				cards[index].pattern=p+1;
			}
		}
		System.out.println("ī�� 1���� �����߽��ϴ�.");
	}
	
	//ī�� �����ֱ�
	void showCards () {
		for (int i=0; i<cards.length; i++) {
			cards[i].showinfo();
		}
	}
	
	//ī�� ����
	void suffleCards () {
		for (int i=0; i<cards.length; i++) {
			int random=(int)(Math.random()*51)+1;
			Card temp=cards[0];
			cards[0]=cards[random];
			cards[random]=temp;
		}
		System.out.println("ī�� 1���� �������ϴ�.");
	}
	
	//ī�� �ֱ�
	Card getOneCard() {
		if (index>=cards.length) {
			return null;
		}
		return cards[index++];
	}
	
	/*
	//��ǻ�� ī�� �ֱ�
	void getComCard () {
		System.out.println("��ǻ�Ϳ��� ī�� 1���� �־����ϴ�.");
		cards[index].showinfo();
	}
	
	//���� ī�� �ֱ�
	void getUserCard () {
		System.out.println("��ſ��� ī�� 1���� �־����ϴ�.");
		cards[index].showinfo();
	}
	*/
	
	//���� ���
	void resultGame (Card userCard, Card comCard) {
		if (userCard.num>comCard.num) {
			System.out.println("����� �̰���ϴ�.");
		} else if (userCard.num<comCard.num) {
			System.out.println("����� �����ϴ�.");
		} else if (userCard.num==comCard.num) {
			if (userCard.pattern>comCard.pattern) {
				System.out.println("����� �̰���ϴ�.");
			} else {
				System.out.println("����� �����ϴ�.");
			}
		}
	}
	
	//���� ����

} //class
