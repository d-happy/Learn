<%@page import="free.board.CommentDao"%>
<%@page import="free.board.CommentVo"%>
<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String c_content = request.getParameter("c_content");
	int b_no = Integer.parseInt(request.getParameter("b_no"));	

	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String m_id = memberVo.getM_id();
	
	CommentVo commentVo = new CommentVo();
	commentVo.setC_content(c_content);
	commentVo.setB_no(b_no);
	commentVo.setM_id(m_id);
	
	CommentDao commentDao = CommentDao.getInstance();
	int count = commentDao.insertComment(commentVo);
	out.print(count);
%>