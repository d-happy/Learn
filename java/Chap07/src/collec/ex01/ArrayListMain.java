package collec.ex01;

//Ctrl+Shift+O
import java.util.ArrayList;
import java.util.Vector;

public class ArrayListMain {

	public static void main(String[] args) {
		//목록 형식
//		String[] str=new String[10];
		ArrayList<String> list=new ArrayList<>();
		//-> 내부적으로 배열을 가지고 있다
		
		for (int i=1; i<10; i++) {
			list.add("이름"+i);
		}
		System.out.println("데이터 추가 완료");
		
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println("list: "+list);
		
		//------------------------------------------
		
		Vector<String> vec=new Vector<>();
		
		for (int i=1; i<5; i++) {
			vec.add("성명"+i);
		}
		System.out.println("데이터 추가 완료");
		
		for (String s : vec) {
			System.out.println(s);
		}
		
		System.out.println("vec: "+vec);
		String str1=vec.get(1); //1번째 있는 데이터 가져오기
		System.out.println("str1: "+str1);
		
		
	}//main

}//class
