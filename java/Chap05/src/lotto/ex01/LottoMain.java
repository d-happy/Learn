package lotto.ex01;

public class LottoMain {

	public static void main(String[] args) { //static(정적;고정), class level
		//객체 생성은 new 클래스명() 으로 한다.
		LottoBall ball1=new LottoBall();
		LottoBall ball2=new LottoBall();
		//->힙메모리에 생성되는 필드는 자동으로 기본값으로 초기화 됨.
		// 정수형: 0 | 실수형: 0.0 | 불리언: false | 참조형: null
		System.out.println("ball: "+ball1);
		ball1.num=1;
		ball1.color="RED";
		ball1.radius=4.5;
		System.out.println("ball1: "+ball1);
		System.out.println("ball2: "+ball2);
		//ball1은 밑 LottoBall 클래스의 필드값이 바뀌고 ball2는 그대로
	}
}

class LottoBall {
	//속성- 필드
	int num=10;		//숫자
	String color="White";	//색상
	double radius=2.3;	//반지름
	//LottoBall 클래스에서 ㅁㅁ 만들면 위의 필드가 생기고 
	//나중에 개별 ㅁㅁ의 필드의 처음값(초기화)이 됨
	
	@Override
	public String toString() {
		return "LottoBall [num=" + num + ", color=" + color + ", radius=" + radius + "]";
	//객체의 필드를 확인하기 위해 
	}
}