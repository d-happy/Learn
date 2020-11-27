package com.kh.sample02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.sample02.domain.BoardVo;
import com.kh.sample02.domain.PagingDto;

@Service
public interface BoardService {
	
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
	
	//글 갯수
	public int listCount(PagingDto pagingDto);
}
