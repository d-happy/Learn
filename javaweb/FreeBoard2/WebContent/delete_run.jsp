<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String m_id = ((MemberVo)session.getAttribute("memberVo")).getM_id();
	
	BoardVo vo = new BoardVo();
	vo.setB_no(b_no);
	vo.setM_id(m_id);
	
	// b_no랑 m_id 확인해서 맞으면 db 에서 해당 글 삭제하기
	BoardDao dao = BoardDao.getInstance();
	int count = dao.deleteArticle(vo);
	
	// 0 보다 큰 수면 삭제 제대로 됨 -> list.jsp 이동
	if (count > 0) {
		response.sendRedirect("list.jsp");
	} 
%>