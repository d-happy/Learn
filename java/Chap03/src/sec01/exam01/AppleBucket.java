package sec01.exam01;

public class AppleBucket {

	public static void main(String[] args) {
		
		int apple=123;
		int bucket=10;
		
		int result1=apple/bucket; 
//		System.out.println(result1); //int�� 12.3�� 0.3�� ���ư�

		int result2=apple%bucket;
		
		/*
		int addCount=(apple%bucket==0)? 0 : 1 ;
		int totalCount=result1+addCount;
		System.out.printf("�ٱ��� ���� : %d��", totalCount);
		*/
		
		String Result=(result2==0) ? result1+"�� �Դϴ�.":(result1+1)+"�� �Դϴ�.";
		//�������� !0 == result1 ������ �ٱ��� 1�� �� �ʿ� 
			
		System.out.println("��� ��� �ٱ����� ������ "+Result);
	}
}