package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.dao.BoardDao;
import com.kh.dao.ConnectionManager;
import com.kh.domain.BoardVo;
import com.kh.domain.PagingDto;

public class ReplyFormService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// content.jsp에서 받은 b_no
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		// boardVo 새로 하나 만들고
		boardDao.setConnection(ConnectionManager.getConnection());
		BoardVo boardVo = boardDao.selectByBno(b_no, false); // 조회수 증가 X
		// boardVo라는 이름으로 넣어서 reply_form.jsp로 보냄
		request.setAttribute("boardVo", boardVo);
		
		// content.jsp에서 받아서 ReplyFormService에서  pagingDto 만들어 보냄 
		// content -> ReplyFormService -> reply_form -> ReplyRunService -> list 로 이동....
		int page = Integer.parseInt(request.getParameter("page"));
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		request.setAttribute("pagingDto", pagingDto);
		
		ConnectionManager.close(ConnectionManager.getConnection());
		return "reply_form"; // 이동할 곳에서 request에 저장한 boardVo 필요함 
	} //execute

} //ReplyFormService