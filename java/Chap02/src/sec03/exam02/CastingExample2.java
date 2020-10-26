package sec03.exam02;

public class CastingExample2 {

	public static void main(String[] args) {

		int kor=90;
		int eng=70;
		int math=60;
		
		int sum=kor+eng+math;
		double do1=sum/3.0;
		//int 값에 3.0 같은 실수 붙으면 자동으로 double
		
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+do1);
	}
}
