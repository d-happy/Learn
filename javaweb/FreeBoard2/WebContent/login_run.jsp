<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// top.jsp 에서 받은 id, pw로
	String m_id = request.getParameter("m_id");	
	String m_pw = request.getParameter("m_pw");	

	// 데이터베이스에 있는 회원 맞나 확인하고
	MemberDao dao = MemberDao.getInstance();
	MemberVo memberVo = dao.loginMemberVo(m_id, m_pw);
	
	// 회원이 맞으면 session에 memberVo 저장
	if (memberVo != null) {
		session.setAttribute("memberVo", memberVo);
	}
	
	// 회원 여부 확인 후 list.jsp로 돌아감
	response.sendRedirect("list.jsp");
%>

