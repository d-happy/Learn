package com.kh.sample01.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.sample01.domain.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	private static final String NAMESPACE = "com.kh.sample01.board.";
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void insertArticle(BoardVo boardVo) {
		sqlSession.insert(NAMESPACE + "insertArticle", boardVo);
	}

	@Override
	public List<BoardVo> boardList() { // selectList : List<> 리턴 가능
		List<BoardVo> list = sqlSession.selectList(NAMESPACE + "boardList");
		return list;
	}

	@Override
	public BoardVo selectArticle(int b_no) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "selectArticle", b_no);
		return boardVo;
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		sqlSession.update(NAMESPACE + "updateArticle", boardVo);
	}

	@Override
	public void deleteArticle(int b_no) {
		sqlSession.delete(NAMESPACE + "deleteArticle", b_no);
	}

}
