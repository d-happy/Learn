package lotto.ex04;

public class LottoBall {
	int num;        //��ȣ
	String color;   //����
	static double radius=4.5;  //������

	void showinfo() {
		System.out.printf("����: %d, ����: %s, ũ��: %.1f\n", num, color, radius);
	}
}
