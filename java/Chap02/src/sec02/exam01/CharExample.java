package sec02.exam01;

public class CharExample {

	public static void main(String[] args) {
		//�������� Ȭ����ǥ �ȿ� 1���� ����
		char ch1='A';
		char ch2='��';
//		char ch3='AB'; //error-2��
//		char ch4=''; //error-0��
		
		char ch5=65;
		System.out.println("ch5: "+ch5); //A
		char ch6='\uac00'; //�����ڵ�(utf-16)
		System.out.println("ch6: "+ch6);
		
		//�ֵ���ǥ�� �ȵ�
//		char ch7="H"; //�ѱ������� �ֵ���ǥ - ����
	}
}
