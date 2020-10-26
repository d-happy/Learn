package lotto.ex04;

public class LottoBall {
	int num;        //번호
	String color;   //색상
	static double radius=4.5;  //반지름

	void showinfo() {
		System.out.printf("숫자: %d, 색상: %s, 크기: %.1f\n", num, color, radius);
	}
}
