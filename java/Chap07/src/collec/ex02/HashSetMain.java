package collec.ex02;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetMain {
	public static void main(String[] args) {
		//데이터 중복 x
		//순서 x
		HashSet<String> mySet=new HashSet<>();
		mySet.add("체리");
		mySet.add("키위");
		mySet.add("체리");
		System.out.println(mySet);
		
		//사전형식(맵)
		//키의 중복  x, 값의 중복 o
		//순서 x
		HashMap<String, String> myMap=new HashMap<>();
		myMap.put("apple", "사과");
		myMap.put("pear", "배");
		myMap.put("apple", "사과"); //키가 같다 -> 안 들어감
		myMap.put("APPLE", "사과"); //값이 같다 -> 들어감
		System.out.println(myMap);
		
		String value=myMap.get("apple");
		System.out.println("value: "+value);
	
	}//main

}//class
