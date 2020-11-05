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
	
	BoardDao dao = BoardDao.getInstance();
	int count = dao.deleteArticle(vo);
	
	if (count > 0) {
		response.sendRedirect("list.jsp");
	} 
%>