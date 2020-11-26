package com.kh.sample02.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kh.sample02.dao.BoardDao;
import com.kh.sample02.domain.BoardVo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao;

	@Override
	public void insertArticle(BoardVo boardVo) {
		boardDao.insertArticle(boardVo);
	}

	@Override
	public List<BoardVo> boardList() {
		List<BoardVo> boardList = boardDao.boardList();
		return boardList;
	}

	@Override
	public BoardVo selectArticle(int b_no) {
		boardDao.updateViewCnt(b_no);
		BoardVo boardVo = boardDao.selectArticle(b_no);
		return boardVo;
	}

	@Override
	public void updateArticle(BoardVo boardVo) {
		boardDao.updateArticle(boardVo);
	}

	@Override
	public void deleteArticle(int b_no) {
		boardDao.deleteArticle(b_no);
	}

}
