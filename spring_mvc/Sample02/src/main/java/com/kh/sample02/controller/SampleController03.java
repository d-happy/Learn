package com.kh.sample02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController03 {
	
	@RequestMapping(value="/doE", method=RequestMethod.GET)
	public String doE() {
		System.out.println("doE...");
		return "redirect:doF";
	}
	
	@RequestMapping(value="/doF", method=RequestMethod.GET)
	public String doF() {
		System.out.println("doF...");
		return "doF";
	}
}
