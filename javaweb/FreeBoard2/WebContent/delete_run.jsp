<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String b_pass= request.getParameter("b_pass");
	
	BoardVo vo = new BoardVo();
	vo.setB_no(b_no);
	vo.setB_pass(b_pass);
	
	BoardDao dao = BoardDao.getInstance();
	dao.deleteArticle(vo);
	
	response.sendRedirect("list.jsp");
%>