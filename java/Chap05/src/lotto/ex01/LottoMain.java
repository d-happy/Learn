package lotto.ex01;

public class LottoMain {

	public static void main(String[] args) { //static(����;����), class level
		//��ü ������ new Ŭ������() ���� �Ѵ�.
		LottoBall ball1=new LottoBall();
		LottoBall ball2=new LottoBall();
		//->���޸𸮿� �����Ǵ� �ʵ�� �ڵ����� �⺻������ �ʱ�ȭ ��.
		// ������: 0 | �Ǽ���: 0.0 | �Ҹ���: false | ������: null
		System.out.println("ball: "+ball1);
		ball1.num=1;
		ball1.color="RED";
		ball1.radius=4.5;
		System.out.println("ball1: "+ball1);
		System.out.println("ball2: "+ball2);
		//ball1�� �� LottoBall Ŭ������ �ʵ尪�� �ٲ�� ball2�� �״��
	}
}

class LottoBall {
	//�Ӽ�- �ʵ�
	int num=10;		//����
	String color="White";	//����
	double radius=2.3;	//������
	//LottoBall Ŭ�������� ���� ����� ���� �ʵ尡 ����� 
	//���߿� ���� ������ �ʵ��� ó����(�ʱ�ȭ)�� ��
	
	@Override
	public String toString() {
		return "LottoBall [num=" + num + ", color=" + color + ", radius=" + radius + "]";
	//��ü�� �ʵ带 Ȯ���ϱ� ���� 
	}
}