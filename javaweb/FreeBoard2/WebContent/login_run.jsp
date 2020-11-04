<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String m_id = request.getParameter("m_id");	
	String m_pw = request.getParameter("m_pw");	

	MemberDao dao = MemberDao.getInstance();
	MemberVo memberVo = dao.loginMemberVo(m_id, m_pw);
	
	if (memberVo != null) {
		session.setAttribute("memberVo", memberVo);
	}
	
	response.sendRedirect("list.jsp");
%>

