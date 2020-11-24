package com.kh.student;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Person kim() {
		String name = "김길동";
		int age = 20;
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("승마");
		hobbies.add("골프");
		Person p = new Person(name, age, hobbies);
		p.setHeight(180.5);
		p.setWeight(80.5);
		
		return p;
	}
}
