package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public class ListService implements IService{

	BoardDao boardDao = BoardDao.getInstance();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// PagingDto
		PagingDto pagingDto = new PagingDto();
		
		// perPage
		int perPage = 10;
		String strPerPage = request.getParameter("perPage");
		if (strPerPage != null) {
			perPage = Integer.parseInt(strPerPage);
		}
		
		// search
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		// page
		int totalCount = boardDao.getTotalCount(searchType, keyword);
//		int totalPage = (int) Math.ceil((double) totalCount / 10);
		
		int page = 1;
		String strPage = request.getParameter("page");
		if (strPage != null) {
			page = Integer.parseInt(strPage);
		}
		
		// setPagingData 메소드 PagingDto 관련 데이터 세팅
		pagingDto.setPagingData(searchType, keyword, perPage, totalCount, page);
		
		// TODO dao - list get
		List<BoardVo> list = boardDao.getList(pagingDto);
		// list, pagingDto 보내기
		request.setAttribute("list", list);
		request.setAttribute("pagingDto", pagingDto);
		
		return "list";
	}

} //ListService
