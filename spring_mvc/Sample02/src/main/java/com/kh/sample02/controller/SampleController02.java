package com.kh.sample02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.sample02.domain.ThingsVo;

@Controller
public class SampleController02 {
	
	@RequestMapping(value="/doB", method=RequestMethod.GET)
	public String doB() {
		System.out.println("/doB...");
		return "bbb";
	}
	
	@RequestMapping(value="/doC", method=RequestMethod.GET)
	public String doC(@ModelAttribute("hello") String hi) {
		System.out.println("/doC...");
		return "hello";
	}
	
	@RequestMapping(value="/doD", method=RequestMethod.GET)
	public String doD(Model model) {
		System.out.println("/doD...");
		
		ThingsVo thingsVo = new ThingsVo();
		thingsVo.setName("name-##");
		thingsVo.setNumber(99);
		
		model.addAttribute("vo", thingsVo);
		
		return "anan";
	}
}
