package sec04.exam05;

public class StringEqualTest {

	public static void main(String[] args) {
		String str1="Hello"; //���ڿ� ���
		String str2=new String("Hello"); //���ڿ� ��ü
		if (str1==str2) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���");
			
		}
		//���ڿ� ���� �������� ���� ���� ==�� �ƴ� equals()�� ���
		if (str1.equals(str2)) {
			System.out.println("����");
		} else {
			System.out.println("�ٸ���");
		}
	}

}
