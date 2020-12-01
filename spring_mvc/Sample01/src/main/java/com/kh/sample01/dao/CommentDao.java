package com.kh.sample01.dao;

import java.util.List;

import com.kh.sample01.domain.CommentVo;

public interface CommentDao {

	// 목록
	public List<CommentVo> getCommentList(int b_no) throws Exception;
	// 쓰기
	public void insertComment(CommentVo commentVo) throws Exception;
	// 수정
	public void updateComment(CommentVo commentVo) throws Exception;
	// 삭제
	public void deleteComment(int c_no) throws Exception;
	
}


