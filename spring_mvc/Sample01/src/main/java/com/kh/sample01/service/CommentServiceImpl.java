package com.kh.sample01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample01.dao.CommentDao;
import com.kh.sample01.domain.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDao commentDao;

	@Override
	public List<CommentVo> getCommentList(int b_no) throws Exception {
		List<CommentVo> commentList = commentDao.getCommentList(b_no);
		return commentList;
	}

	@Override
	public void insertComment(CommentVo commentVo) throws Exception {
		commentDao.insertComment(commentVo);
	}

	@Override
	public void updateComment(CommentVo commentVo) throws Exception {
		commentDao.updateComment(commentVo);
	}

	@Override
	public void deleteComment(int c_no) throws Exception {
		commentDao.deleteComment(c_no);
	}

}
