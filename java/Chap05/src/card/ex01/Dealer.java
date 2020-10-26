package card.ex01;

public class Dealer { //���� class�ϱ� main �ʿ� ����

	Card[] cardPack=new Card[52];
	int index=0;

	// ī�� 1~52 ����
	void createCards() {
		// ī�� ����4�� ��4��3��2Ŭ1
		for (int i2 = 0; i2 < 4; i2++) {
			// ī�� 1~13
			for (int i = 0; i < 13; i++) {
				int index = i2 * 13 + i;
				cardPack[index] = new Card();
				cardPack[index].num = i + 1;
				cardPack[index].pattern = i2 + 1;
			}
		}
		System.out.println("ī�� 1���� �����߽��ϴ�.");
	}
	
	//ī�� Ȯ��
	void showCard() {
		for (int i = 0; i < cardPack.length; i++) {
			cardPack[i].showinfo();
			System.out.println();
		}
	}

	// ī�� ����
	void sufflCard() {
		for (int i=0; i<cardPack.length; i++) {
			int rand=(int)(Math.random()*51)+1; //52�߿� 1 ���� 51��
			Card temp=cardPack[0];
			cardPack[0]=cardPack[rand];
			cardPack[rand]=temp;
			System.out.println("ī�� 1���� �������ϴ�.");
		}
	}
	
	// ��ǻ��-����1 �ֱ�
	int c=(int)(Math.random()*52)+1;
	void comCard1 () {
//		cardPack[c].showinfo();
//		System.out.print("����� ī��: "); 
//		cardPack[c].showinfo();
		System.out.println(); 
	}
	
	// �����-����1 �ֱ�
	int u=(int)(Math.random()*52)+1;
	void userCard1 () {
//		int u=(int)(Math.random()*52)+1;
		System.out.print("����� ī��: "); 
		cardPack[u].showinfo();
	}

	// ��ǻ��-����� ���?
	void resultGame () {
		if (cardPack[c].num<cardPack[u].num) { //���� ��
			System.out.println("����� �̰���"); 
		} else if (cardPack[c].num>cardPack[u].num) { //�� ��
			System.out.println("����� �����");
		} else { //���� =
			if (cardPack[c].pattern<cardPack[u].pattern) { //���� ��
			System.out.println("����� �̰���"); 
			} else { //�� ��
			System.out.println("����� �����");
			} 
		}
	}

	// ���� ����
//	void () {}
}