package com.kh.sample01.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.sample01.domain.CommentVo;
import com.kh.sample01.domain.MemberVo;
import com.kh.sample01.service.CommentService;

@RestController // ##.jsp 아니고 Json 형태로 객체 데이터를 반환 // 메소드 각각 안 하고 전부 다 @ResponseBody 적용됨
@RequestMapping(value="/comment")
public class CommentController {

	@Inject
	private CommentService commentService;
	
//	/comment/getCommentList?b_no=500 -> 얘는 ? 전까지가 url 이라서 뭘 대표하는지 모름 ? 뒤는 쿼리문 url 아님
//	/comment/getCommentList/500 -> Restful 대표한다? / url이 500~~ 에 대한 대표? 
//	@PathVariable("b_no") , GET -> 경로를 변수로 허용한다?!
	
	@RequestMapping(value="/getCommentList/{b_no}", method=RequestMethod.GET)
//	@ResponseBody // ##.jsp 아니고 Json 형태로 객체 데이터를 반환
	public List<CommentVo> getCommentList(@PathVariable("b_no") int b_no) throws Exception {
//		System.out.println("b_no-get :" + b_no);
		List<CommentVo> commentList = commentService.getCommentList(b_no);
		return commentList;
	}
	
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
	public String insertComment(@RequestBody CommentVo commentVo, HttpSession session) throws Exception {
		MemberVo memberVo = (MemberVo) session.getAttribute("memberVo");
		commentVo.setUser_id(memberVo.getUser_id());
		System.out.println("commentVo-insert :" + commentVo);
		commentService.insertComment(commentVo);
		return "success";
	}
	
	@RequestMapping(value="/updateComment", method=RequestMethod.POST)
	public String updateComment(@RequestBody CommentVo commentVo) throws Exception {
//		System.out.println("commentVo-update :" + commentVo);
		commentService.updateComment(commentVo);
		return "success";
	}
	
	@RequestMapping(value="/deleteComment/{b_no}/{c_no}", method=RequestMethod.GET)
	public String deleteComment(@PathVariable("b_no") int b_no,
								@PathVariable("c_no") int c_no) throws Exception {
//		System.out.println("b_no-delete :" + b_no);
//		System.out.println("c_no-delete :" + c_no);
		commentService.deleteComment(c_no);
		return "success";
	}
	
}