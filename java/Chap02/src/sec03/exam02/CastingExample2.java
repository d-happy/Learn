package sec03.exam02;

public class CastingExample2 {

	public static void main(String[] args) {

		int kor=90;
		int eng=70;
		int math=60;
		
		int sum=kor+eng+math;
		double do1=sum/3.0;
		//int ���� 3.0 ���� �Ǽ� ������ �ڵ����� double
		
		System.out.println("���� : "+sum);
		System.out.println("��� : "+do1);
	}
}
