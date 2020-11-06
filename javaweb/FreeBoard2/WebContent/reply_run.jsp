<%@page import="free.board.MemberVo"%>
<%@page import="free.board.BoardVo"%>
<%@page import="free.board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
// 	int b_no     = Integer.parseInt(request.getParameter("b_no")); // 굳이 필요 없음...
	int re_group = Integer.parseInt(request.getParameter("re_group"));
	int re_seq   = Integer.parseInt(request.getParameter("re_seq"));
	int re_level = Integer.parseInt(request.getParameter("re_level"));
	
	String b_title = request.getParameter("b_title");
	String b_content = request.getParameter("b_content");
	String m_id = ((MemberVo)session.getAttribute("memberVo")).getM_id();
	String b_ip = request.getRemoteAddr();
	
	BoardVo boardVo = new BoardVo();
	boardVo.setRe_group(re_group);
	boardVo.setRe_seq(re_seq);
	boardVo.setRe_level(re_level);
	boardVo.setB_title(b_title);
	boardVo.setB_content(b_content);
	boardVo.setM_id(m_id);
	boardVo.setB_ip(b_ip);
	
	BoardDao boardDao = BoardDao.getInstance();
	int count = boardDao.reply(boardVo);
	
	if (count > 0) {
%>
		<script>
			alert("답글 등록 완료 짝짝짝짜짝짝짝");
			location.href="list.jsp";
		</script>
<%
	} else {
%>
		<script>
			alert("답글 등록 실패...!!!!!");
			location.href="list.jsp";
		</script>
<%		
	}//if
%>