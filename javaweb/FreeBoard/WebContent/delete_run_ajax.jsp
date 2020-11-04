<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String m_id = memberVo.getM_id();
	
	BoardDao dao = BoardDao.getInstance();
	int count = dao.deleteArticle(b_no, m_id);
// 	out.println(conut);
	
	response.sendRedirect("list.jsp");
%>
<%= count %>