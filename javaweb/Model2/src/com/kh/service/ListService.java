package com.kh.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public class ListService implements IService { // class 로 만들고 interface 상속!!!!!
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// PagingDto
		PagingDto pagingDto = new PagingDto();
		
		// searh
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		// perPage
		int perPage = 10;
		String strPerPage = request.getParameter("perPage");
		if (strPerPage != null && !strPerPage.equals("")) {
			perPage = Integer.parseInt(strPerPage);
		} 
		
		// totalCount
		int totalCount = boardDao.getTotalCount(searchType, keyword); // 필요한 것만 보내줌!!!
//		System.out.println("--"+totalCount);
		
		// page
		int page = 1;
		String strPage = request.getParameter("page"); // href="list.kh?page=${i}" 로 받음
		if (strPage != null) {
			page = Integer.parseInt(strPage);
		} 
		
		// setPagingData 메소드 PagingDto 관련 데이터 세팅 // 데이터 하다씩 세터한다고 totalPage -> page 지키던 순서 필요 없음
		pagingDto.setPagingData(searchType, keyword, perPage, totalCount, page); // 메소드 하나로 관련 데이터 다 처리
		
		
		// TODO DAO 에서 글 목록 가져오기 // 페이지, 검색에 따라서 보이는 글목록 변화 
		List<BoardVo> list = boardDao.getList(pagingDto);
		
		// TODO 해당 목록을 JSP까지 가져가야 함
		
		// TODO request 영역에 저장
		request.setAttribute("list", list);
		request.setAttribute("pagingDto", pagingDto);
//		request.setAttribute("message", request.getParameter("message"));
		
		
		// list.jsp 로 포워딩 -> /WEB-INF/views/list.jsp
		
		
		return "list";
	}

} //ListServlet
