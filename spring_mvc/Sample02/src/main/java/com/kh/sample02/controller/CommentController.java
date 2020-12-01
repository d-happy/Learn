package com.kh.sample02.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kh.sample02.domain.CommentVo;
import com.kh.sample02.service.CommentService;

@RestController
@RequestMapping(value="/comment")
public class CommentController {

	@Inject
	private CommentService commentService;
	
	@RequestMapping(value="/getCommentList/{b_no}", method=RequestMethod.GET)
//	@ResponseBody
	public List<CommentVo> getCommentList(@PathVariable("b_no")int b_no) throws Exception {
		System.out.println("b_no :" + b_no);
		List<CommentVo> commentList = commentService.getCommentList(b_no);
		return commentList;
	}
	
	@RequestMapping(value="/insertComment", method=RequestMethod.POST)
//	@ResponseBody
	public String insertComment(@RequestBody CommentVo commentVo) throws Exception {
		System.out.println("commentVo :" + commentVo);
		commentService.insertComment(commentVo);
		return "success2";
	}
	
	@RequestMapping(value="/updateComment", method=RequestMethod.POST)
	public String updateComment(@RequestBody CommentVo commentVo) throws Exception {
		System.out.println("commentVo-update :" + commentVo);
		commentService.updateComment(commentVo);
		return "success2";
	}

	@RequestMapping(value="/deleteComment/{b_no}/{c_no}", method=RequestMethod.GET)
	public String deleteComment(@PathVariable("b_no") int b_no,
								@PathVariable("c_no") int c_no) throws Exception {
		System.out.println("b_no :" + b_no);
		System.out.println("c_no :" + c_no);
		commentService.deleteComment(c_no);
		return "success2";
	}
	
}
