package com.kh.sample02.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.sample02.service.MemberService;

@RequestMapping(value="/member")
public class MemberController {

	private MemberService memberService;
	
}
