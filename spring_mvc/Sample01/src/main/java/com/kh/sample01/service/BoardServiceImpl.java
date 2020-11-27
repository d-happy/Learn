package com.kh.sample01.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;

import org.springframework.stereotype.Service;

import com.kh.sample01.dao.BoardDao;
import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.domain.PagingDto;

@Service
public class BoardServiceImpl implements BoardService { // 메소드 오버라이드해서 구현하는 서비스 클래스
	
	@Inject
	private BoardDao boardDao; // 스프링이 아는 BoardDao @Inject해서 가져옴

	@Override
	public void insertArticle(BoardVo boardVo) {
		boardDao.insertArticle(boardVo); // boardDao가 사용하는 메소드
	}

	@Override
	public List<BoardVo> boardList(PagingDto pagingDto) {
		List<BoardVo> boardList = boardDao.boardList(pagingDto);
		return boardList;
	}

	@Override
	public BoardVo selectArticle(int b_no) {
		boardDao.updateViewCnt(b_no); // 조회수 증가
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
	
	@Override
	public int listCount(PagingDto pagingDto) {
		int count = boardDao.listCount(pagingDto);
		return count;
	}

} //BoardServiceImpl
