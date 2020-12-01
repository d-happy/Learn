package com.kh.sample02.dao;

import java.util.List;

import com.kh.sample02.domain.CommentVo;

public interface CommentDao {

	public List<CommentVo> getCommentList(int b_no) throws Exception;
	
	public void insertComment(CommentVo commentVo) throws Exception;
	
	public void updateComment(CommentVo commentVo) throws Exception;
	
	public void deleteComment(int c_no) throws Exception;
	
}
