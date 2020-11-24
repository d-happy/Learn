package com.kh.sample02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController01 {
	
	@RequestMapping(value="/doA", method=RequestMethod.GET)
	public void doA() {
		System.out.println("/doA...");
	}
	
}
