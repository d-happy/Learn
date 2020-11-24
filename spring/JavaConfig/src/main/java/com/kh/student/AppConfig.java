package com.kh.student;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // app-ctx.xml 같은 역활
public class AppConfig {
	 
	@Bean // import 해야함!!!!
	public Person kim() { // <bean class="com.kh.student.Person" id="kim">
		String name = "김길동";
		int age = 20;
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("승마");
		hobbies.add("골프");
		Person p = new Person(name, age, hobbies); // "<c:..." 생성자 매개변수
		p.setHeight(180.5); // "<p:..." 세터로 되는 필드
		p.setWeight(80.5);
		
		return p;
	}
}
