package com.kh.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.dao.ConnectionManager;
import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public class ContentService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		int page = Integer.parseInt(request.getParameter("page"));
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		
		Connection conn = ConnectionManager.getConnection();
		boardDao.setConnection(conn);
		BoardVo boardVo = boardDao.selectByBno(b_no, true); // 조회수 증가
		
		request.setAttribute("pagingDto", pagingDto);
		request.setAttribute("boardVo", boardVo);
//		System.out.println(boardVo.toString());
		
		ConnectionManager.close(conn);
		return "content"; // WEB-INF/views/content.jsp
	} //execute

} //ContentService