package collec.ex01;

//Ctrl+Shift+O
import java.util.ArrayList;
import java.util.Vector;

public class ArrayListMain {

	public static void main(String[] args) {
		//��� ����
//		String[] str=new String[10];
		ArrayList<String> list=new ArrayList<>();
		//-> ���������� �迭�� ������ �ִ�
		
		for (int i=1; i<10; i++) {
			list.add("�̸�"+i);
		}
		System.out.println("������ �߰� �Ϸ�");
		
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("list: "+list);
		
		//------------------------------------------
		
		Vector<String> vec=new Vector<>();
		
		for (int i=1; i<5; i++) {
			vec.add("����"+i);
		}
		System.out.println("������ �߰� �Ϸ�");
		
		for (String s : vec) {
			System.out.println(s);
		}
		
		System.out.println("vec: "+vec);
		String str1=vec.get(1); //1��° �ִ� ������ ��������
		System.out.println("str1: "+str1);
		
		
	}//main

}//class
