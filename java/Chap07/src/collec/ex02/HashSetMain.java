package collec.ex02;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetMain {
	public static void main(String[] args) {
		//������ �ߺ� x
		//���� x
		HashSet<String> mySet=new HashSet<>();
		mySet.add("ü��");
		mySet.add("Ű��");
		mySet.add("ü��");
		System.out.println(mySet);
		
		//��������(��)
		//Ű�� �ߺ�  x, ���� �ߺ� o
		//���� x
		HashMap<String, String> myMap=new HashMap<>();
		myMap.put("apple", "���");
		myMap.put("pear", "��");
		myMap.put("apple", "���"); //Ű�� ���� -> �� ��
		myMap.put("APPLE", "���"); //���� ���� -> ��
		System.out.println(myMap);
		
		String value=myMap.get("apple");
		System.out.println("value: "+value);
	
	}//main

}//class
