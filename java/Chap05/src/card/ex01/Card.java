package card.ex01;

public class Card {  //�����ϰ� �����ϱ�!!!!!!!
	int num;         //��ȣ 1~13
	int pattern;     //���� 4�� (���̿� ���� �ֱ� ��4��3��2Ʈ1)
	
	void showinfo () {
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
		case 1:
			System.out.print("��");
			break;
		case 2:
			System.out.print("��");
			break;
		case 3:
			System.out.print("��");
			break;
		case 4:
			System.out.print("��");
			break;
		}
		System.out.println();
	}
}
