package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
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
		
		BoardVo boardVo = boardDao.selectByBno(b_no);
		PagingDto pagingDto = new PagingDto(perPage, page, searchType, keyword);
		request.setAttribute("boardVo", boardVo);
		request.setAttribute("pagingDto", pagingDto);
		
		return "content"; // WEB-INF/views/content.jsp
	}

} //ContentService
