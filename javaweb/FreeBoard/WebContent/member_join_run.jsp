<%@page import="free.board.MemberVo"%>
<%@page import="free.board.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String m_id = request.getParameter("m_id");
	String m_pw = request.getParameter("m_pw");
	String m_name = request.getParameter("m_name");

	MemberVo memberVo = new MemberVo(m_id, m_pw, m_name);
	
	MemberDao dao = MemberDao.getInstance();
	int count = dao.joinMember(memberVo);
	
	if(count > 0) {
%>
		<script>
			alert("회원 가입 완료");
			location.href="list.jsp";
		</script>
<%
	} else {
%>
		<script>
			alert("회원 가입 실패");
			location.href="member_join_form.jsp";
		</script>
<%
	} //if
%>