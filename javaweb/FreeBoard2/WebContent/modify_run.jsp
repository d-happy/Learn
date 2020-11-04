<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int b_no = Integer.parseInt(request.getParameter("b_no"));
	String b_title = request.getParameter("b_title");
	String b_writer = request.getParameter("b_writer");
	String b_pass= request.getParameter("b_pass");
	String b_content= request.getParameter("b_content");

	BoardVo vo = new BoardVo();
	vo.setB_no(b_no);
	vo.setB_title(b_title);
	vo.setB_writer(b_writer);
	vo.setB_pass(b_pass);
	vo.setB_content(b_content);
	
	BoardDao dao = BoardDao.getInstance();
	dao.modifyArticle(vo);
	
	response.sendRedirect("list.jsp");
%>