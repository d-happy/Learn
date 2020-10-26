package lotto.ex02;

public class LottoMain {

	public static void main(String[] args) {
		//�� 45�� ������� �� �ƴϴ�.
		//���� �� <<����>> 45���� ����� �� ����. //LottoBall�̶�� �̸���(;������) �迭 ����
		LottoBall[] arrBall=new LottoBall[45];
		for (int i=0; i<arrBall.length; i++) {
			System.out.println(arrBall[i]);
		}

		//�� 45�� ���� �ֱ�
		for (int i=0; i<arrBall.length; i++) {
			//������ ������ ���� ���� ����, LottoBallŬ���� �������� ��ü �ϳ� ����
			arrBall[i]=new LottoBall();
			//������� ���� ���� ����
			arrBall[i].num=i+1;
			//������� ���� ���� ����
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
		//������ �� Ȯ��
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
		System.out.println("---------------------");
		for (int i=0; i<90; i++) {
			int rand=(int)(Math.random()*44)+1; //1~44
			LottoBall temp=arrBall[0]; //a,b ��ȯ�� temp
			arrBall[0]=arrBall[rand];
			arrBall[rand]=temp;
		}
		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
		System.out.println("---------------------");
		
		LottoBall.radius=5.5; //static ������ class �̸����� ����

		System.out.println("---------------------");

		for (int i=0; i<arrBall.length; i++) {
			arrBall[i].showinfo();
		}
	}
}
