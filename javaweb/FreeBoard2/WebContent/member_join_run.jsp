<%@page import="free.board.MemberDao"%>
<%@page import="free.board.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글 가능
	// member_join_form.jsp 에서 받은 값
	String m_id = request.getParameter("m_id");
	String m_pw = request.getParameter("m_pw_join");
	String m_name = request.getParameter("m_name_join");
	
	MemberVo memberVo = new MemberVo(m_id, m_pw, m_name);
	
	// 데이터베이스로 보내서 회원 가입 시킴
	MemberDao dao = MemberDao.getInstance();
	dao.joinMemberVo(memberVo);
	
	response.sendRedirect("list.jsp");
%>