package com.kh.sample01.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.sample01.domain.MemberVo;
import com.kh.sample01.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	/*@RequestMapping(value="/memberJoinRun", method=RequestMethod.POST)
	@ResponseBody
	public String checkMember(@RequestBody String user_id) throws Exception {
		MemberVo memberVo = memberService.memberJoinRun(user_id);
		System.out.println("user_id :" + user_id + " | memberVo :" + memberVo);
		String result = "join";
		if (memberVo == null) {
			result = "not join";
		}
		return result;
	}*/
	
}
