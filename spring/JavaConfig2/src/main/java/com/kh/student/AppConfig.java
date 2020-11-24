package com.kh.student;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Person lee() {
		String name = "이석돌";
		int age = 44;
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("수영");
		hobbies.add("자전거");
		Person p = new Person(name, age, hobbies);
		p.setHeight(188.8);
		p.setWeight(88.8);
		
		return p;
	}
}
