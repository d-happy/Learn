package com.kh.sample02.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.sample02.domain.MemberVo;
import com.kh.sample02.service.LikeService;

@RestController
@RequestMapping(value="/like")
public class LikeController {

	@Inject
	private LikeService likeService;
	
	@RequestMapping(value="/insertLike/{b_no}", method=RequestMethod.GET)
	public String insertLike(@PathVariable("b_no") int b_no, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		String user_id = memberVo.getUser_id();
		likeService.insertLike(user_id, b_no);
		return "success2";
	};
	
	@RequestMapping(value="/deleteLike/{b_no}", method=RequestMethod.GET)
	public String deleteLike(@PathVariable("b_no") int b_no, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		String user_id = memberVo.getUser_id();
		likeService.deleteLike(user_id, b_no);
		return "success2";
	};
	
}
