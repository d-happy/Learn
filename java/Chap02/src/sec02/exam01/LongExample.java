package sec02.exam01;

public class LongExample {

	public static void main(String[] args) {
		// long -8byte(-900��~900��)
		// int -4byte(-21��~21��)
		long l1=10;
		long l2=10000000000L; //100��
		//->100���̶�� ���ͷ� ���� int�� ������ ��� (������ �⺻���� int ���)
		//->���� 'L'�̶�� long Ÿ�� ���ͷ�
		//->�ҹ��� 'l'�� ���������� ����'1'�� �ĺ� �����
		
		System.out.println("l1: "+l1);
		System.out.println("l2: "+l2);
	}
}
