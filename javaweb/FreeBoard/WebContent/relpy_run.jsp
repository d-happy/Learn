<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="include/login_check.jsp" %>

<%
	request.setCharacterEncoding("utf-8");
	int re_group = Integer.parseInt(request.getParameter("re_group"));
	int re_sequence = Integer.parseInt(request.getParameter("re_sequence"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
	String b_title = request.getParameter("b_title");
	String b_content = request.getParameter("b_content");
	String b_ip = request.getRemoteAddr();
	MemberVo memberVo = (MemberVo)session.getAttribute("memberVo");
	String m_id = memberVo.getM_id();

	BoardVo boardVo = new BoardVo();
	boardVo.setRe_group(re_group);
	boardVo.setRe_sequence(re_sequence);
	boardVo.setRe_level(re_level);
	boardVo.setB_title(b_title);
	boardVo.setB_content(b_content);
	boardVo.setB_ip(b_ip);
	boardVo.setM_id(m_id);
	
	BoardDao boardDao = BoardDao.getInstance();
	int count = boardDao.reply(boardVo);
	
	if (count > 0) {
%>
		<script>
			alert("답글 등록 완료");
			location.href="list.jsp";
		</script>
<%
	} else {
		%>
		<script>
			alert("답글 등록 실패");
			location.href="list.jsp";
		</script>
<%		
	}//if
%>