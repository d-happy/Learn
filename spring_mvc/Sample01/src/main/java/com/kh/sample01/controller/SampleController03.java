package com.kh.sample01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController03 {
	
	@RequestMapping(value="/doF", method=RequestMethod.GET)
	public String doF() {
		System.out.println("/doF...");
		return "redirect:doG";
	}
	
	@RequestMapping(value="/doG", method=RequestMethod.GET)
	public String doG() {
		System.out.println("/doG...");
		return "doG";
	}
	
	@RequestMapping(value="/doH", method=RequestMethod.GET)
	public String doH(RedirectAttributes rttr) {
		System.out.println("/doH...");
		rttr.addFlashAttribute("msg", "success");
		return "redirect:doI";
	}
	
	@RequestMapping(value="/doI", method=RequestMethod.GET)
	public String doI(@ModelAttribute("msg") String msg) {
		System.out.println("/doI...");
		return "doI";
	}
}
