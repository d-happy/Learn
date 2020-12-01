package com.kh.sample01.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample01.domain.CommentVo;

@Repository
public class CommentDaoImpl implements CommentDao {
	
	private final String NAMESPACE = "com.kh.sample01.comment.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<CommentVo> getCommentList(int b_no) throws Exception {
		List<CommentVo> commentList = sqlSession.selectList(NAMESPACE + "getCommentList", b_no);
		return commentList;
	}

	@Override
	public void insertComment(CommentVo commentVo) throws Exception {
		sqlSession.insert(NAMESPACE + "insertComment", commentVo);
	}

	@Override
	public void updateComment(CommentVo commentVo) throws Exception {
		sqlSession.update(NAMESPACE + "updateComment", commentVo);
	}

	@Override
	public void deleteComment(int c_no) throws Exception {
		sqlSession.delete(NAMESPACE + "deleteComment", c_no);
	}

} //CommentDao
