package com.kh.sample01.service;

import java.util.List;

import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.domain.PagingDto;

public interface BoardService { // 메소드 정의한 인터페이스
	
	//글쓰기
	public void insertArticle(BoardVo boardVo);
	
	//글 목록
	public List<BoardVo> boardList(PagingDto pagingDto);
	
	//글 조회
	public BoardVo selectArticle(int b_no);
	
	//글 수정
	public void updateArticle(BoardVo boardVo);
	
	//글 삭제
	public void deleteArticle(int b_no);
	
	//조회수 증가
	public void updateViewCnt(int b_no);
	
	//글 갯수
	public int listCount(PagingDto pagingDto);
	
}
