<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String m_id = memberVo.getM_id();
	
// 	System.out.println("b_no : "+ b_no);
// 	System.out.println("b_pass : "+ b_pass);
	
	BoardDao dao = BoardDao.getInstance();
	dao.deleteArticle(b_no, m_id);
	
	response.sendRedirect("list.jsp");
%>