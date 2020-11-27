package com.kh.sample01;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.sample01.dao.BoardDao;
import com.kh.sample01.domain.BoardVo;
import com.kh.sample01.domain.PagingDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoTest {

	@Inject
	private BoardDao boardDao; // 
	
	@Test
	public void testInsertArticle() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title("제목2");
		boardVo.setB_content("내용2");
		boardVo.setUser_id("user02"); // user_01 아님!!!!!
		boardDao.insertArticle(boardVo);
		System.out.println("boardVo :" + boardVo);
	}
	
	@Test
	public void testBoardList() throws Exception {
		PagingDto pagingDto = new PagingDto();
		pagingDto.setPage(11);
		pagingDto.setPerPage(10);
		pagingDto.setSearchType("t");
		pagingDto.setKeyword("제목1");
		pagingDto.setTotalCount(boardDao.listCount(pagingDto));
		pagingDto.setPagingInfo();
		List<BoardVo> boardList = boardDao.boardList(pagingDto);
		System.out.println("boardList :" + boardList);
	}
	
	@Test
	public void testSelectArticle() throws Exception {
		BoardVo boardVo = boardDao.selectArticle(2);
		System.out.println("boardVo :" + boardVo);
	}
	
	@Test
	public void testUpdateArticle() throws Exception {
		BoardVo boardVo = new BoardVo();
		boardVo.setB_title("제목1-수정");
		boardVo.setB_content("내용1-수정");
		boardVo.setB_no(2);
		boardDao.updateArticle(boardVo);
	}
	
	@Test
	public void testDeleteArticle() throws Exception {
		boardDao.deleteArticle(13);
	}
	
	@Test
	public void testLIstCount() throws Exception {
		PagingDto pagingDto = new PagingDto();
		pagingDto.setSearchType("t"); // 검색 조건 : 제목
		pagingDto.setKeyword("10"); // 제목에 10 들어가는거
		int count = boardDao.listCount(pagingDto);
		System.out.println("count :" + count); // 15
	}
	
} //MemberDaoTest
