package sec03.exam02;

public class CastingExample {

	public static void main(String[] args) {
		//����� ����ȯ
		int i1=1;
		byte b1=(byte)i1; //��100 ���������� int>byte��  �� �ȴٰ� �Ǵ� 
		System.out.println("b1: "+b1);
		
		//�Ͻ��� ����ȯ
		byte b2=1;
		int i2=b2;
		System.out.println("i2: "+i2);
		
		byte b3=(byte)(b1+b2);
		System.out.println("b3: "+b3);
		
		int i3=b1+b2;
		System.out.println("i3: "+i3);
		
		//������ ���Դ�->int ���
	}
}
