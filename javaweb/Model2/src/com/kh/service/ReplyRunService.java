package com.kh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.dao.BoardDao;
import com.kh.domain.BoardVo;
import com.kh.domain.MemberVo;
import com.kh.domain.PagingDto;
import com.kh.util.QueryStringMaker;

public class ReplyRunService implements IService {
	
	private BoardDao boardDao = BoardDao.getInstance();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 페이징 데이터
		int page = Integer.parseInt(request.getParameter("page"));
		int perPage = Integer.parseInt(request.getParameter("perPage"));
		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");
		
		// 글 데이터
		int re_group = Integer.parseInt(request.getParameter("re_group"));
		int re_seq = Integer.parseInt(request.getParameter("re_seq"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
//		String m_id = request.getParameter("m_id");
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
		String m_id = memberVo.getM_id();
		
		BoardVo boardVo = new BoardVo();
		boardVo.setRe_group(re_group);
		boardVo.setRe_seq(re_seq);
		boardVo.setRe_level(re_level);
		boardVo.setB_title(b_title);
		boardVo.setB_content(b_content);
		boardVo.setM_id(m_id);
		
		int count = boardDao.replyArticle(boardVo);
//		HttpSession session = request.getSession();
		if (count > 0) {
			session.setAttribute("message", "reply_success");
		}
		
		// redirect: 여기서 얻은 데이터 굳이 넘길 필요 없음 (MyFrontController에서 확인)
//		return "redirect:list.kh";
		PagingDto pagingDto = new PagingDto(page, perPage, searchType, keyword);
		String strQuery = QueryStringMaker.makePagingQuery(pagingDto, true);
		return "redirect:list.kh" + strQuery;
	} //execute

} //ReplyRunService
