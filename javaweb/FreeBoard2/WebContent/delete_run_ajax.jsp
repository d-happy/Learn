<%@page import="free.board.BoardDao"%>
<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
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
	
	// 삭제 여부 상관없이 출력? -> content.jsp에서 $.post로 보내서 count 받아옴
	out.print(count);
// 	if (count > 0) { }
%>